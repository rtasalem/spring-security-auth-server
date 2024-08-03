FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/spring-security-auth-server.jar spring-security-auth-server.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "spring-security-auth-server.jar"]