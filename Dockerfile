# Use an official Gradle image with JDK 22 for the build stage
FROM gradle:8.8.0-jdk-21-and-22 AS build

# Set the working directory inside the container
WORKDIR /home/gradle/project

# Copy the Gradle wrapper and build files
COPY gradle /home/gradle/project/gradle
COPY build.gradle settings.gradle /home/gradle/project/

# Download dependencies
RUN gradle build --no-daemon || return 0

# Copy the rest of the source code
COPY src /home/gradle/project/src

# Build the JAR file
RUN gradle bootJar --no-daemon

# Use an official OpenJDK runtime with JDK 24 for the runtime
FROM openjdk:24-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /home/gradle/project/build/libs/omsaas-app.jar omsaas-app.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "omsaas-app.jar"]