# SpringBoot_Assignment
Spring Boot Login and Signup API with JWT Authentication

This repository contains a Spring Boot application that implements a login and signup REST API with JWT authentication. It allows users to register, login, and access a protected "hello" endpoint.

Prerequisites:
* Java JDK 8 or later
* Maven

Getting Started:

1. Clone the Repository:
Clone this repository to your local machine

2. Configure JWT Secret:
Open the src/main/resources/application.properties file and replace mysecretkey123 with your desired secret key for JWT

3. Run the Application:
Run the Spring Boot application
The application will start on http://localhost:8080

4. API Endpoints:

* Signup: POST /api/signup
  Example request body: { "username": "user1", "password": "password123", "email": "user1@example.com" }
  
*Login: POST /api/login
  Example request: /api/login?username=user1&password=password123
  
* Hello (Protected): GET /api/hello
  Requires Basic Authentication with valid credentials.

Testing:

You can use Postman to test the API endpoints. 

1. Signup

* Open Postman.
* Set the request type to POST.
* Enter the URL: http://localhost:8080/api/signup.
* Go to the "Body" tab, select "raw," and choose "JSON (application/json)" from the dropdown.
* Click the "Send" button after entering all the required fields.

2. Login

* Set the request type to POST.
* Enter the URL: http://localhost:8080/api/login?username=user1&password=password123.
* Click the "Authorization" tab, select "Basic Auth," and enter the same username and password.
* Click the "Send" button. You'll receive a token in the response.

3. Access Protected Endpoint (Hello):

* Set the request type to GET.
* Enter the URL: http://localhost:8080/api/hello.
* Click the "Authorization" tab, select "Bearer Token," and paste the token received from the login response.
* Click the "Send" button.


