FROM openjdk:8-jdk-slim
ADD /target/Backend-0.0.1-SNAPSHOT.jar gym-app-backend.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","gym-app-backend.jar"]