# To build run the following command:
# docker build -t the-smurfs:1.0 .

# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml ./
RUN mvn -B -f pom.xml dependency:go-offline

# Copy all other project files and build project
COPY src ./src

# package our application code
RUN mvn clean package

# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:8

# Install necessary dependencies
RUN apt-get -y update
RUN apt-get -y install libxrender1 libxtst6 libxi6
# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/The-Smurfs-1.0-SNAPSHOT.jar /the-smurfs.jar
COPY --from=MAVEN_BUILD /src/main/resources /src/main/resources
# set the startup command to execute the jar
CMD ["java", "-jar", "/the-smurfs.jar"]