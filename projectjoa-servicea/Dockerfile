FROM openjdk:8u252-jdk-buster

ENV PATH /usr/local/bin:/sbin:$PATH

######
#ENV EN_EUREKA_SERVER_URL 172.17.0.3
#ENV SQL_HOST 172.17.0.2
#ENV SQL_PORT 3306
#ENV SQL_DATABASE employees
#ENV SQL_USER root
#ENV SQL_PASSWORD 1234qwer
######

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*
    
RUN mkdir -p /opt/app
RUN curl -o /opt/app/app.jar https://raw.githubusercontent.com/ProjectJOA/projectjoa-msa/master/libs/projectjoa-servicea-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /opt/app/app.jar'

# Expose
EXPOSE 9090

ENTRYPOINT java -jar -DEUREKA_SERVER_URL=$EN_EUREKA_SERVER_URL -DSQL_HOST=$SQL_HOST -DSQL_PORT=$SQL_PORT -DSQL_DATABASE=$SQL_DATABASE -DSQL_USER=$SQL_USER -DSQL_PASSWORD=$SQL_PASSWORD /opt/app/app.jar