# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY ./antfy_backend/pom.xml /app/
COPY ./antfy_backend/src /app/src
RUN mvn -f /app/pom.xml clean package
RUN echo $(ls -1 /app/target/)

# Run stage
FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]