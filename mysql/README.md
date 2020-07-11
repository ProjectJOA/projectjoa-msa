# mysql data

## Description
아래는 docker 에서 standalone 형식의 mysql 생성시 사용한다.

## docker container 생성

docker hub에서 mysql의 이미지를 받아서 가상환경을 생성한다.
``` bash
> docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234qwer  -v c:\volume_test:/data  --name mysqldb mysql

> docker exec -it mysqldb bash
```

생성된 가상환경에 접속하여 sample 데이타를 생성한다.
``` bash
$ mysql -h 127.0.0.1 -u root -p -P 3306 < /data/mysql/employees.sql
```
