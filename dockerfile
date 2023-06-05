FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 9003
COPY target/microsalle.jar /app
CMD ["java","-jar","microsalle.jar"]