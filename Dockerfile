# syntax=docker/dockerfile:1
FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
WORKDIR /top-hits-spotify-analysis
COPY . /top-hits-spotify-analysis

EXPOSE 8080
ENTRYPOINT [ "java","-jar","/top-hits-spotify-analysis/build/libs/top-hits-spotify-analysis-0.0.1-SNAPSHOT.jar" ]