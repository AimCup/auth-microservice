FROM arm32v7/maven:3.9.3-eclipse-temurin-17 AS build
COPY src /acservice/src
COPY pom.xml /acservice
RUN mvn -f /acservice/pom.xml clean package -P stg

FROM arm32v7/eclipse-temurin:17
COPY --from=build /acservice/target/*.jar app.jar
EXPOSE 8201
ENTRYPOINT ["java","-Dspring.profiles.active=stg","-jar","/app.jar"]
