FROM maven:3.8.6-eclipse-temurin-17-alpine AS build
WORKDIR /app


COPY . libuser-service/


RUN mvn clean package -f libuser-service/pom.xml -DskipTests


FROM openjdk:17-jdk-slim

WORKDIR /app



COPY --from=build /app/libuser-service/appUser/startups/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
