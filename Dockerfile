FROM java:8
EXPOSE 8080
LABEL maintainer='mrlanu@gmail.com'
ADD ./target/the_yard-0.0.1-SNAPSHOT.jar the_yard-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","the_yard-0.0.1-SNAPSHOT.jar"]