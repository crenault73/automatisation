# Automatisation

Prérequis : 

Installer Maven 

Commandes utilisées : 

mvn test

installation allure:

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