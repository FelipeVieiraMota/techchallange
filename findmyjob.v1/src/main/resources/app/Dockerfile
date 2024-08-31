# To create a docker build from scratch, perform this command bellow:
# docker build -t findmyjob -f ./src/main/resources/app/Dockerfile  .


# Use an official JDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/findmyjob.v1-0.0.1-SNAPSHOT.jar /app/findmyjob.v1-0.0.1-SNAPSHOT.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Command to run the jar file
ENTRYPOINT ["java","-jar","/app/findmyjob.v1-0.0.1-SNAPSHOT.jar"]