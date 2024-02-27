FROM ubuntu:latest

LABEL authors="malek"

# Create a directory to store the application
WORKDIR /app

# Copy the JAR file into the container
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Set the entry point for the container
ENTRYPOINT ["java","-jar","/app.jar"]
