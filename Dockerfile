
# Use an official OpenJDK runtime as a base image
FROM openjdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/D387_sample_code-0.0.2-SNAPSHOT.jar

# Expose the port that the application will run on
EXPOSE 8080

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "D387_sample_code-0.0.2-SNAPSHOT.jar"]