FROM openjdk:8

LABEL maintainer=manguilar22@gmail.com

WORKDIR /app

# Load Built JAR File
COPY ./build/libs/fast-track-0.0.1-SNAPSHOT.jar .

ENV REDIS_HOST 127.0.0.1

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "fast-track-0.0.1-SNAPSHOT.jar"]