FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/spring-security-auth-server-0.0.1-SNAPSHOT.jar spring-security-auth-server.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "spring-security-auth-server.jar"]