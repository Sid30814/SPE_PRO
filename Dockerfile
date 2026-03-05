# Use Eclipse Temurin (the official successor to the old OpenJDK image)
FROM eclipse-temurin:11-jre-alpine

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the JAR file from your target folder
COPY target/ScientificCalculator-1.0-SNAPSHOT.jar /app/scientific-calculator.jar

# Command to run the calculator
ENTRYPOINT ["java", "-jar", "/app/scientific-calculator.jar"]