# 🛒 Customer Orders Service

[![CI Pipeline - Liquibase, Tests, Health Check](https://github.com/harshavardhan-ofc/spring-customer-orders/actions/workflows/ci.yml/badge.svg)](https://github.com/harshavardhan-ofc/spring-customer-orders/actions/workflows/ci.yml)

A Spring Boot service for managing customer orders, integrated with **Liquibase** for database migrations, fully tested with **JUnit & Mockito**, and continuously validated with **GitHub Actions**.

---

## 📌 Features
- **Spring Boot 3.5.4**
- **PostgreSQL 15** database
- **Liquibase** for managing DB schema and seeding initial data
- **Spring Data JPA + Hibernate**
- **JUnit 5 & Mockito** for unit and integration tests
- **Actuator** health endpoint (`/actuator/health`)
- **GitHub Actions CI** for:
  - Running Liquibase migrations
  - Executing tests
  - Starting the service
  - Running a live health check

---

## 🚀 Getting Started

### Prerequisites
- **Java 21+**
- **Maven 3.9+**
- **PostgreSQL 15+**

---

### Local Development

1. **Clone the repository**
   ```
   git clone https://github.com/harshavardhan-ofc/spring-customer-orders.git
   cd spring-customer-orders
   ```

2. **Start PostgreSQL locally** (or use Docker)
   ```
   docker run --name postgres15 ^
     -e POSTGRES_DB=customer_order_db ^
     -e POSTGRES_USER=postgres ^
     -e POSTGRES_PASSWORD=Harsha@123 ^
     -p 5432:5432 ^
     postgres:15
   ```

3. **Run the application**
   ```
   mvn spring-boot:run -Dspring-boot.run.profiles=ci
   ```

---

## 🧪 Running Tests
```
mvn clean verify -Dspring.profiles.active=ci
```

---

## 📦 Liquibase Migrations
Liquibase changesets are located at:
```
src/main/resources/db/changelog/db.changelog-master.xml
```
They create the initial schema and seed sample data on application startup.

---

## 🔍 Health Check
Once running, verify the service is healthy:
```
curl http://localhost:8080/actuator/health
```
Expected output:
```
{"status":"UP"}
```

---

## ⚡ CI/CD Pipeline
This repository includes **GitHub Actions** workflow:
- Location: `.github/workflows/ci.yml`
- Workflow name: *CI Pipeline - Liquibase, Tests, Health Check*
- Triggered on every push, PR to `master`, or manual run
- Steps:
  1. Spin up PostgreSQL in GitHub Actions
  2. Wait for DB readiness
  3. Build Spring Boot jar
  4. Start the app in background
  5. Run health check
  6. Execute tests
  7. Upload test reports

---

## 📜 License
This project is licensed under the MIT License.
```
