FROM openjdk:11-jdk-slim
COPY "./target/clean-code-0.0.1.jar" "clean-code.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","clean-code.jar"]