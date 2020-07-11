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
RUN echo "projectjoa-apigw/">>.git/info/sparse-checkout
RUN git pull origin master
WORKDIR /opt/app/projectjoa-apigw
RUN chmod 744 gradlew
RUN ./gradlew bootJar

RUN mv ./projectjoa-apigw*.jar /opt/app/app.jar
RUN bash -c 'touch /opt/app/app.jar'

WORKDIR /opt/app
RUN rm -rf ./projectjoa-apigw

# Expose
EXPOSE 9999

ENTRYPOINT java -jar -DEUREKA_SERVER_URL=$EN_EUREKA_SERVER_URL /opt/app/app.jar