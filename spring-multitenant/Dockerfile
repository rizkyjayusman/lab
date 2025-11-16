FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/spring-multischema-router.jar spring-multischema-router.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "spring-multischema-router.jar"]
