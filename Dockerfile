FROM openjdk:8-jdk-alpine


# DEMO (RUN)
LABEL maintainer=manguilar22@gmail.com

WORKDIR /app

# Load Built JAR File
COPY ./build/libs/fast-track-0.0.1-SNAPSHOT.jar .

ENV MYSQL_HOSTNAME 127.0.0.1

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "fast-track-0.0.1-SNAPSHOT.jar"]
