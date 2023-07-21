# Use the official OpenJDK base image with Java 11 (or any other desired version)
FROM gradle:8.2.1-jdk17


# Set the working directory inside the container
WORKDIR /automation-immortalv

# Copy the entire project directory to the container
COPY . /automation-immortalv

# Run the Gradle build inside the container
CMD ./gradlew build