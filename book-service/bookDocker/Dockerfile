# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Copy the Maven POM file
COPY pom.xml .

# Copy the rest of the application code
COPY app app

# Build the application with Maven
RUN mvn clean package -DskipTests

# Stage 2: Use a smaller OpenJDK 17 image to run the application
FROM adoptopenjdk/openjdk17:alpine-jre
WORKDIR /app

# Copy the built artifact from the previous stage
COPY --from=build /app/app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
