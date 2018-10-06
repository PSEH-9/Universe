FROM openjdk:8-jdk-alpine
VOLUME /var
ARG JAR_FILE
COPY ${JAR_FILE} universe-0.0.1-SNAPSHOT.jar.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/universe-0.0.1-SNAPSHOT.jar.jar"]