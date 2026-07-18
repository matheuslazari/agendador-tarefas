FROM gradle:9.6.1-jdk21 AS build
WORKDIR /app
COPY . .
run gradle build --no-daemon
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build app/build/libs/*.jar app/agendador-tarefas.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/agendador-tarefas.jar"]