FROM openjdk:17-jdk-slim

ARG MODE
COPY ./build/libs/ebdj.jar ebdj.jar

ENTRYPOINT java -jar -Dspring.profiles.active=${MODE} /ebdj.jar
