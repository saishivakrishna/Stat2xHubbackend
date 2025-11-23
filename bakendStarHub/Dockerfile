# ---------- STAGE 1: Build the application ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and download dependencies first (cache layer)
COPY pom.xml .
RUN mvn -e -X dependency:go-offline


# Copy project source
COPY src ./src

# Build the application
RUN mvn package -DskipTests


# ---------- STAGE 2: Run the application ----------
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the Spring Boot App
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

