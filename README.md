# Enterprise Decision Intelligence (EDI AI)

Enterprise Decision Intelligence (EDI AI) is a corporate decision support platform designed to centralize and analyze business data to provide actionable insights.

## 📋 Table of Contents
- [Overview](#overview)
- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Security](#security)

## Overview
EDI AI leverages advanced AI and event-driven architecture to help enterprises make better decisions. It integrates with various data sources, processes information in real-time, and provides a modern dashboard for visualization and interaction.

## Architecture
- **Event-Driven Architecture**: Uses RabbitMQ for asynchronous communication between services.
- **Hybrid Search**: Combines vector search (Qdrant) with relational data (PostgreSQL).
- **RAG (Retrieval-Augmented Generation)**: Implemented using Spring AI for contextual decision support.

## Tech Stack
- **Backend**: Java 21, Spring Boot 3.4.3, Spring AI (1.0.0-M6).
- **Frontend**: Angular 19, Tailwind CSS, Signals for state management.
- **Data & Messaging**: PostgreSQL 16, Redis 7.4, Qdrant 1.10.1, RabbitMQ 4.0.

## Getting Started

### Prerequisites
- Java 21
- Node.js 20+
- Docker & Docker Compose

### Infrastructure
Start the required services using Docker Compose:
```bash
docker-compose up -d
```

### Backend
```bash
cd backend
./mvnw spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm start
```

## Project Structure
- `backend/`: Spring Boot application containing core logic, RAG implementation, and messaging.
- `frontend/`: Angular 19 application providing the user interface.
- `docker-compose.yml`: Infrastructure orchestration.

## Security
- RBAC (Role-Based Access Control)
- Secure communication via RabbitMQ
- Environment-based configuration for sensitive data

## Contributing
Please follow the standard contribution guidelines for this monorepo.

## License
Proprietary / Enterprise License

---

## 🛠️ Project Deep Dive & Technical Guide

### 🎯 Main Purpose
Decision Intelligence Platform integrating multi-source analysis and secure real-time alerts.

### 🧰 Tecnologias Utilizadas (Tech Stack)
- **Primary Technologies:** Angular 19.2.2, Docker / Docker Compose, Java 21, Maven, Node.js / npm, Spring Boot 3.4.3
- **Deployment Strategy:** Container-ready with standard Docker/Docker Compose integrations where applicable.

### 🚀 Como Implantar e Executar (How to Deploy & Run)
#### Backend (Java / Spring Boot)
1. Navigate to the backend directory.
2. Compile and run: `./mvnw spring-boot:run` or `mvn spring-boot:run`.

#### Frontend (Angular / Node.js)
1. Navigate to the frontend directory.
2. Install dependencies: `npm install`.
3. Run development server: `npm start` or `npm run dev`.

---
