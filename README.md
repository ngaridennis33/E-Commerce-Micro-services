# RESTful Microservices Architecture for E-Commerce with Spring Boot

## Introduction

- This project leverages Spring Boot to implement a microservices architecture tailored for e-commerce platforms.
  This architecture enables modular, scalable, and maintainable services, each responsible for distinct functionalities
  within the e-commerce ecosystem. The project incorporates intuitive, reactive programming and event-driven design
  patterns, following industry-best coding practices to enhance functionality and performance.

### Table of contents

- [Project architecture](#Project-architecture)
- [Project structure](#Project-structure)
- [Database architecture](#Database-architecture)
- [Tools and Technologies](#technologies)
- [Features](#features)
- [Status](#status)
- [Contact](#contact)

### Project global architecture

![micro](https://github.com/ngaridennis33/E-Commerce-Micro-services/blob/main/images/Global-architecture.png)

### Project-structure

- The project is divided into three major categories. The core structure, the services and the supporting microservices.

### Core

* API Gateway:
    - Responsibilities: Acts as an entry point for all client requests, routing them to appropriate services, handling
      cross-cutting concerns such as authentication, logging, rate limiting, and caching.
      Example Tools: Kong, NGINX, Spring Cloud Gateway.
* Config Service:
    - Responsibilities: Centralized configuration management for all microservices.
      Example Tools: Spring Cloud Config, Consul.
* Service Discovery:
    - Responsibilities: Facilitates service registration and discovery, allowing microservices to find and communicate
      with each other.
      Example Tools: Eureka, Consul, Zookeeper.
* Logging and Monitoring:
    - Responsibilities: Collects logs, metrics, and traces from all microservices to monitor application performance and
      health.
      Example Tools: ELK Stack (Elasticsearch, Logstash, Kibana), Prometheus, Grafana.

#### Services

* Auth Service
    - Responsibilities: Managing user accounts, authentication, authorization, token management.
      Endpoints:
        - POST /auth/register - Register a new user.
        - POST /auth/activate - Activate Account
        - POST /auth/login - Sign in user
        - PUT /auth/logout - Sign out user
        - POST /auth/reset-password - Password Reset
        - POST /auth/refresh-token - Refresh Token
* User Service
    - Responsibilities: Managing user related data and operations and managing user profiles.
      Endpoints:
        - GET /users - Get all users
        - GET /users/{id} - Retrieve user details.
        - PUT /users/{id} - Update user details.
        - GET /users/name/{name} - Get user by name
        - DELETE /users/{id} - Delete user account.
* Product Service
    - Responsibilities: Managing product catalog, including product listings, details, categories, and inventory.
      Endpoints:
        - POST /products - Add a new product.
        - GET /products - Retrieve all products.
        - GET /products/{id} - Retrieve product details.
        - PUT /products/{id} - Update product details.
        - DELETE /products/{id} - Delete a product.
        - GET /categories - Retrieve product categories.
* Order Service
    - Responsibilities: Managing customer orders, order status, and order history.
      Endpoints:
        - POST /orders - Create a new order.
        - GET /orders - Retrieve all orders
        - GET /order/{order-id} - Retrieve order-lines
        - GET /orders/user/{userId} - Retrieve orders for a user.
        - PUT /orders/{id} - Update order status.
        - DELETE /orders/{id} - Cancel an order.
* Cart Service
    - Responsibilities: Managing user shopping carts, including adding, updating, and removing items.
      Endpoints:
        - POST /carts - Create a new cart.
        - GET /carts/{userId} - Retrieve cart for a user.
        - PUT /carts/{userId}/items - Add/update items in the cart.
        - DELETE /carts/{userId}/items/{itemId} - Remove item from cart.
* Payment Service
    - Responsibilities: Handling payment processing, including integrations with payment gateways.
      Endpoints:
        - POST /payments - Process a payment.
        - GET /payments/{id} - Retrieve payment details.
        - POST /payments/refund - Process a refund.
* Shipping Service
    - Responsibilities: Managing shipping details, tracking, and logistics.
      Endpoints:
        - POST /shipments - Create a new shipment.
        - GET /shipments/{id} - Retrieve shipment details.
        - PUT /shipments/{id} - Update shipment status.
        - GET /shipments/orders/{orderId} - Retrieve shipment by order ID.

#### Supporting Microservices

* Inventory Service:
    - Responsibilities: Managing stock levels, inventory adjustments, and warehouse locations.
      Endpoints:
      -GET /inventory/products/{productId} - Retrieve inventory for a product.
        - POST /inventory - Adjust inventory levels.
        - GET /inventory/warehouse/{warehouseId} - Retrieve inventory for a warehouse.
* Notification Service:
    - Responsibilities: Sending notifications via email, SMS, or push notifications.
      Endpoints:
        - POST /notifications/email - Send an email notification.
        - POST /notifications/sms - Send an SMS notification.
        - POST /notifications/push - Send a push notification.
* Review Service:
    - Responsibilities: Managing product reviews and ratings.
      Endpoints:
        - POST /reviews - Add a new review.
        - GET /reviews/product/{productId} - Retrieve reviews for a product.
        - DELETE /reviews/{id} - Delete a review.
* Analytics Service:
    - Responsibilities: Collecting and analyzing metrics related to user behavior, sales, and system performance.
      Endpoints:
        - GET /analytics/sales - Retrieve sales data.
        - GET /analytics/users - Retrieve user data.
        - GET /analytics/products - Retrieve product data.
* Recommendation Service:
    - Responsibilities: Providing product recommendations based on user behavior and preferences.
      Endpoints:
        - GET /recommendations/user/{userId} - Retrieve recommendations for a user.
        - GET /recommendations/product/{productId} - Retrieve related product recommendations.

## Database architecture

![micro](https://github.com/ngaridennis33/E-Commerce-Micro-services/blob/main/images/micro-services-entity-domains.png)

# Technologies and Concepts Used

- Java 17
- Spring Boot
- Maven
- PostgreSQL
- Mongo
- Maildev
- kafka
- Zipkin
- JWT
- Eureka

### Security

- JWT Tokens: Used for authentication and authorization.

### Auth Architecture

![micro](https://github.com/ngaridennis33/E-Commerce-Micro-services/blob/main/images/Auth-architecture.png)

### QA/Testing

- JUnit
- Mockito
- Unit Testing
- Integration Testing
- TestContainers

### CI/CD

- Maven
- Docker
- GitHub Actions: Automatically builds, tests and publishes Docker images to Docker Hub.

### Event-Driven Messaging

- Kafka
#### Architecture

![micro](https://github.com/ngaridennis33/E-Commerce-Micro-services/blob/main/images/kafka-broker.png)

### Observability

- Grafana: Data visualization.
- OpenTelemetry: Collect metrics, traces, and logs.
- Grafana Loki: `Logging`.
- Grafana Tempo and Zipkin: `Distributed Tracing`.
- Prometheus: `Metrics`.

### Status

Application status: BETA