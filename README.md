# 🚀 Distributed Log Analytics Platform

A full-stack distributed log analytics platform built with **Spring Boot** and **React** that enables centralized log ingestion, real-time monitoring, advanced search, analytics, and alerting.

The platform demonstrates concepts used in modern observability tools like **Grafana**, **Kibana**, and **Datadog**.

---

## 📌 Features

### 🔹 Log Management
- Create, Update, Delete Logs
- View All Logs
- Search Logs
- Request Validation
- Global Exception Handling

---

### 🔹 Advanced Search
- Dynamic Search using Spring JPA Specifications
- Pagination
- Sorting
- Multi-field Filtering
- Apache Lucene Full-Text Search

---

### 🔹 Analytics Dashboard
- Log Level Distribution
- Application-wise Log Count
- Daily Log Volume
- Interactive Charts using Apache ECharts

---

### 🔹 Real-Time Monitoring
- Live Tail using WebSocket (STOMP + SockJS)
- Real-time log updates without page refresh

---

### 🔹 gRPC Integration
- High-performance log ingestion using gRPC
- Protocol Buffers (protobuf)

---

### 🔹 Alert Engine
Automatically detects important logs such as:

- ERROR
- WARN

and processes alerts in real time.

---

### 🔹 API Documentation
- Swagger / OpenAPI Integration

---

## 🏗 Architecture

```
                +------------------+
                |   React Frontend |
                +---------+--------+
                          |
             REST API / WebSocket
                          |
        +-----------------+----------------+
        |                                  |
+-------v--------+               +---------v---------+
| Spring Boot API|               | gRPC Log Service |
+-------+--------+               +---------+---------+
        |                                  |
        +-----------------+----------------+
                          |
                 Business Services
                          |
        +-----------------+----------------+
        |                                  |
   PostgreSQL Database             Apache Lucene
        |                           Search Index
        |
   Analytics Engine
```

---

# 🛠 Tech Stack

## Backend

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Apache Lucene
- gRPC
- WebSocket (STOMP)
- Maven
- Swagger / OpenAPI
- Lombok

---

## Frontend

- React
- Material UI (MUI)
- Apache ECharts
- Axios
- React Router
- STOMP
- SockJS

---

## Database

- PostgreSQL

---

# 📂 Project Structure

```
Distributed-Log-Analytics/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── grpc/
│   ├── websocket/
│   ├── lucene/
│   └── specification/
│
├── frontend/
│   ├── components/
│   ├── pages/
│   ├── layouts/
│   ├── services/
│   ├── charts/
│   ├── context/
│   └── theme/
│
└── README.md
```

---

# 📸 Screenshots

## Dashboard
<img width="1363" height="606" alt="image" src="https://github.com/user-attachments/assets/4a463d0d-9ed1-489e-9314-bfb3ac12d590" />

---

## Analytics

> <img width="1365" height="600" alt="image" src="https://github.com/user-attachments/assets/558aeda5-9034-482a-ad2b-d008936b8abd" />


---

## Search

> <img width="1364" height="595" alt="image" src="https://github.com/user-attachments/assets/f79304d0-be5a-4971-b16f-31aa08764f76" />
---

## Live Tail

<img width="1363" height="387" alt="image" src="https://github.com/user-attachments/assets/61d0937b-c492-40e9-9f9a-fb5933a3fd3b" />
---

# ⚙️ Installation

## Clone Repository

```bash
git clone https://github.com/<your-username>/<repository-name>.git
```

---

## Backend

```bash
cd backend
```

### Configure PostgreSQL

Update:

```
application.properties
```

```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

Run

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

Backend runs on

```
http://localhost:8080
```

Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## Frontend

```bash
cd frontend
```

Install packages

```bash
npm install
```

Run

```bash
npm run dev
```

Frontend

```
http://localhost:5173
```

---

# REST APIs

## Logs

```
POST    /api/logs
GET     /api/logs
GET     /api/logs/{id}
PUT     /api/logs/{id}
DELETE  /api/logs/{id}
```

---

## Search

```
POST /api/logs/search
GET  /api/logs/search/message
```

---

## Analytics

```
GET /api/analytics/log-level-count

GET /api/analytics/application-count

GET /api/analytics/logs-per-day
```

---

# Real-Time Endpoint

WebSocket

```
/ws
```

Topic

```
/topic/logs
```

---

# gRPC

```
SaveLog()
```

using

```
log.proto
```

---

# Future Enhancements

- Authentication & Authorization
- Elasticsearch Integration
- Kafka Log Streaming
- Docker Deployment
- Kubernetes Deployment
- Prometheus Metrics
- CI/CD Pipeline
- Role Based Access Control

---

# Learning Outcomes

This project demonstrates:

- Spring Boot REST APIs
- Spring Data JPA
- Dynamic Specifications
- Apache Lucene
- WebSocket Communication
- gRPC Integration
- Real-Time Dashboards
- React + Material UI
- Data Visualization
- Full Stack Application Development

---

# Author

**SHIFA AHMED**
GitHub:
https://github.com/shifaahmed10x
---
**Shivam Kashaudhan**
GitHub: 
