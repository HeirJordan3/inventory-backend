

# 🛠️ Inventory Management Backend

This is the **Spring Boot backend** for the Inventory Management System.

It provides a REST API to add, view, update, and delete inventory items.  
Each item includes a name, quantity, location, and locker combination.

---

## 📦 Tech Stack

- Java 17+
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA
- H2 (in-memory database)
- Maven

---

## 🚀 How to Run This Project

### 1. Clone the repository
```bash

git clone https://github.com/your-username/inventory-backend.git
cd inventory-backend
````

### 2. Run the application

If using Maven:

```bash
./mvnw spring-boot:run
```

Your app will start at:

```
http://localhost:8080
```

---

## 🌐 API Endpoints

| Method | Endpoint                               | Description       |
| ------ | -------------------------------------- | ----------------- |
| GET    | `/api/v1/inventory`                    | Get all items     |
| POST   | `/api/v1/inventory`                    | Create a new item |
| GET    | `/api/v1/inventory/{id}`               | Get item by ID    |
| GET    | `/api/v1/inventory/lookup?name={name}` | Get item by name  |
| PUT    | `/api/v1/inventory/{id}`               | Update item       |
| DELETE | `/api/v1/inventory/{id}`               | Delete item       |

---

## ⚙️ Configuration

Basic config for testing (in `src/main/resources/application.properties`):

```properties
# Enable H2 database
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
```

---

## 🔒 CORS Setup

To connect to the frontend (localhost:3000), add to your controller:

```java
@CrossOrigin(origins = "http://localhost:3000")
```

---

## ✅ To Do

* Add unit tests
* Add category and description fields
* Connect a production database (e.g., PostgreSQL)
* Deploy with Render, Heroku, or Fly.io

---

## 📄 License

MIT – Free to use, modify, and share

```

---

Let me know if you'd like one for the **frontend** next!
```
