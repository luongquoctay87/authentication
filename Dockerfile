FROM openjdk:17

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} auth-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","auth-service.jar"]