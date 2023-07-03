

FROM openjdk:22-slim

LABEL Marcio Rodrigo

WORKDIR /app

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar", "app.jar"]

COPY src ./src

EXPOSE 8081

CMD ["./gradlew", "spring-boot:run"]