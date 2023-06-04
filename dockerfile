FROM openjdk:8
WORKDIR /app

COPY target/microsalle.jar.jar /app
CMD ["java","-jar","microsalle.jar"]