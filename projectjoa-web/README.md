# projectjoa-nginx

## Description
projectjoa-web html 파일

### Docker image 만들기
```
Dockerfile을 빌드해서 image를 생성한다.
``` bash
docker build . -t projectjoa-nginx

Sending build context to Docker daemon  9.728kB
Step 1/6 : FROM nginx:1.14.2
 ---> 295c7be07902
Step 2/6 : ENV PATH /usr/local/bin:/usr/sbin:/sbin:$PATH
 ---> Running in 6cd9459868db
.......
```

### dockerhub에 images push하기
```
docker tag 5a3e7161b085 projectjoa/projectjoa-nginx:latest
docker push projectjoa/projectjoa-nginx
The push refers to repository [docker.io/projectjoa/projectjoa-nginx]
348e1da1708d: Pushing [==================================================>]  6.656kB                                    2ce33cd22ebe: Pushing [===================>                               ]  6.145MB/15.88MB                            ...                                                         
```