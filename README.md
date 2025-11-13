<p align="center">
  <img src="https://skillicons.dev/icons?i=java,spring,mongodb" />
</p>
<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-2.5.7-brightgreen"/>
  <img src="https://img.shields.io/badge/Database-MongoDB-success"/>
  <img src="https://img.shields.io/badge/Docs-Swagger%20UI-blueviolet"/>
</p>

---
# 🚀 JobBoardX – A Spring Boot + MongoDB Job Listing API

> _"Built from curiosity, refined with best practices."_  
> I once came across a company’s career page on LinkedIn and wondered: **how do they manage and serve hundreds of job listings behind the scenes?**  
> That curiosity became this project — a hands-on backend exploration into modern, scalable API design using **Spring Boot** and **MongoDB**.

---

## 🧠 Project Overview

**JobBoardX** is a production-grade REST API built with **Spring Boot** and **MongoDB** that demonstrates how job-posting platforms handle:
- data storage and retrieval,
- paginated listings,
- search queries,
- validation,
- and clean error reporting.

It’s intentionally simple — yet designed using **industry-standard backend patterns**:
- **Controller → Repository → Model** separation
- **Pagination & Sorting** (Spring Data)
- **Input Validation** (Bean Validation)
- **Global Exception Handling**
- **Interactive API Docs via Swagger UI**

---

## 🏗️ Architecture

```mermaid
%% Force a light-ish palette + dark text in all modes
%% (GitHub supports this init block)
%%{init: {'theme':'base', 'themeVariables': {
  'fontFamily': 'Inter, Segoe UI, Arial, sans-serif',
  'primaryColor':  '#f6d365',
  'primaryTextColor': '#000',
  'secondaryColor':'#a5d6a7',
  'secondaryTextColor':'#000',
  'tertiaryColor':'#90caf9',
  'tertiaryTextColor':'#000',
  'lineColor':'#333',
  'textColor':'#000'
}}}%%

flowchart LR
  A[Swagger UI / React / Postman]:::client -->|HTTP| B[PostController]:::controller
  B --> C[PostRepository]:::repo
  B --> D[SearchRepositoryImpl]:::repo
  C --> E[(MongoDB)]:::db
  D --> E

  %% Explicit class styles (with black text)
  classDef client fill:#f6d365,stroke:#333,stroke-width:1px,color:#000;
  classDef controller fill:#90caf9,stroke:#333,stroke-width:1px,color:#000;
  classDef repo fill:#a5d6a7,stroke:#333,stroke-width:1px,color:#000;
  classDef db fill:#ef9a9a,stroke:#333,stroke-width:1px,color:#000;

  %% Make the edge label readable, too
  linkStyle default stroke:#333,color:#000,stroke-width:1px;


```

<img width="526" height="600" alt="image" src="https://github.com/user-attachments/assets/825a4a2e-29ed-4522-8f48-68b05b084d38" />


---

## ⚙️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend Framework** | Spring Boot (v2.5.7) |
| **Database** | MongoDB (Atlas / Local) |
| **Language** | Java 17 |
| **API Documentation** | Swagger 2 (Springfox) |
| **Build Tool** | Maven |
| **Validation** | Hibernate Validator (JSR-303) |
| **Error Handling** | Custom `@ControllerAdvice` Handler |

---

## 🚀 Features

✅ **1. MongoDB Integration**  
Connects seamlessly to a cloud or local MongoDB instance using `application.properties`.

✅ **2. RESTful Endpoints**  
CRUD-style routes for job listings with clean, descriptive URLs.

✅ **3. Pagination & Sorting**  
Efficiently returns data slices via `Pageable`.  
Example:
GET /api/posts/page?page=0&size=5&sort=exp,desc

✅ **4. Full-Text Search**  
Uses MongoDB Atlas Search to find posts by keywords in real time:
GET /api/posts/{text}

✅ **5. Input Validation**  
Rejects malformed requests automatically (e.g., empty fields, negative experience).

✅ **6. Global Exception Handling**  
Standardized, developer-friendly error responses in json format


✅ **7. Swagger UI**
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 🔍 **API Endpoints Summary**

| **Method** | **Endpoint**           | **Description**                    |
|-------------|------------------------|------------------------------------|
| **GET**     | `/api/posts`           | Fetch all job posts                |
| **GET**     | `/api/posts/page`      | Fetch paginated job posts          |
| **GET**     | `/api/posts/{text}`    | Search job posts by keyword        |
| **POST**    | `/api/post`            | Add a new job post _(validated)_   |

---

## 🧩 **Example Walkthrough**

