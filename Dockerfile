# Use an OpenJDK runtime as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the JAR file from your local 'target' folder to the container
# Based on your image, the exact name is ScientificCalculator-1.0-SNAPSHOT.jar
COPY target/ScientificCalculator-1.0-SNAPSHOT.jar /app/scientific-calculator.jar

# Copy the source tests directory for reference (optional, matches your desired style)
COPY src/test/java /app/tests/

# Command to run the scientific calculator
# We use -it when running this container to allow user input
ENTRYPOINT ["java", "-jar", "/app/scientific-calculator.jar"]