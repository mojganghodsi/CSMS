
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
![last commit](https://img.shields.io/github/last-commit/mojganghodsi/CSMS)
![goto counter](https://img.shields.io/github/search/mojganghodsi/CSMS/goto)
<!--
![build](https://img.shields.io/github/workflow/status/mojganghodsi/CSMS/ci)
![coverage](https://img.shields.io/codecov/c/github/mojganghodsi/CSMS)
-->
# CSMS

CSMS (charging station management system) is used to manage charging stations, charging
processes and customers (eDrivers) amongst other things. One of functionalities of such a CSMS is to calculate a price to a particular charging process so that the eDriver can be invoiced for the consumed services. Establishing a price for a charging process is usually done by applying a rate to the CDR (charge detail record) of the corresponding charging process which is implemented here.

## Table of Contents

- [Getting Started](#getting-started)
- [Minimal Requirements](#minimal-requirements)
- [Install](#install)
- [Run the tests](#run-the-tests)
- [Deployment](#deployment)
- [Built With](#built-with)
- [Author](#author)
- [License](#license)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Minimal Requirements

*Linux, Mac OS or Windows
*Java 8+
*Maven

### Install

For trying the app in your enviroment. you can self-host using CI provided. In order to installing the app in your enviroment maually:

clone the repository using git:
```
git clone https://github.com/mojganghodsi/CSMS.git
```
or you can just downloaad it
JRE(or JDK if you want to compile the code) 8+ should be installed and the relative enviroment variable configured.maven should be installed in order to build the .jar files. And also add it to your system enviroment varibales to be accessed in entire the directories. (Here I skip upper requirements instalation and configuration to make it concise)

Then run folowing commands:
```
mvn clean install
```
The project .jar files will be created under target directory, you can see test result detail in the terminal too (you can also run mvn test if you want to see test result alone). Then execute the .jar file using folowing command:
```
java -jar <your .jar file name>
```

Here there is no need to use any web server like tomcat, Spring boot will take care of that with it's embeded web server.

Now you can access the api using swagger: [APIs](http://localhost:8080/csms-api/swagger-ui.html#/)

You successfully insalled the minimal requirements and deployed the app on your system.

## Run the tests

CI is provided by GitHub action, so to see every thing about run tests you can go under actions tab, latest workflow. Also You can re-run the workflow to run the script manually. consider that ci.yml will run aftter each push.

In last commit all the tests were successfully passed, and in my IDEA, tests were run by 92% code coverage.

## Deployment

Docker image is built, by running the ci.yaml script. It will be done automaticaly with each push on repository. Self-host option is available for future deployment cases.


Here we see minimal instruction to deploy containerized app on ubuntu:

Make sure if docker is installed and the service is up and running on your system. Go to the project directory and run these command to build the docker image:
```
mvn clean install
```
```
docker build . --file Dockerfile --tag <image name>:$(date +%s)
```
Find the image name:
```
docker images
```
Then run the image and map desired port of host to 8080 port of the container:
```
docker run -p 8080:8080 <image name>
```
Now you can see the API using the previous called [swagger ui console](http://localhost:8080/csms-api/swagger-ui.html#/) or access API with it's path on your system.


## Built With

* [Java](https://www.java.com/en/) - The language used
* [Spring Framework](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/) - Unit testing frameework

## Author

* **Mojgan Ghodsi** - *other repositories* - [Mojgan Ghodsi](https://github.com/mojganghodsi)

## License

This project is licensed under the Apache-2.0 License


## note
please feel free to contact me for any question, email: zahraghodsi.w@gmail.com

