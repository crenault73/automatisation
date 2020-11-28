# Automatisation

Prérequis : 

Installer Maven 

Commandes utilisées : 

mvn test

Installation allure:

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
###### Comandes allure:
```
 allure generate --clean
 allure open
```

###### Jar packaging 
```
mvn clean;rm -rf allure-re*; mvn package -DskipTests=true
```
Appel de tous les tests
```
java -jar target/maven-simple-1.0-SNAPSHOT-tests.jar
```
Appel de tous les tests avec le tag @SmokeTest
```
java -jar target/maven-simple-1.0-SNAPSHOT-tests.jar -t @SmokeTest
```
Appel en mode headless(navigateur non visible) de tous les tests avec le tag @SmokeTest ou @Authentication
```
java -Dheadless=false -jar target/maven-simple-1.0-SNAPSHOT-tests.jar --tags @SmokeTest,@Authentication
```