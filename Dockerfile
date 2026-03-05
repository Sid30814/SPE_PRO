# Use a small Java runtime as the base
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
# Note: Ensure the name matches what Maven generates in the /target folder
COPY target/*.jar app.jar

# Command to run the calculator when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]