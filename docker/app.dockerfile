FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package spring-boot:repackage

FROM openjdk:17
LABEL Gustavo Pontalti
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000
WORKDIR /app
COPY --from=build /home/app/target/employe.jar employe.jar
EXPOSE 8080 8000
CMD java -jar employe.jar