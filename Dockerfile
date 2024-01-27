# Utilisez une image de base, par exemple OpenJDK 11
FROM openjdk:21-ea-1-buster

# Définissez le répertoire de travail dans le conteneur
WORKDIR /app

# Copiez le jar de votre application dans le conteneur
COPY target/Budgetisor-0.0.1-SNAPSHOT.jar /app/Budgetisor.jar

# Exposez le port sur lequel votre application s'exécute
EXPOSE 9011

# Commande pour exécuter votre application lorsque le conteneur démarre
CMD ["java", "-jar", "Budgetisor.jar"]
