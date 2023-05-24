FROM adoptopenjdk:11-jdk-hotspot as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM adoptopenjdk:11-jdk-hotspot
RUN ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
COPY --from=builder build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${USE_ENV_PROFILE}", "-jar", "/app.jar"]