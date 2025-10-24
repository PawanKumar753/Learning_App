# =============================
# Dockerfile for user-service
# =============================
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/User-Service-0.0.1-SNAPSHOT.jar user-service.jar

# Expose service port
EXPOSE 9091

# Set environment variable to point to Zipkin
ENV MANAGEMENT_ZIPKIN_TRACING_ENDPOINT=http://zipkin:9411/api/v2/spans

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "user-service.jar"]
