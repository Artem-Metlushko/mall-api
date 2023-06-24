# Проект mall-api

Это REST API приложение на основе фреймворка Spring Boot. 
Оно предоставляет возможность управления объектами "Product" и "Category" через CRUD операции.

## Зависимости

Для сборки и запуска этого приложения вам понадобятся :

- Java 17+
- Docker

## Технологии, используемые в проекте
Проект "mall-api" использует следующие технологии:

Java 17
Spring 
Spring Data JPA
Spring Web
MySQL
Hibernate
Swagger
Docker
Liquibase:


## Сборка и запуск

1. Клонируйте репозиторий на локальную машину.
2. Запустите Docker 
3. Запустите базу данных с помощью команды: `docker-compose up`
4. Соберите проект с помощью команды в терминале: `./mvn package`
5. Запустите приложение с помощью команды: `./mvnw spring-boot:run`.

## Swagger
После запуска приложения, вы можете получить доступ к документации API Swagger по адресу 
http://localhost:8080/swagger-ui/index.html. Здесь вы найдете подробную информацию о 
доступных эндпоинтах, запросах и ответах.

## Примеры запросов для обьета "Category"

1. Создание новой категории:
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

2. Получение информации о категории по её идентификатору:
``` 
curl -X 'GET' \
  'http://localhost:8080/categories/1' \
  -H 'accept: */*'
```

3. Получение всех категорий:
``` 
curl -X 'GET' \
  'http://localhost:8080/categories' \
  -H 'accept: */*'
```

4. Обновление информации о категории:
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

5. Удаление категории:
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

## Примеры запросов для обьета "Product"

1. Создание нового продукта:
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

2. Получение информации о продукте по её идентификатору:
``` 
curl -X 'GET' \
  'http://localhost:8080/products/1' \
  -H 'accept: */*'
```

3. Получение всех продуктов:
``` 
curl -X 'GET' \
  'http://localhost:8080/products' \
  -H 'accept: */*'
```

4. Обновление информации о продукте:
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

5. Удаление продукта:
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



