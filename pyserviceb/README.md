# pyserviceb

## Description
Service B - python django

## Docker image 만들기
mysqldb container 실행, projectjoa-eureka 실행후 django를 실행한다.

``` bash
docker build . -t projectjoa-pyserviceb
```

### docker image로 container 생성하기
```
docker run -it --name projectjoa-pyserviceb -p 9094:9094 -v c:\volume_test:/data -e EN_EUREKA_SERVER_URL=172.17.0.3 -e SQL_HOST=172.17.0.2 -e SQL_PORT=3306 -e SQL_DATABASE=employees -e SQL_USER=root -e SQL_PASSWORD=1234qwer projectjoa-pyserviceb:latest bash

/*
 * EN_EUREKA_SERVER_URL : eureka server ip
 * SQL_HOST : mysql DB ip
 * SQL_PORT : mysql DB port
 * SQL_DATABASE : mysql database
 * SQL_USER : mysql db user
 * SQL_PASSWORD : password
*/

# 생성된 container 접속하기
docker exec -it projectjoa-pyserviceb bash
```

### dockerhub에 images push하기
```
docker tag bfa1c2857a67 projectjoa/projectjoa-pyserviceb:latest
docker push projectjoa/projectjoa-pyserviceb

The push refers to repository [docker.io/projectjoa/projectjoa-pyserviceb]

8e41c1a5b12c: Pushing [==================================================>]  31.74kB
b45ffb2e78ff: Pushing [==================================================>]  32.77kB
6d56b8c76d9c: Pushing [=============>                                     ]  13.24MB/47.79MB
dfad14e86c05: Pushing [==================================>                ]  17.81MB/25.93MB
....                                                
```