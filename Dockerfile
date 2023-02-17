FROM maven:3.8-openjdk-17-slim AS build

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Copy the rest of the app's source code to the container
COPY src/ ./src/

# Build the app using Maven
RUN mvn clean package -DskipTests

# Use an official OpenJRE image as the base image for the final container
FROM openjdk:17.0.1-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the packaged jar from the build stage to the container
COPY --from=build /app/target/*.jar app.jar

# Expose port 8081 to the host machine
EXPOSE 8081
# Set the command to run the app when the container starts
CMD ["java", "-Duser.timezone=CET", "-jar", "app.jar"]