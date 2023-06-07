FROM openjdk:18-jdk-alpine
LABEL maintainer="tobawa2601@gmail.com"
VOLUME /foosball-backend
ADD "target/foosball-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
