# Spring Security JWT Authentication

This project implements **user signup and login using Spring Security with JWT authentication**.  
After successful login, a **JWT token is generated and returned**, which is used to access secured APIs.

---

## 🚀 Features

- User Signup (Register new users)
- User Login (Authenticate users)
- JWT Token generation on successful login
- Role-based authorization
- Stateless authentication (no sessions)
- Password encryption using BCrypt
- PostgreSQL database integration

---

## 🛠 Tech Stack

- Java 25
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Hibernate / JPA
- Maven

---

## 📂 Project Structure
src/main/java
└── com.secure.ram
├── controller
│ └── AuthController.java
├── dto
│ ├── LoginRequestDto.java
│ ├── LoginResponseDto.java
│ └── SignUpResponseDto.java
├── security
│ ├── AuthService.java
│ ├── JwtUtil.java
│ └── SecurityConfig.java
├── entity
├── repository
└── Application.java

---

## 🔐 Authentication Flow (JWT)

1. User signs up using `/auth/signup`
2. Password is encrypted and saved in DB
3. User logs in using `/auth/login`
4. On successful login:
   - JWT token is generated
   - Token is returned in response
5. Client sends JWT token in `Authorization` header
6. Secured APIs validate JWT before allowing access

---

## 📌 API Endpoints

### 🔹 Signup

**POST** `/auth/signup`

**Request Body**
```json
{
  "username": "ram",
  "password": "password123"
}


