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

### alpine apk
#RUN apk update 
#RUN apk upgrade
#RUN apk add --update git
### alpine apk

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install git -y

RUN mkdir -p /opt/app
WORKDIR /opt/app
RUN git config --system core.sparseCheckout true
RUN git init
RUN git remote add -f origin https://github.com/ProjectJOA/projectjoa-msa.git
RUN echo "projectjoa-servicea/">>.git/info/sparse-checkout
RUN git pull origin master
WORKDIR /opt/app/projectjoa-servicea
RUN chmod 744 gradlew
RUN ./gradlew bootJar

RUN mv ./projectjoa-servicea*.jar /opt/app/app.jar
RUN bash -c 'touch /opt/app/app.jar'

WORKDIR /opt/app
RUN rm -rf ./projectjoa-servicea

# Expose
EXPOSE 9090

ENTRYPOINT java -jar -DEUREKA_SERVER_URL=$EN_EUREKA_SERVER_URL -DSQL_HOST=$SQL_HOST -DSQL_PORT=$SQL_PORT -DSQL_DATABASE=$SQL_DATABASE -DSQL_USER=$SQL_USER -DSQL_PASSWORD=$SQL_PASSWORD /opt/app/app.jar