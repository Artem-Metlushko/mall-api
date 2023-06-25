# Проект mall-api

Это REST API приложение на основе фреймворка Spring Boot, которое 
предоставляет функциональность  для создания масштабируемого и гибкого приложения. 
Для работы с базой данных выбраны модули Spring Data JPA и Hibernate. 
Lombok для упрощения разработки и Rest Assured для написания интеграционных 
тестов API.liquibase-core для управления версионированием и 
миграцией базы данных.

## Предметная область: Интернет-магазин электроники.

Композиция:
Объект "Category":

Свойство "categoryId" - уникальный идентификатор категории.
Свойство "name" - название категории.
Свойство "description" - описание категории.
Свойство "productCount" - количество продуктов в данной категории.
Свойство "image" - изображение, связанное с категорией.
Свойство "rating" - рейтинг категории.

Объект "Product":

Свойство "productId" - уникальный идентификатор продукта.
Свойство "name" - название продукта.
Свойство "price" - цена продукта.
Свойство "description" - описание продукта.
Свойство "category" - категория, к которой относится продукт (связь "многие к одному" с объектом "Категория").
Такая композиция позволяет организовать структуру интернет-магазина, где каждый продукт принадлежит определенной категории. 
У каждой категории может быть множество продуктов, а каждый продукт привязан только к одной категории.

Например, можно иметь категорию "Смартфоны" с различными моделями продуктов внутри нее, такими как "iPhone 12", "Samsung Galaxy S21", "Google Pixel 5" и т.д.
Каждый продукт будет иметь свои уникальные свойства, такие как цена, описание и принадлежность к категории "Смартфоны".


## Зависимости

1. spring-boot-starter-data-jpa: Зависимость для подключения модуля Spring Data JPA, который предоставляет удобные средства для работы с базой данных с использованием парадигмы ORM (Object-Relational Mapping).
2. spring-boot-starter-web: Зависимость для разработки веб-приложений с использованием Spring Web MVC, который предоставляет функциональность для создания RESTful API и веб-страниц с использованием шаблонов.
3. mysql-connector-j: Зависимость для подключения MySQL JDBC Driver, который обеспечивает взаимодействие с базой данных MySQL. 
4. lombok: Зависимость для интеграции с проектом Lombok, который упрощает разработку Java-кода путем автоматической генерации геттеров, сеттеров, конструкторов и других стандартных методов. 
5. spring-boot-starter-test: Зависимость для подключения модуля Spring Boot Test, который предоставляет инструменты для написания и запуска автоматических тестов в Spring Boot приложениях. 
6. springdoc-openapi-starter-webmvc-ui: Зависимость для подключения модуля Springdoc OpenAPI, который генерирует документацию API на основе аннотаций в коде и предоставляет интерактивный интерфейс Swagger UI для просмотра и тестирования API. 
7. hibernate-validator: Зависимость для интеграции с Hibernate Validator, который предоставляет механизмы валидации данных с использованием аннотаций. 
8. liquibase-core: Зависимость для интеграции с Liquibase, который предоставляет средства для управления версионированием и миграцией базы данных. 
9. rest-assured: Зависимость для интеграции с Rest Assured, который предоставляет удобные средства для написания автоматических тестов API с использованием Fluent API. 
10. jaxb-api: Зависимость для использования API JAXB (Java Architecture for XML Binding), который предоставляет механизмы преобразования данных между XML и Java объектами.


## Сборка и запуск

1. Клонируйте репозиторий на локальную машину и откройте проект в Терминале.
2. Запустите Docker на локальной машине.
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



