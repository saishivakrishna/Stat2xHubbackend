FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy whole project
COPY . .

# Build project
RUN mvn clean package -DskipTests

# ---- RUNTIME IMAGE ----
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
