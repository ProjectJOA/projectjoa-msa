FROM openjdk:8u252-jdk-buster
ENV PATH /usr/local/bin:/sbin:$PATH

### alpine apk
#RUN apk update 
#RUN apk upgrade
#RUN apk add --update git
### alpine apk

RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install git -y

RUN mkdir -p /opt/app
WORKDIR /opt/app
RUN git config --system core.sparseCheckout true
RUN git init
RUN git remote add -f origin https://github.com/ProjectJOA/projectjoa-msa.git
RUN echo "projectjoa-eureka/">>.git/info/sparse-checkout
RUN git pull origin master
WORKDIR /opt/app/projectjoa-eureka
RUN chmod 744 gradlew
RUN ./gradlew bootJar

RUN mv ./projectjoa-eureka*.jar /opt/app/app.jar
RUN bash -c 'touch /opt/app/app.jar'

WORKDIR /opt/app
RUN rm -rf ./projectjoa-eureka

# Expose
EXPOSE 9065

ENTRYPOINT ["java","-jar","/opt/app/app.jar","&"]