# Use an official JDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the host machine to the container
COPY target/restaurantlisting-0.0.1-SNAPSHOT.jar restaurantlisting.jar

# Expose the port your microservice runs on
EXPOSE 9091

# Command to run the application
ENTRYPOINT ["java", "-jar", "restaurantlisting.jar"]