# Insurance-Management-Platform-Backend
 Insurance-Management-Platform-Backend REST API's Using Springboot
 
 ## Introduction
 - This is an insurance management platform built using Spring Boot and Java. It allows users to manage insurance policies, clients, and claims. The platform provides RESTful APIs for performing CRUD operations on the data.

## Technologies Used
- Java 17
- Spring Boot 3.0.5
- Spring Data JPA
- MySQL Database
- Lombok
- JUnit test cases
-

# Getting Started
## Prerequisites
- Java 17 or higher
- Maven

## Running the Application
- 1 Clone the repository: git clone 'https://github.com/Nandivaleamol/Insurance-Management-Platform-Backend.git'
- 2 Navigate to the project directory: cd 'Insurance-Management-Platform-Backend'
- 3 Run the application: mvn spring-boot:run

## RESTful API Endpoints
Clients

- GET `/api/clients`: Fetch all clients
- GET /api/clients/{id}: Fetch a specific client by ID
- POST /api/clients: Create a new client
- PUT /api/clients/{id}: Update a client's information
- DELETE /api/clients/{id}: Delete a client

Insurance Policies
- GET /api/policies: Fetch all insurance policies
- GET /api/policies/{id}: Fetch a specific insurance policy by ID
- POST /api/client/{cliendId}/policies: Create a new insurance policy with putting client id as path variable
- PUT /api/client/{clientId}/policies/{id}: Update an insurance policy with puttiing client id as path variable
- DELETE /api/policies/{id}: Delete an insurance policy

Claims
- GET /api/claims: Fetch all claims
- GET /api/claims/{id}: Fetch a specific claim by ID
- GET /api/claims/claimNumber/{claimNumber}: Fetch a specific claim by Claim Number
- POST /api/policy/{policyId}/claims: Create a new claim with puting policy id as path variable
- PUT /api/policy/{policyId}/claims/{id}: Update a claim's information with puting policy id as path variable
- DELETE /api/claims/{id}: Delete a claim

# Conclusion
This project demonstrates how to build a simple insurance management platform using Spring Boot and Java. It can be extended and customized as per the requirements of a specific project.

