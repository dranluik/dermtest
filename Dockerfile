# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim AS base

# Create a directory for HSQLDB files in the container
RUN mkdir -p ./hsqldb

# Create a non-privileged user
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser

# Change the ownership of the /hsqldb directory to the appuser
RUN chown appuser:appuser /hsqldb

# Switch to the non-privileged user
USER appuser

# Set default profile to 'dev'
ENV SPRING_PROFILES_ACTIVE=dev

# The application's jar file
COPY target/dermtest-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]
