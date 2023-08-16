# Use the official OpenJDK base image with Java 11 (or any other desired version)
FROM alpine:3.14
FROM gradle:8.2.1-jdk17

# Set the working directory inside the container
WORKDIR /immortal-tests-ui
# Copy the entire project directory to the container
COPY . /immortal-tests-ui

CMD ["gradle","test"]