Below are some snapshots showing how the JobBoardX API works — from data insertion to validation and error handling.

---

### ⚙️ **Swagger UI Overview**

<img width="1660" height="260" alt="Swagger Overview" src="https://github.com/user-attachments/assets/19db50ff-45da-4880-a0c7-ee16c46dfdde" />

<img width="1651" height="501" alt="Swagger Endpoints" src="https://github.com/user-attachments/assets/15ce4a0a-b707-4c35-86e8-e1cea80ea8ff" />

---

### 🧾 **Example Requests**

#### 🟢 Add Data to MongoDB
Demonstrates adding a new job post through the `/api/post` endpoint.

<img width="943" height="1228" alt="Add Data" src="https://github.com/user-attachments/assets/4ee7a011-aed6-4164-af0e-c3f48b3e5f61" />

---

#### 📋 Get All Job Posts
Fetches all available job listings stored in the MongoDB collection.

<img width="898" height="1029" alt="Get All Posts" src="https://github.com/user-attachments/assets/5ce5ebe7-2fd2-47b1-9262-4203605591cf" />

---

#### 🔍 Search Job Posts by Text
Searches for posts containing specific text using MongoDB Atlas Search.

<img width="903" height="1012" alt="Search by Text" src="https://github.com/user-attachments/assets/065a4608-fac3-4f89-b410-79b744c669d4" />

---

#### 📄 Pagination in Action
Displays how results are neatly paginated and structured after adding the pagination feature.

<img width="3439" height="348" alt="Pagination" src="https://github.com/user-attachments/assets/13a419bd-dda1-4678-862e-8ded9829240a" />

---

#### ✅ Input Data Validation
Demonstrates field-level validation in action when invalid or incomplete data is submitted.

<img width="914" height="1223" alt="Validation Example" src="https://github.com/user-attachments/assets/6c0afb3a-fd56-4c33-a50b-72d0168ca9d0" />

---

#### ⚠️ Global Exception Handling
Shows how structured, user-friendly error messages (with field-level details and status codes) are returned via the global exception handler.

<img width="1170" height="1199" alt="Error Handler" src="https://github.com/user-attachments/assets/11f5a3db-60c8-4ee6-bcdc-e689f2bde14c" />

---

> 🧠 These examples illustrate how **clean API design**, **validation**, and **structured error handling** turn a simple project into a **production-ready backend system**.

## 🧩 **How to Run Locally**

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/jobboardx.git
cd jobboardx
```
### 2️⃣ Configure MongoDB

In src/main/resources/application.properties, update your credentials:
```bash
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/
spring.data.mongodb.database=JobListing
server.port=8080
```
### 3️⃣ Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```
Once the application starts, open Swagger UI to explore the endpoints:
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 🧠 ***Learning Goals***

Through this project, I gained a deep understanding of:

🧩 How backend frameworks map HTTP requests to Java methods

🗃️ How MongoDB schemas differ from traditional relational models

⚙️ How pagination and sorting enhance scalability

✅ How enterprise-grade systems enforce validation and consistent error handling

### 🧑‍💻 ***Future Enhancements***

 - Add DTO layer for cleaner API contracts

 - Implement JWT-based authentication for secured access

 - Build a React frontend dashboard to visualize paginated job posts

 - Containerize the app using Docker + Docker Compose

 - Deploy on AWS EC2 / Elastic Beanstalk for production hosting

### 🧭 ***Author***

👩‍💻 Dileep Kanumuri
Software Engineer | Full-Stack Developer | AI/ML Enthusiast

## 📚 References

This project was inspired and guided by the following resources:

- **🎥 YouTube Tutorial:**  
- [Spring Boot + MongoDB CRUD API](https://www.youtube.com/watch?v=kYiLzIiHVY8) by *Navin*  
  *I followed this tutorial as a base and later enhanced it with pagination, input validation, and a global exception handler.*

- **📘 Spring Boot Documentation:**  
  [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.7/reference/htmlsingle/)

- **🗃️ Spring Data MongoDB:**  
  [Spring Data MongoDB Docs](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)

- **✅ Validation (JSR-303/380):**  
  [Spring Boot Validation Guide](https://docs.spring.io/spring-boot/docs/2.5.7/reference/htmlsingle/#boot-features-validation)

- **🧭 Swagger / Springfox:**  
  [Springfox Swagger 2.x Documentation](https://springfox.github.io/springfox/)

- **🔍 MongoDB Atlas Search:**  
  [MongoDB Atlas Search Documentation](https://www.mongodb.com/docs/atlas/atlas-search/)







  

