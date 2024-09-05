# RestaurantListing - MealMate

## Overview

The **RestaurantListing** service is a crucial component of the **MealMate** project. It is responsible for managing and listing restaurant data, allowing users to search for and view restaurants based on various criteria. This service is built using the Spring Boot framework and follows a microservices architecture, communicating with other services like **FoodCatalogue** and **Order** services.

## Features

- **CRUD Operations**: Manage restaurant data with create, read, update, and delete functionalities.
- **Eureka Integration**: Registers with Eureka for service discovery and communication within the microservices ecosystem.
- **Spring Boot Framework**: Leverages Spring Boot for application development.
- **MySQL Database**: Stores restaurant data in a MySQL database.

## Getting Started

### Prerequisites

- **JDK 17** or higher
- **Maven**
- **MySQL Database**
- **Eureka Service** (for service discovery)

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Emon-Khan/RestaurantListing-MealMate.git
   ```


2. **Navigate to the Project Directory**

   ```bash
   cd RestaurantListing-MealMate
   ```

3. **Configure the Database**

   Update the application.properties   file located in src/main/resources with your MySQL database details:

   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_listing
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

4. **Build the Project**

   ```bash
   mvn clean install
   ```

5. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Get Restaurant by ID
- URL: /api/restaurant/restaurants/{id}
- Method: GET
- Description: Retrieve restaurant details by ID.
- Response: JSON object of the restaurant details.

### Add New Restaurant
- URL: /api/restaurant/restaurants
- Method: POST
- Description: Add a new restaurant.
- Response:  JSON object with restaurant details.

```bash
   {
      "name": "The Great Restaurant",
      "address": "123 Food Street",
      "city": "FoodVille",
      "restaurantDescription": "A place for great food"
   }
```

### Get Restaurant
- URL: /api/restaurant/restaurants
- Method: GET
- Description: Retrieve restaurant details.
- Response: JSON object of the restaurant details.

### Screenshots
![image](https://github.com/user-attachments/assets/3e9802ea-1940-43c5-b43e-2f438f1e9654)
![image](https://github.com/user-attachments/assets/ea19701d-4b3e-45d8-b82d-8f8f86368d4f)
![image](https://github.com/user-attachments/assets/08a21746-f369-401b-b244-334309d29bfc)





