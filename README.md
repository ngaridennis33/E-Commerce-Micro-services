# REST Microservices architecture for E-commerce

> Implementation of a REST Microservices in an E-Commerce with Spring boot, Cloud and multiple modules.

### Table of contents

- [Project architecture](#Project-architecture)
- [Project structure](#Project-structure)
- [Database architecture](#Database-architecture)
- [Tools and Technologies](#technologies)
- [Features](#features)
- [Status](#status)
- [Contact](#contact)

### Project architecture
![micro](https://github.com/ngaridennis33/E-Commerce-Micro-services/blob/main/images/architecture.png)

### Project-structure
#### Microservices Overview:
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
* User Service
    - Responsibilities: Managing user accounts, authentication, authorization, user profiles, and user settings.
      Endpoints:
        - POST /users - Register a new user.
        - GET /users/{id} - Retrieve user details.
        - PUT /users/{id} - Update user details.
        - DELETE /users/{id} - Delete user account.
        - POST /auth/login - User login.
        - POST /auth/logout - User logout.

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
        - GET /orders/{id} - Retrieve order details.
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

![micro](https://github.com/ngaridennis33/E-Commerce-Micro-services/blob/main/images/ER-Diagram.png)

## Tables in each database service
1. User Service: account, user, user_address, wishlist
2. Product Service:	products, categories, sub_categories, product_inventory, discount
3. Order Service: order_details, order_item
4. Cart Service: cart
5. Payment Service:	payment_details
6. Shipping Service: user_address (shared with User Service)

# Technologies and Concepts Used

- Java 17
- Spring Boot
- Maven
- PostgreSQL

### Architecture
- Microservices
- API Gateway Pattern: An `API Gateway` on the edge of the microservices.
- Service Registration and Discovery: using `Netflix Eureka` for service registration and discovery.

### Security
- JWT Tokens: Used for authentication and authorization.

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

### Observability
- Grafana: Data visualization.
- OpenTelemetry: Collect metrics, traces, and logs.
- Grafana Loki: `Logging`.
- Grafana Tempo and Zipkin: `Distributed Tracing`.
- Prometheus: `Metrics`.