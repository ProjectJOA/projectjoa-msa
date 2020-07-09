FROM marceldekoster/alpine-oracle-jdk-8
RUN apk update
RUN apk --no-cache add curl
RUN apk add --update git

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

ADD projectjoa-eureka*.jar /opt/app/app.jar
#RUN bash -c 'touch /app.jar'

# Expose
EXPOSE 9065

#ENTRYPOINT ["java","-jar","/opt/app/app.jar"]