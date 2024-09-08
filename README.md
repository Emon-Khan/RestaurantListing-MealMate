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


## Docker Instructions

If you prefer using Docker for this service, you can pull and run the RestaurantListing image directly from Docker Hub.

### Pulling the Image from Docker Hub

1. To pull the image, use the following command:
    ```bash
    docker pull rkemon94/restaurantlisting-service:latest
    ```

### Running the Order Service with Docker

2. Run the Restaurantlisting service in a Docker container:
    ```bash
    docker run --name restaurantlisting-container -p 9093:9093 rkemon94/restaurantlisting-service:latest
    ```

3. Access the service:

   After running the container, you can access the API on http://localhost:9093.

### Stopping and Removing the Container

- To stop the running container:
    ```bash
    docker stop restaurantlisting-container
    ```

- To remove the container after stopping it:
    ```bash
    docker rm restaurantlisting-container
    ```

## Conclusion

The RestaurantListing service is responsible for managing restaurant information in the MealMate microservices architecture. By leveraging Docker, you can run this service quickly and easily, ensuring smooth integration with other MealMate services like Eureka for service discovery.


