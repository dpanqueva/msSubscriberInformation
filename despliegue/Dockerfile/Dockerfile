# openjdk11
FROM openjdk:11.0.2-jdk
# install curl
RUN apt-get update && apt-get install curl -y
#generate jar
COPY ./src/msSubscriberInformation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]