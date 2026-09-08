# Meesho E-Commerce Application

A beginner-friendly Meesho-style e-commerce project built with **Java, Spring Boot, Thymeleaf and MySQL**.

This project uses the same general layered idea as the `amazon-application` reference: controllers handle web requests, services contain business logic, DAOs handle database operations, models represent data, and Thymeleaf renders the UI.

## Features

- Meesho-style home page
- Product listing
- User registration and login
- Session-based authentication
- Add product to cart
- View cart
- MySQL persistence
- Sample products

## Run locally

1. Create the database:

```bash
mysql -u root -p < database/schema.sql
```

2. If your MySQL username/password is different, set environment variables:

```bash
export DB_USERNAME=root
export DB_PASSWORD=your_password
```

3. Start the application:

```bash
mvn clean spring-boot:run
```

4. Open:

`http://localhost:8080`

## Project structure

```text
src/main/java/com/meesho/
├── controller/
├── dao/
├── model/
├── service/
└── MeeshoApplication.java

src/main/resources/
├── templates/
└── application.properties

database/schema.sql
```

## Next modules

The project can be extended with seller dashboard, product management, search/filter, cart quantity update/remove, checkout, orders, payments, addresses, and an admin panel.
