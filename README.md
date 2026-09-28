# 👥 Employee Management API

A REST API for managing employees and departments, built with **Spring Boot 4**, **Spring Data JPA** and **MySQL**, with request validation and clean error handling.

![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)

## ✨ Features

- Full CRUD for **departments** and **employees**
- **One-to-many** relationship: each employee belongs to a department
- Look up all employees in a department
- **Bean Validation** on input (`@Valid`, `@NotBlank`, `@Email`)
- **Custom exceptions** (`EmployeeNotFoundException`, `DepartmentNotFoundException`) mapped to proper HTTP responses by a **global exception handler**
- **DTOs** for API responses

## 📦 Data model

```
Department (id, name, description)
    └──< Employee (id, name, email, position, salary)
```

## 🔌 API endpoints

### Departments
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/departments` | Create a department |
| `GET` | `/departments` | List departments |
| `GET` | `/departments/{id}` | Get a department |
| `PUT` | `/departments/{id}` | Update a department |
| `DELETE` | `/departments/{id}` | Delete a department |

### Employees
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/employees` | Create an employee |
| `GET` | `/employees` | List employees |
| `GET` | `/employees/{id}` | Get an employee |
| `GET` | `/employees/department/{departmentId}` | Employees in a department |
| `PUT` | `/employees/{id}` | Update an employee |
| `DELETE` | `/employees/{id}` | Delete an employee |

## 🚀 Getting started

**Prerequisites:** Java 21 and MySQL 8

```sql
CREATE DATABASE employeedb;
```

Copy the config template and add your database password (the real file is git-ignored):

```bash
mkdir -p src/main/resources
cp application.properties.example src/main/resources/application.properties
./mvnw spring-boot:run        # Windows: mvnw.cmd spring-boot:run
```

## 🧪 Try it

Ready-made requests are in [`test.http`](test.http), or:

```bash
curl -X POST localhost:8080/departments -H "Content-Type: application/json" \
  -d '{"name":"Engineering","description":"Builds the product"}'

curl localhost:8080/employees/department/1
```

## 🛣️ Roadmap
- [ ] Pagination and sorting
- [ ] Search by name and position
- [ ] OpenAPI / Swagger UI
- [ ] Unit and integration tests

## 👤 Author
**Anjan Rimal** · [Portfolio](https://anjanrimal.com/) · [LinkedIn](https://www.linkedin.com/in/anjanrimal) · [GitHub](https://github.com/AnjanRimal)
