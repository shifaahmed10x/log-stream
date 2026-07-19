# Log Stream - Project Architecture

## Project Overview

Log Stream is a distributed log analytics and alerting platform that collects application logs, stores them efficiently, indexes them for fast searching, generates alerts based on defined rules, and provides analytics through a dashboard.

---

# Objectives

- Collect logs from multiple applications.
- Store logs in PostgreSQL.
- Index logs using Apache Lucene.
- Search logs efficiently.
- Generate alerts.
- Display analytics through a dashboard.

---

# Technology Stack

## Backend

- Java 21
- Spring Boot
- Spring Data JPA
- Maven

## Database

- PostgreSQL

## Search Engine

- Apache Lucene

## Communication

- gRPC

## Frontend

- React

## Version Control

- Git
- GitHub

---

# High Level Flow

```
Application
      │
      ▼
gRPC Server
      │
      ▼
Log Processing Service
      │
      ├──────────────► PostgreSQL
      │
      └──────────────► Apache Lucene
                              │
                              ▼
REST APIs
                              │
                              ▼
Dashboard
                              │
                              ▼
Alert Engine
```

---

# Backend Package Structure

```
com.axelero.logstream
│
├── config
├── constants
├── controller
├── dto
├── entity
├── enums
├── exception
├── grpc
├── lucene
├── mapper
├── repository
├── scheduler
├── service
│     └── impl
└── util
```

---

# Package Responsibilities

## config

Spring configuration classes.

---

## controller

REST API endpoints.

---

## dto

Request and Response models.

---

## entity

Database entities.

---

## enums

Application enums.

---

## repository

Database layer.

---

## service

Business interfaces.

---

## service.impl

Business implementation.

---

## grpc

gRPC server implementation.

---

## lucene

Lucene indexing and searching.

---

## mapper

Entity ↔ DTO conversion.

---

## util

Utility classes.

---

## exception

Global exception handling.

---

## scheduler

Scheduled jobs.

---

# Main Modules

## Module 1

Log Ingestion

Responsibilities

- Receive logs
- Validate logs
- Store logs
- Forward for indexing

---

## Module 2

Search & Indexing

Responsibilities

- Index logs
- Search logs
- Filter logs

---

## Module 3

Alert Engine

Responsibilities

- Monitor logs
- Evaluate alert rules
- Trigger notifications

---

## Module 4

Analytics Dashboard

Responsibilities

- Statistics
- Charts
- Reports

---

# Development Roadmap

## Phase 1

Project Setup

- Repository
- Git Workflow
- Spring Boot
- PostgreSQL

---

## Phase 2

Core Backend

- Entity
- Repository
- Service
- Controller

---

## Phase 3

gRPC Integration

---

## Phase 4

Apache Lucene

---

## Phase 5

Alert Engine

---

## Phase 6

Analytics Dashboard

---

# Branch Strategy

```
main
│
develop
│
feature/backend-foundation
feature/log-module
feature/grpc
feature/lucene
feature/alert-engine
feature/dashboard
```

---

# Coding Standards

- Follow package structure.
- Write meaningful commit messages.
- Never commit directly to main.
- Create Pull Requests to develop.
- Keep classes small and focused.
- Follow Java naming conventions.