FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ./target/docker-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]