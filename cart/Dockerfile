#openjdk is the docker image for Java JDK the application will use
FROM openjdk:11
#creating a working directory inside the docker container of the application
WORKDIR usr/lib
#Copy the executable jar file that is created
#in the target folder and add it to the usr/lib working directory
ADD ./target/cart-0.0.1-SNAPSHOT.jar /usr/lib/cart-0.0.1-SNAPSHOT.jar
#Run the jar file using the java -jar command
ENTRYPOINT ["java","-jar","cart-0.0.1-SNAPSHOT.jar"]