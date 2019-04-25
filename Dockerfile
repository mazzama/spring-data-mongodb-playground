FROM openjdk:8-jdk-alpine

RUN apk update && apk add bash
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY ./target/learn-spring-mongodb-0.0.1-SNAPSHOT.jar $PROJECT_HOME/learn-spring-mongodb-0.0.1-SNAPSHOT.jar
WORKDIR $PROJECT_HOME
CMD ["java","-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/springmongo-demo","-jar","./learn-spring-mongodb-0.0.1-SNAPSHOT.jar"]