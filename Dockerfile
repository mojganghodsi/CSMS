FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/CSMS-0.0.1-SNAPSHOT.jar CSMS.jar
ENTRYPOINT ["java", "-jar", "CSMS.jar"]
