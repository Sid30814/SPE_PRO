# Use an OpenJDK runtime as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the JAR file from your target folder to the container
# This matches the name 'ScientificCalculator-1.0-SNAPSHOT.jar' seen in your image
COPY target/ScientificCalculator-1.0-SNAPSHOT.jar /app/scientific-calculator.jar

# Copy the source tests directory for reference (as per your requested style)
COPY src/test/java /app/tests/

# Command to run the scientific calculator
# We use ENTRYPOINT so the app starts automatically
ENTRYPOINT ["java", "-jar", "/app/scientific-calculator.jar"]