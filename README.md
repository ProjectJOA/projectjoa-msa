# projectjoa-msa

Gradle 2.3.1

### Description
Kubenetes로 Microservice Archetecture 배포하기

### 사전준비
projectjoa-msa 서브모듈 이미지 생성하기
 - 각 서브모듈별 Readme 파일 참조

## Microservice 배포하기

### Mysql 컨테이너 생성

``` bash
# mysql용 volume 생성
$ kubectl apply -f pv-claim.yml

persistentvolume/mysql-pv-volume created
persistentvolumeclaim/mysql-pv-claim created

# mysql용 secret 생성
$ kubectl apply -f mysql-secret.yml
secret/mysql-credential created

# mysql pod 생성
$ kubectl apply -f mysql-deployment.yml
deployment.apps/mysql created

$ kubectl get pod -o wide
NAME                     READY   STATUS    RESTARTS   AGE   IP               NODE            NOMINATED NODE   READINESS GATES
mysql-7dd94bd887-d5zs4   1/1     Running   0          40s   172.30.199.142   10.144.212.86   <none>           <none>

$ kubectl exec -it mysql-7dd94bd887-d5zs4 bash
# sample data는 github의 mysql/data 디렉토리에서 받아온다.
root@mysql-7dd94bd887-d5zs4:/# mysql -u root -p < /sampledata/employees.sql

Enter password:
INFO
CREATING DATABASE STRUCTURE
INFO
storage engine: InnoDB
INFO
LOADING departments
INFO
LOADING employees
....

``` 

### Eureka 컨테이너 생성
Service Repository 로써 고정된 주소가 필요함으로. External IP 와 NodePort 를 configMap 에 등록해서 다른 컨테이너의 app 에서 참조할 수 있도록 구성한다.

``` bash
# external ip 등 공통으로 사용되는 정보를 configmap으로 생성한다.
$ kubectl apply -f projectjoa-msa-configmap.yml
configmap/projectjoa-msa-config created

# eureka 컨테이너를 생성한다.
# 서브 모듈들의 접속 상태를 확인할 수 있어야 함으로 nodeport 타입의 Service로 외부에서 접속 가능하도록 구성한다.
$ kubectl apply -f projectjoa-eureka.yml
deployment.apps/projectjoa-eureka-depl created
service/projectjoa-eureka-svc created

$ kubectl get pod
NAME                                      READY   STATUS              RESTARTS   AGE
mysql-7dd94bd887-d5zs4                    1/1     Running             0          27m
projectjoa-eureka-depl-5dd5c7ddc5-qfpxl   1/1     Running   		  0          27s
```
### api application 들을 컨테이너 생성
configmap에 등록된 eureka 컨테이너의 External IP, Port를 참조하여 api application들의 컨테이너를 생성한다.
api application 컨테이너들은 이중화를 위해 replicaset으로 2개의 pod씩 생성한다.

``` bash
# serviceA api application 을 생성한다.
$ kubectl apply -f projectjoa-servicea.yml
deployment.apps/projectjoa-servicea-depl created
service/projectjoa-servicea-svc created

# python api application 인 pyserviceB 를 생성한다.
$ kubectl apply -f projectjoa-pyserviceb.yml
deployment.apps/projectjoa-pyserviceb-depl created
service/projectjoa-pyserviceb-svc created

$ kubectl get pod
NAME                                          READY   STATUS              RESTARTS   AGE
mysql-7dd94bd887-d5zs4                        1/1     Running             0          29m
projectjoa-eureka-depl-5dd5c7ddc5-qfpxl       1/1     Running             0          2m33s
projectjoa-pyserviceb-depl-68f499cffb-48fjf   0/1     ContainerCreating   0          38s
projectjoa-pyserviceb-depl-68f499cffb-pbztv   0/1     ContainerCreating   0          38s
projectjoa-servicea-depl-84d9f9bc44-dn9ws     1/1     Running             0          64s
projectjoa-servicea-depl-84d9f9bc44-j8wkp     1/1     Running             0          64s
```

### api gateway 컨테이너 생성
Service Discovery 로써 eureka 컨테이너를 참조하며, api gateway 정상적으로 역할을 수행하는지 확인하기 위해 nodeport 타입으로 생성한다.

``` bash
# api gateway 생성
$ kubectl apply -f projectjoa-apigw.yml
deployment.apps/projectjoa-apigw-depl created
service/projectjoa-apigw-svc created

$ kubectl get pod
NAME                                          READY   STATUS             RESTARTS   AGE
mysql-7dd94bd887-d5zs4                        1/1     Running            0          34m
projectjoa-apigw-depl-675b9684ff-tcrmx        1/1     Running            0          36s
projectjoa-eureka-depl-5dd5c7ddc5-qfpxl       1/1     Running            0          7m18s
projectjoa-pyserviceb-depl-68f499cffb-48fjf   0/1     CrashLoopBackOff   5          5m23s
projectjoa-pyserviceb-depl-68f499cffb-pbztv   0/1     CrashLoopBackOff   5          5m23s
projectjoa-servicea-depl-84d9f9bc44-dn9ws     1/1     Running            0          5m49s
projectjoa-servicea-depl-84d9f9bc44-j8wkp     1/1     Running            0          5m49s
```

### Nginx 컨테이너 생성
사용자들이 접속하는 web page를 제공하는 nginx를 생성한다.
nginx의 설정은 configmap으로 구성하며, configmap 타입의 volume으로 nignx 설정을 적용한다.

``` bash
# nginx 설정파일을 위한 configmap 을 생성한다.
$ kubectl apply -f projectjoa-nginx-configmap.yml
configmap/projectjoa-nginx-configmap created

# nginx 컨테이너를 생성한다.
$ kubectl apply -f projectjoa-web-nginx.yml
deployment.apps/projectjoa-nginx-depl created
service/nginx-svc created

$ kubectl get pod
NAME                                          READY   STATUS             RESTARTS   AGE
mysql-7dd94bd887-d5zs4                        1/1     Running            0          35m
projectjoa-apigw-depl-675b9684ff-tcrmx        1/1     Running            0          112s
projectjoa-eureka-depl-5dd5c7ddc5-qfpxl       1/1     Running            0          8m34s
projectjoa-nginx-depl-856759749-95xtt         1/1     Running            0          22s
projectjoa-pyserviceb-depl-68f499cffb-48fjf   0/1     CrashLoopBackOff   5          6m39s
projectjoa-pyserviceb-depl-68f499cffb-pbztv   0/1     CrashLoopBackOff   5          6m39s
projectjoa-servicea-depl-84d9f9bc44-dn9ws     1/1     Running            0          7m5s
projectjoa-servicea-depl-84d9f9bc44-j8wkp     1/1     Running            0          7m5s
```


