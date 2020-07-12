# pyserviceb

## Description
Service B - python django

## Docker image �����
mysqldb container ����, projectjoa-eureka ������ django�� �����Ѵ�.

``` bash
docker build . -t projectjoa-pyserviceb
```

### docker image�� container �����ϱ�
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

# ������ container �����ϱ�
docker exec -it projectjoa-pyserviceb bash
```