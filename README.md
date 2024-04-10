# Automatisation

### Prérequis: 

- Installation Maven
- Installation allure 
```
# -------------------------- #
# Install allure-commandline #
# -------------------------- #

wget https://dl.bintray.com/qameta/generic/io/qameta/allure/allure/2.7.0/allure-2.7.0.tgz && \
    tar -zxvf allure-2.7.0.tgz -C /opt/    && \
    ln -s /opt/allure-2.7.0/bin/allure /usr/bin/allure   && \
    allure --version 

allure --version 
```
- Environnement \
Copy .env.template file to .env and complete credentials to access your [LambdaTest](https://accounts.lambdatest.com/) account (RemoteWebDriver)
```
source .env
```
### Jar packaging:
```
mvn clean;rm -rf allure-re*; mvn package -DskipTests=true
```
### Exécution:
##### Exécution via Maven (exécution en parallèle des tests)
Appel de tous les tests
```
mvn clean; mvn test
```
Appel en mode headless(navigateur non visible) de tous les tests avec les tags @SmokeTest ou @Authentication ou @Checkbox
```
mvn test -Dheadless=true -Dcucumber.options="--tags '@SmokeTest or @Authentication or @Checkbox'"
```
##### Exécution via Maven (exécution séquentielle des tests)
Appel de tous les tests
```
java -jar target/automatisation-1.0-SNAPSHOT-tests.jar
```
Appel de tous les tests avec le tag @SmokeTest
```
java -jar target/automatisation-1.0-SNAPSHOT-tests.jar -t @SmokeTest
```
Appel en mode non headless(navigateur visible) de tous les tests avec le tag @SmokeTest ou @Authentication
```
java -Dheadless=false -jar target/automatisation-1.0-SNAPSHOT-tests.jar -t "@SmokeTest or @Authentication"
```
### Comandes Allure:
```
 allure generate --clean
 allure open
```
