# NGO Management System

This is a web application which can be used to manage all the operations of NGO.

[BACKEND REPO LINK](https://github.com/sahilKewlani/NGOManagementSystem/tree/backend)  
[FRONTEND REPO LINK](https://github.com/sahilKewlani/NGOManagementSystem/tree/frontend)

### Technology Stack

NGO Management System uses a number of open source projects to work properly:

* [Angular CLI](https://github.com/angular/angular-cli) - HTML enhanced for web apps!
* [Java Spring](https://spring.io/) - application development framework for the backend
* [MySQL](https://www.mysql.com/) - Relational Database 
 
# Installation

###### Prerequisite: 
Install following on your machine:
Visit [Install Node](https://nodejs.org/en/download/)
Visit [Install Angular CLI](https://cli.angular.io/)
Visit [Install MySQL](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)

### Backend

First start MySQL server and create database using following query:
```sh
CREATE DATABASE ngo;
```
Run Spring Boot application with command:
```sh
$ mvn spring-boot:run
```
OR use any IDE to run the Spring Boot application.

### Database

we need to add role entries in roles table.
Use following insert statements:
```sh
INSERT INTO roles(name) VALUES('ROLE_VOLUNTEER');
INSERT INTO roles(name) VALUES('ROLE_DONOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

### Frontend

Open new command prompt and navigate into frontend repo folder.
```sh
$ npm install
$ ng serve
```

Verify the application by visiting in your preferred browser.

```sh
localhost:4200
```

For admin functionalities visit

```sh
localhost:4200/admin
```

##### Credits
Written by Sahil Kewlani
