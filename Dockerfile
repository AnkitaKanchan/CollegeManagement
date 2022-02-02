FROM openjdk:8
ADD target/sample.jar sample.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","sample.jar"]