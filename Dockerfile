FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# Fix permission issue
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose default port
EXPOSE 8080

# Run Spring Boot jar
CMD ["sh", "-c", "java -jar target/*.jar"]
