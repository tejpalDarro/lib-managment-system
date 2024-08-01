FROM maven:3.8.6-eclipse-temurin-17-alpine AS build
WORKDIR /app


COPY . transaction-service/


RUN mvn clean package -f transaction-service/pom.xml -DskipTests


FROM openjdk:17-jdk-slim

WORKDIR /app



COPY --from=build /app/transaction-service/transactionApp/TransactionStartup/target/*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]
