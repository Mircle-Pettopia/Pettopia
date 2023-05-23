FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
ENV USE_PROFILE linux
ENTRYPOINT ["java","-jar","--Dspring.profiles.active=${USE_PROFILE}","/app.jar"]
