# Stage 1: Build the application with Maven
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /authenticationservices
COPY . .
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY --from=build /authenticationservices/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]+