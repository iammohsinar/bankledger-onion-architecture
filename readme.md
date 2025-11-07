# 🧅 Onion Architecture — Bank Account Example (Spring Boot)

This repository will only demonstrate the **Onion Architecture** pattern using a **Bank Ledger** example in **Spring Boot**.  
Currently, the implementation is **pending**, but the structure and design approach are already defined.

---

## 🚧 Project Status
> 🕐 Work in Progress  
Implementation is **coming soon** — code structure and architecture plan are being prepared.

---

## 🎯 Project Overview
The goal of this project is to showcase how **Onion Architecture** promotes:
- **Separation of concerns**
- **Independent testability**
- **Domain-driven design principles**
- **Reduced coupling between layers**

The example will revolve around a **Bank Ledger system**, fully focused on Onion Architecture only, the following business structure can be split in individual microservices:
- Customer 
  - Individual
  - Business
- Transaction
  - Internal
  - External
- Loan
  - Personal finance
  - Home finance
  - Car finance

---

<p align="center">
  <img src="/Onion-architecture.png" alt="Onion Architecture" width="400"/>
</p>

## 🧠 What Is Onion Architecture?

**Onion Architecture** is a layered architectural pattern introduced by *Jeffrey Palermo* in 2008.  
The core domain is protected from changes in the outer layers.
Outer layers depend on inner layers. “Independence of frameworks, databases, and UI.”

### 🔁 Onion Layered Structure (Domain, Application, Infrastructure)
- **Domain Core** │ → Entities, Domain Logic, Business rules, Services, Interfaces
- **Application Layer** │ → Use Cases, Services, DTOs
- **Infrastructure Layer** │ → Framework, Repositories, External APIs, DB
- Outer layer [Optional] │ → Observability, Jobs, UI, API


### 🧪 Test Each Layer ✅

- **Domain Tests** | Test cases for business rules and logic independent of layers
- **Integration Tests** | Tests Database , File systems or I/O operation with business rules and logic.
- **E2E Tests flows** | Test end to end flows defined in architecture e-g: Fund transfer from one account to another account.

---

## 🏗️ Planned Implementation (Spring Boot)
The project will use:
- **Spring Boot 3+**
- **Spring Data JPA**
- **H2/PostgreSQL database**
- **Lombok**
- **JUnit + Mockito** for testing