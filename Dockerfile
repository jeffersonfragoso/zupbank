FROM openjdk:11-jdk-slim

ARG PROFILE
ARG ADDITIONAL_OPTS
ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /usr/src/app
COPY /target/zupbank*.jar zup-bank.jar

# Debug port
EXPOSE 5005
# API port
EXPOSE 8080

SHELL ["/bin/sh", "-c"]
CMD java ${ADDITIONAL_OPTS} -jar zup-bank.jar --spring.profiles.active=${PROFILE}