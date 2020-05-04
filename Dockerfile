# Use the official image as a parent image.
FROM openjdk:11-jdk-alpine

ARG JAR_FILE=target/customer.store-0.0.1-SNAPSHOT.jar

# Set the working directory.
# WORKDIR /usr/src/app
WORKDIR /opt/app
# Copy the file from your host to your current location.
COPY ${JAR_FILE} store_client.jar

# Run the command inside your image filesystem.
# RUN npm install

# Inform Docker that the container is listening on the specified port at runtime.
EXPOSE 1212

# Run the specified command within the container.
# CMD [ "npm", "start" ]
ENTRYPOINT ["java","-jar","store_client.jar"]