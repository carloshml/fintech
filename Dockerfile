# Use the official maven/Java 17 image to create a build artifact.
FROM maven:3.8.4-openjdk-17 as builder

# Set the working directory in the image to /app
WORKDIR /app

# Copy the pom.xml file into the current directory (/app)
COPY pom.xml .

# Download all required dependencies into one layer
RUN mvn dependency:go-offline -B

# Copy your other files
COPY src ./src

# Build a JAR file
RUN mvn package -DskipTests

# Derivando da imagem oficial do MySQL
FROM mysql:5.7
# Adicionando os scripts SQL para serem executados na criação do banco
COPY ./db/ /docker-entrypoint-initdb.d/

# Set the working directory in the image to /app
WORKDIR /app

# Copy the jar file from builder image
COPY --from=builder /app/target/*.jar app.jar

# Use OpenJDK JRE 17 base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the image to /app
WORKDIR /app

# Copy the jar file from builder image
COPY --from=builder /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]

