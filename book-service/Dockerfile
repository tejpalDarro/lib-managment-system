FROM maven:3.8.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

#COPY pom.xml book-service/
COPY . book-service/
#COPY kafka/pom.xml book-service/kafka/
#COPY bookDocker/pom.xml book-service/bookDocker/
#COPY app/pom.xml book-service/app/
#
#COPY app/domain/pom.xml book-service/app/domain
#COPY app/endpoints/pom.xml book-service/app/endpoints
#COPY app/repository/pom.xml book-service/app/repository/
#COPY app/services/pom.xml book-service/app/services/
#COPY app/startup/pom.xml book-service/app/startup/
#
#COPY app/domain/src /app/book-service/app/domain/src
#COPY app/endpoints/src book-service/app/endpoints/src
#COPY app/repository/src /app/book-service/app/repository/src
#COPY app/services/src /app/book-service/app/services/src
#COPY app/startup/src /app/book-service/app/startup/src

RUN mvn clean package -f book-service/pom.xml -DskipTests

# stage 2
FROM openjdk:17-jdk-slim

WORKDIR /app

#RUN ls -l /app/book-service/app/startup/target

COPY --from=build /app/book-service/app/startup/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
