# Use an official OpenJDK 8 runtime as the base image
#FROM openjdk:8-jdk-alpine
FROM openjdk:8-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Java application (e.g., JAR file) to the container
# Make sure to replace "your-application.jar" with your actual JAR file name
COPY target/OA-1.0.1.jar /app/OA-1.0.1.jar

# Expose the application's port (if applicable)
# Replace 8097 with your application's port
EXPOSE 8097

# Set the default command to run the JAR file
# Replace "your-application.jar" with your actual JAR file name
CMD ["java", "-jar", "OA-1.0.1.jar"]
