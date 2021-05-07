# To build run the following command:
# docker build -t the-smurfs:1.0 .


# Use the openjdk 8 image as the base image
FROM openjdk:8

# Install necessary dependencies
RUN apt-get -y update
RUN apt-get -y install libxrender1 libxtst6 libxi6

# Create an app directory in the image (executes on image build)
RUN mkdir /app

# Copy the compiled files from host machine to image filesystem
COPY out/production/The-Smurfs/ /app

# Copy resources files from host machine to image filesystem
COPY src/resources/ /app/src/resources

# Set the directory for executing future commands
WORKDIR /app

# Run the Main class (executes on container run, not build)
CMD java Main
