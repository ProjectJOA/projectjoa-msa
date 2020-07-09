# projectjoa-eureka

## Description
Eureka Server

## Docker image 만들기
projectjoa-eureka 다운로드 받아서 root 디렉토리에서 gradlew 실행

``` bash
gradlew bootJar
```

디렉토리에 아래 jar 파일이 생성된다.
```
projectjoa-eureka
 - projectjoa-eureka-0.0.1-SNAPSHOT.jar
```
 
만들어진 jar 를 확인한다.
```
java -jar projectjoa-eureka-0.0.1-SNAPSHOT.jar
```

Dockerfile을 빌드해서 image를 생성한다.
``` bash
> docker build . -t projectjoa-eureka
```