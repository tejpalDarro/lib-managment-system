FROM maven:3.8.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

COPY . eureka-service/

RUN mvn clean package -f eureka-service/pom.xml -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/eureka-service/EurekaApp/EurekaStartup/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]
