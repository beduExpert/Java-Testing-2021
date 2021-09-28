# Reto 1 - Ejecutar SonarQube en tu proyecto

## Desarrollo

Ahora es tu turno de ejecutar el análisis con SonarQube en tu código.

- Ejecuta el siguiente comando para levantar la instancia de SonarQube
  `docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest`
- Sigue los pasos listados en el ejemplo anterior.
- Modifica tu archivo gradle para que contenga SonarQube como plugin
- Ejecuta el siguiente comando
  `./gradlew sonarqube -Dsonar.projectKey=java-testing -Dsonar.host.url=http://localhost:9000   -Dsonar.login=TU_TOKEN`
- Elige algunos de los Bugs o Code Smells y corrígelos.

