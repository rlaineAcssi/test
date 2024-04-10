FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests