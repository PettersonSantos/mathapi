FROM openjdk:17-jdk-alpine
ADD target/api-0.0.1-SNAPSHOT.jar maths.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /maths.jar"]