# Mini-Commerce Architecture Overview

## 1. High-Level Overview

![High Level Architecture](/docs/mini-commerce-architecture.png)

Sistem terdiri dari **3 microservices**:

1. **User Service** – manage user accounts, authentication, JWT token
2. **Product Service** – manage products, stock, pricing
3. **Order Service** – manage orders, validate user & product, update stock

**Database:**

![DB Diagram](/docs/mini-commerce-db-diagram.png)

* 1 PostgreSQL instance shared (initially)
* Tables: `users`, `products`, `orders`, `order_items`

**Communication:**

* Microservices saling berkomunikasi via **REST JSON API** (HTTP)
* Internal service discovery melalui **Docker container name**
* External communication (frontend) via exposed ports

---

## 2. Components

### 2.1 Microservices (Artifacts)

| Service         | Responsibility                                      | Port | Communication |
| --------------- | --------------------------------------------------- |------| ------------- |
| user-service    | register/login, JWT generation, user validation     | 8080 | REST API      |
| product-service | CRUD product, stock management                      | 8082 | REST API      |
| order-service   | create order, validate user/product, decrease stock | 8081 | REST API      |

### 2.2 Database

* PostgreSQL 16
* Shared DB for MVP
* Schema minimal:

    * `users(id, name, email, password, created_at, created_by)`
    * `products(id, name, price, stock, created_at)`
    * `orders(id, user_id, status, total_amount, created_at)`
    * `order_items(order_id, product_id, product_name, quantity, price)`

### 2.3 Networking

* **Docker Network** (`mc-net`) untuk service-to-service connectivity
* Service access via container name (DNS)
* Example: `order-service` call `http://product-service:8080/api/v1/products/1`

---

## 3. Flow Overview

### 3.1 Authentication Flow

1. Client → user-service: `/login`
2. user-service → validate credentials → generate JWT
3. Client → store JWT → use for requests to order/product services
4. order-service → verify JWT via user-service (or shared secret)

### 3.2 Order Flow

1. Client → order-service: create order
2. order-service → user-service: validate user
3. order-service → product-service: validate product & check stock
4. order-service → DB: create order + order_items
5. order-service → product-service: decrease stock
6. order-service → Client: return order confirmation

### 3.3 Product Management

* Product CRUD endpoints managed by product-service
* Stock updates only via order-service

---

## 4. Deployment & Runtime

![DB Diagram](/docs/mini-commerce-deployment-diagram.png)

* **Docker Compose**:

    * Each service in separate container
    * Postgres in container with volume persistence
    * Exposed ports for local dev:

        * user: 8080
        * product: 8082
        * order: 8081
* **Environment Variables** for:

    * DB URL, username, password
    * JWT secret
    * Service port

---

## 5. Design Principles

* **Independent deployable services**
* **REST-based internal communication** (can later migrate to gRPC if needed)
* **Stateless services** (except DB)
* **Simple error handling & logging**
* **Security by JWT**

---

## 6. Optional Extensions (future)

* Separate DB per service for true microservice separation
* Async messaging (Kafka/RabbitMQ) for order events
* Caching (Redis) for product data
* Load balancer / API gateway
* Rate limiting & monitoring
