Person Rest Servives
Spring Boot Restful Web Services Example

1.OPERATIONS
This is an example of Restful Web Services using Spring Boot Framework
It Provides below Functionalities:
1.Get: Person :It allows to fetch a person record based on the person Id
  URL http://localhost:8080/api/persons/{id}
2.Add a Person :It allows to add a person  with a post Method the 
Sample Json For adding a person
{"firstName":"nisha","lastName":"arora","age":"22","favouriteColor":"White"}
Url:http://localhost:8080/api/persons (POST -Method)
3.Update a person :It Allows User to update a Person Entity :
{"firstName":"neha","lastName":"arora","age":"22","favouriteColor":"White"}
URL:http://localhost:8080/api/persons/{id},Method:PUT
4.Delete a person : It allows to delete a record from the DB
Url :http://localhost:8080/api/persons/(id} ,Method :DELETE
5.Get all persons:It allows to fetch all the records for Databse
Url:http://localhost:8080/api/persons/,Method:GET

2.PROPERTIES
Spring Boot solves our problem with automatic configuration as we use an embedded Tomcat and an embedded H2 database but how are we going to specify the running port of the Tomcat container, the target database, connection pool parameters and so on?

Spring Boot provides a default configuration properties file called as application.properties. Within this file there are hundreds of configuration parameters we can use. You can see the detailed parameter list via following link;

Spring Boot Application Properties Reference

The default locations of the application.properties file is either somewhere within the classpath, for example under src/main/resources in a maven project, or a inside config folder under current working directory. It is better to put the file under config folder which will make it easy to deploy inside a docker container, but the choice is yours. I place application.properties under config folder.

Because that we are using a server, H2 database, a datasource, a db connection pool and lastly, hibernate, we should define parameters in this application.properties file, based on the documented reference list.

Let's take a detailed look;

Server Configuration     The default configuration port is 8080, however we may want to change this. Thus I add the port configuration     as below;
#server port
server.port=8080

H2 Database Configuration    &nbspWe also need to specify whether the console is activated, so that we can use H2 database via the console, create     our tables and initialize our db entries.
#H2 configuration
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
# default path: h2-console

3.DATABSE CONFIGURATION
8 H2 Database Preparation
Before using our database implementation instead of using our stub implementation, we need to prepare our table and initial entries within the database. We have two things to do;

We need to create a Person table to store our person  model, defined in Consultant class.
We need to insert some trivial entries to the table.
The related SQL commands are located under the Schema.sql

 we have defined our H2 console with "/h2" postfix. Also we have defined our server port as "8080", so connection url will be http://localhost:8080/h2-ui 


4.TESTING
4.a Running Tests via postman
You can run the tests via postman
1.import the attached postman collection on your local
2.Make Your application up
3.Run the postman collection

4.b Testing via Feature file 
  1.Make Application up it will start on localhost:8080
  2.Go to Runner.java and  run that file as junit

5.Packaging and Deploying 

There is a Docker file in Docker Folder which can be used to create docker images and run the application on local

Now we can run the application without the Docker container (that is, in the host OS):

If you use Gradle, run the following command:

./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar
If you use Maven, run the following command:

./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
Then go to localhost:8080 to see your “Hello Docker World” message.

Containerize It
Docker has a simple "Dockerfile" file format that it uses to specify the “layers” of an image. Create the following Dockerfile in your Spring Boot project:

Example 1. Dockerfile
FROM openjdk:latest
ADD target/person-rest-services-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
If you use Gradle, you can run it with the following command:

docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/person-rest-services .
If you use Maven, you can run it with the following command:

docker build -t springio/gs-spring-boot-docker .
This command builds an image and tags it as springio/gs-person-rest-services.

This Dockerfile is very simple, but it is all you need to run a Spring Boot app with no frills: just Java and a JAR file. The build creates a spring user and a spring group to run the application. It is then copied (by the COPY command) the project JAR file into the container as app.jar, which is run in the ENTRYPOINT. The array form of the Dockerfile ENTRYPOINT is used so that there is no shell wrapping the Java process. The Topical Guide on Docker goes into this topic in more detail.

Note
To reduce Tomcat startup time, we used to add a system property pointing to /dev/urandom as a source of entropy. This is not necessary anymore with JDK 8 or later.
Running applications with user privileges helps to mitigate some risks (see, for example, a thread on StackExchange). So, an important improvement to the Dockerfile is to run the application as a non-root user:

Example 2. Dockerfile
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
You can see the username in the application startup logs when you build and run the application:

docker build -t springio/person-rest-services .
docker run -p 8080:8080 springio/person-rest-services
Note the started by in the first INFO log entry:

 :: Spring Boot ::        (v2.2.1.RELEASE)

2020-04-23 07:29:41.729  INFO 1 --- [           main] hello.PearsonApplication                        : Starting Application on b94c86e91cf9 with PID 1 (/app started by spring in /)


Build a Docker Image with Gradle
You can build a tagged docker image with Gradle in one command:

./gradlew bootBuildImage --imageName=springio/person-rest-services

To push to a Docker registry, you need to have permission to push, which you do not have by default. Change the image prefix to your own Dockerhub ID and docker login to make sure you are authenticated before you run Docker.

After the Push
A docker push in the example fails (unless you are part of the "springio" organization at Dockerhub). However, if you change the configuration to match your own docker ID, it should succeed. You then have a new tagged, deployed image.

The application is then available on http://localhost:8080

...
