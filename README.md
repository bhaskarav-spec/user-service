# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

Build Docker Image:

docker build -t <image-name> .  
(-t user-service-app: Indicate tags with name user-service-image) 
dot :Indicates  that Docker should look for the Dockerfile in the current directory. 

docker run -p 8080:8080 user-service-app
Maps port 8080 on your local machine to port 8080 inside the Docker container, allowing you to access your Spring Boot application. 