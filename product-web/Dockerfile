FROM openjdk:11
ADD target/product-webapp-0.0.1-SNAPSHOT.jar product-webapp-0.0.1-SNAPSHOT.jar
EXPOSE 8099
ENTRYPOINT ["java","-jar","product-webapp-0.0.1-SNAPSHOT.jar"]







# #openjdk is the docker image for Java JDK the application will use
# FROM openjdk:11
# #creating a working directory inside the docker container of the application
# WORKDIR usr/lib
# #Copy the executable jar file that is created
# #in the target folder and add it to the usr/lib working directory
# ADD ./target/feedback-service-0.0.1-SNAPSHOT.jar /usr/lib/feedback-service-0.0.1-SNAPSHOT.jar
# #Run the jar file using the java -jar command
# ENTRYPOINT ["java","-jar","feedback-service-0.0.1-SNAPSHOT.jar"]