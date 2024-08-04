FROM maven:3.8.6-eclipse-temurin-17-alpine AS build
WORKDIR /built


#COPY pom.xml book-service/
#COPY /app book-service/app
#COPY /app/* book-service/app/

COPY . book-service/

RUN mvn clean package -f book-service/pom.xml

FROM openjdk:17-jdk-alpine

WORKDIR /built

COPY --from=build /built/book-service/app/startup/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
