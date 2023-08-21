FROM maven:3.8.5-openjdk-20 AS bulid
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:20-jdk-slim

COPY --from=bulid/target/Test-0.0.1-SNAPSHOT.jar Test.jar
EXPOSE 8080
ENTRYPOINT["java","-jar","Test.jar"]
