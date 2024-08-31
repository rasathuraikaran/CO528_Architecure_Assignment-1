FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/Assignment1-0.0.1-SNAPSHOT.jar Assignment1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Assignment1-0.0.1-SNAPSHOT.jar"]
