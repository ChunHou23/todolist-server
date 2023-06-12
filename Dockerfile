FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/ToDoList.jar ToDoList.jar
ENTRYPOINT ["java","-jar","/ToDoList.jar"]