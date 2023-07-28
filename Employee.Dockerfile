FROM maven:3-eclipse-temurin-8 as maven
WORKDIR /app
COPY . /app/
RUN mvn install -DskipTests && ls -l target
COPY target/*.jar /

FROM openjdk:17.0.1-jdk-slim
WORKDIR /
EXPOSE 8080
COPY --from=maven /*.jar /
RUN ls -l
CMD ["java","-jar","person-0.0.1-SNAPSHOT.jar"]