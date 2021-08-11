## Author
Prashant Soni

## Description
Demo site Web Automation test suite

## Prerequisites
* Java 11
* Maven
* Intellij
* Source Tree

## Automation framework setup
* First install Intellij community

  https://www.jetbrains.com/idea/download/#section=windows

* Install Java SDK

  https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

* Install Maven binary (Latest), current is apache-maven-3.8.1-bin.zip

  https://maven.apache.org/download.cgi

* Set JAVA_HOME & MAVEN_HOME as environment variables

  https://mkyong.com/java/how-to-set-java_home-on-windows-10/

  https://mkyong.com/maven/how-to-install-maven-in-windows/


## Run tests

`mvn clean test -Dcucumber.options="--tags @completeSale and not @ignore" -P "Chrome"`



