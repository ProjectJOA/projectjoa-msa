# projectjoa-eureka

## Description
Eureka Server

## 로컬 pc에서 project 테스트 하기
projectjoa-eureka 다운로드 받아서 root 디렉토리에서 gradlew 실행

``` bash
gradlew bootJar
```

디렉토리에 아래 jar 파일이 생성된다.
```
projectjoa-eureka
 |-- projectjoa-eureka-0.0.1-SNAPSHOT.jar
```
 
만들어진 jar 를 확인한다.
```
java -jar projectjoa-eureka-0.0.1-SNAPSHOT.jar
```
## Docker image 만들기

Dockerfile을 빌드해서 image를 생성한다.
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

# docker image로 container 생성하기
docker run --name projectjoa-eureka -p 9065:9065 -e EN_EUREKA_SERVER_URL=127.0.0.1 projectjoa-eureka:latest
# 생성된 container 접속하기
docker exec -it projectjoa-eureka bash

```

