# Spring Boot Api

- This project was created with Spring Initializr as a Maven project
- Includes a simple API with student data stored in a Postgre database

## Technologies:
- Spring Boot, Spring Web
- Spring Data JPA
- PostgreSQL

<br>

&nbsp;
**RESTful API Description**

METHOD | PATH | DESCRIPTION 
------------|-----|------------
GET | /api/v1/student | get all Students
POST | /api/v1/student | save a new Student (id will be auto-generated) 
DELETE | /api/v1/student/{id} | delete Student with given id
PUT | /api/v1/student/{id} | update Student with given id

&nbsp;