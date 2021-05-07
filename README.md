# The Smurfs
A pacman-like game where the goal is to reach the princess before being caught

## Requirements
* [Docker](https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository)

## Steps
In the project directory:

1. Give the docker user access to the x-server
```
xhost +"local:docker@"
```
2. Build and run the docker image
```
docker build -t the-smurfs:1.0 .
docker run --net=host --env DISPLAY=$DISPLAY --volume=/tmp/.X11-unix:/tmp/.X11-unix the-smurfs:1.0
```
