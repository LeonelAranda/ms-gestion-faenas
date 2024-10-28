FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/ms-gestion-faenas-0.0.1.jar
COPY ${JAR_FILE} ms-gestion-faenas.jar
COPY Wallet_DbCapstone /app/oracle_wallet
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "ms-gestion-faenas.jar" ] 