FROM openjdk:11-jdk
COPY target/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]