# projectjoa-eureka

## Description
Eureka Server

## ���� pc���� project �׽�Ʈ �ϱ�
projectjoa-eureka �ٿ�ε� �޾Ƽ� root ���丮���� gradlew ����

``` bash
gradlew bootJar
```

���丮�� �Ʒ� jar ������ �����ȴ�.
```
projectjoa-eureka
 |-- projectjoa-eureka-0.0.1-SNAPSHOT.jar
```
 
������� jar �� Ȯ���Ѵ�.
```
java -jar projectjoa-eureka-0.0.1-SNAPSHOT.jar
```
## Docker image �����

Dockerfile�� �����ؼ� image�� �����Ѵ�.
``` bash
docker build . -t projectjoa-eureka

ending build context to Docker daemon  15.42MB
Step 1/21 : FROM openjdk:8u252-jdk-buster
 ---> b190ad78b520
Step 2/21 : ENV PATH /usr/local/bin:/sbin:$PATH
 ---> Using cache
 ---> f64f6d8456ff
Step 3/21 : RUN apt-get update

.......

# docker image�� container �����ϱ�
docker run --name projectjoa-eureka -p 9065:9065 projectjoa-eureka:latest
# ������ container �����ϱ�
docker exec -it projectjoa-eureka bash

```

