FROM openjdk:17
MAINTAINER Marcio Rodrigo
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]