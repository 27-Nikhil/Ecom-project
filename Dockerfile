FROM openjdk:21-slim

WORKDIR /app

COPY target/ecom-proj-0.0.1-SNAPSHOT.jar ecom-proj.jar
COPY ecom-frontend/dist /app/public
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ecom-proj.jar"]
