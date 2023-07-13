# Project mall-api

This is a REST API application based on the Spring Boot framework that provides functionality for creating a scalable and flexible application. The chosen modules for working with the database are Spring Data JPA and Hibernate. Lombok is used to simplify development, and Rest Assured is used for writing API integration tests. Liquibase-core is used for managing database versioning and migration.

## Domain: Electronics Online Store.

### Composition: 

Object "Category":

Property "categoryId" - unique identifier of the category.
Property "name" - category name.
Property "description" - category description.
Property "productCount" - number of products in this category.
Property "image" - image associated with the category.
Property "rating" - category rating.

Object "Product":

Property "productId" - unique identifier of the product.
Property "name" - product name.
Property "price" - product price.
Property "description" - product description.
Property "category" - the category to which the product belongs (many-to-one relationship with the "Category" object).

This composition allows organizing the structure of an online store, where each product belongs to a specific category. Each category can have multiple products, and each product is linked to only one category.

For example, you can have a category "Smartphones" with various product models within it, such as "iPhone 12", "Samsung Galaxy S21", "Google Pixel 5", and so on. Each product will have its own unique properties, such as price, description, and belonging to the "Smartphones" category.


## Dependencies

1. spring-boot-starter-data-jpa: Dependency for connecting the Spring Data JPA module, which provides convenient tools for working with the database using the ORM (Object-Relational Mapping) paradigm.
2. spring-boot-starter-web: Dependency for developing web applications using Spring Web MVC, which provides functionality for creating RESTful APIs and web pages using templates.
3. mysql-connector-j: Dependency for connecting the MySQL JDBC Driver, which enables interaction with the MySQL database.
4. lombok: Dependency for integrating with Lombok, which simplifies Java code development by automatically generating getters, setters, constructors, and other standard methods. 
5. spring-boot-starter-test: Dependency for connecting the Spring Boot Test module, which provides tools for writing and running automated tests in Spring Boot applications. 
6. springdoc-openapi-starter-webmvc-ui: Dependency for connecting the Springdoc OpenAPI module, which generates API documentation based on annotations in the code and provides an interactive Swagger UI interface for viewing and testing the API. 
7. hibernate-validator: Dependency for integrating with Hibernate Validator, which provides data validation mechanisms using annotations.
8. liquibase-core: Dependency for integrating with Liquibase, which provides tools for managing database versioning and migration. 
9. rest-assured: Dependency for integrating with Rest Assured, which provides convenient tools for writing automated API tests using a Fluent API. 
10. jaxb-api: Dependency for using the JAXB (Java Architecture for XML Binding) API, which provides mechanisms for transforming data between XML and Java objects.


## Build and Run

1. Clone the repository to your local machine and open the project in the terminal.
2. Make sure Docker is installed and running on your local machine.
3. Start the database by running the command: docker-compose up.
4. Build the project by executing the following command in the terminal: ./mvnw package.
5. Run the application using the command: ./mvnw spring-boot:run

## Swagger
After starting the application, you can access the Swagger API documentation at http://localhost:8080/swagger-ui/index.html. Here you will find detailed information about available endpoints, requests, and responses.

## Sample Requests for the "Category" Object

1. Create a new category:
``` 
curl -X 'POST' \
  'http://localhost:8080/categories' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "categoryId": 0,
  "name": "string",
  "description": "string",
  "productCount": 0,
  "image": "string",
  "rating": 0
}'
```

2. Get category information by its identifier:
``` 
curl -X 'GET' \
  'http://localhost:8080/categories/1' \
  -H 'accept: */*'
```

3. Get all categories:
``` 
curl -X 'GET' \
  'http://localhost:8080/categories' \
  -H 'accept: */*'
```

4. Update category information:
``` 
curl -X 'PUT' \
  'http://localhost:8080/categories/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "categoryId": 0,
  "name": "string",
  "description": "string",
  "productCount": 0,
  "image": "string",
  "rating": 0
}'
```

5. Delete a category:
``` 
curl -X 'DELETE' \
  'http://localhost:8080/categories' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "categoryId": 3,
  "name": "string",
  "description": "string",
  "productCount": 0,
  "image": "string",
  "rating": 0
}' 
```

## Sample Requests for the "Product" Object

1. Create a new product:
``` 
curl -X 'POST' \
  'http://localhost:8080/products' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "productId": 0,
  "name": "string",
  "price": 0,
  "description": "string",
  "category": {
    "categoryId": 1,
    "name": "string",
    "description": "string",
    "productCount": 0,
    "image": "string",
    "rating": 0
  }
}'
```

2. Get product information by its identifier:
``` 
curl -X 'GET' \
  'http://localhost:8080/products/1' \
  -H 'accept: */*'
```

3. Get all products:
``` 
curl -X 'GET' \
  'http://localhost:8080/products' \
  -H 'accept: */*'
```

4. Update product information:
``` 
curl -X 'PUT' \
  'http://localhost:8080/products/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "productId": 0,
  "name": "string",
  "price": 0,
  "description": "string",
  "category": {
    "categoryId": 1,
    "name": "string",
    "description": "string",
    "productCount": 0,
    "image": "string",
    "rating": 0
  }
}'
```

5. Delete a product:
``` 
curl -X 'DELETE' \
  'http://localhost:8080/products' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "productId": 1,
  "name": "string",
  "price": 0,
  "description": "string",
  "category": {
    "categoryId": 1,
    "name": "string",
    "description": "string",
    "productCount": 0,
    "image": "string",
    "rating": 0
  }
}' 
```



