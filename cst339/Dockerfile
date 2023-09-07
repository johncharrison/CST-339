FROM eclipse-temurin:17

WORKDIR /app

COPY ./target/cst339-*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]