FROM maven:3-eclipse-temurin-8 as maven
WORKDIR /app
COPY . /app/
RUN mvn install -DskipTests
COPY target/*.jar /

FROM openjdk:17.0.1-jdk-slim
WORKDIR /
EXPOSE 8080
COPY --from=maven /*.jar /
CMD ["java","-jar","person-0.0.1-SNAPSHOT.jar"]
