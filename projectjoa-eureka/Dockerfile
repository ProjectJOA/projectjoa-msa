FROM openjdk:8u252-jdk-buster

ENV PATH /usr/local/bin:/sbin:$PATH

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p /opt/app
RUN curl -o /opt/app/app.jar https://raw.githubusercontent.com/ProjectJOA/projectjoa-msa/master/libs/projectjoa-eureka-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /opt/app/app.jar'

# Expose
EXPOSE 9065

ENTRYPOINT java -jar -DEUREKA_SERVER_URL=$EN_EUREKA_SERVER_URL -DPORT=$EN_EUREKA_PORT /opt/app/app.jar