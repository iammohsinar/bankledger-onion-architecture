# 🧅 Onion Architecture — Bank Account Example (Spring Boot)

This repository will only demonstrate the **Onion Architecture** pattern using a **Bank Ledger** example in **Spring Boot**.  
Currently, the implementation is **in progress**, but the structure and design approach are already defined.

---

## 🚧 Project Status
> 🕐 Work in Progress  
To understand the onion architecture, the basic implementation is done, however the complete application is **in progress**.

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

---

<p align="center">
  <img src="/assets/Onion-architecture.png" alt="Onion Architecture" width="400"/>
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
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **H2/PostgreSQL database**
- **Lombok**
- **JUnit + Mockito** for testing

## 📦️ Application Project Structure (Intellij idea)

- Main project directory structure
<p align="center">
  <img src="/assets/project-directory-structure.png" alt="Onion Architecture" width="400"/>
</p>

- Project package structure
<p align="center">
  <img src="/assets/project-package-structure.png" alt="Onion Architecture" width="400"/>
</p>

## 🧪 Test Domain layer without Spring boot.

<p align="center">
  <img src="/assets/project-directory-structure.png" alt="Onion Architecture" width="400"/>
</p>

- Run any **Test Cases** available in following classes.
- `DomainCustomerAccountServiceTests.java` & `DomainFundTransferServiceTests.java` 


## 🚀 Initial Application Setup & Run

- Clone application
- Open in intellij idea
- Run `BankledgerOnionArchitectureApplication.java` class
- Open any `Rest api` client and add following payload:
```
curl --location 'localhost:8080/customers/v1/create' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 1,
  "name": "John Doe",
  "cellPhoneNumber": "+1-555-1234567",
  "email": "john.doe@example.com",
  "idCardNumber": "ID-999888777",
  "passportNumber": "P-1234567",
  "businessCustomer": true,
  "address": "123 Street, City, Country",
  "customerDocument": {
    "length": 12000000,
    "extension": ".pdf"
  }
}
```

- To access `H2 datbase` open browser and paste url `http://localhost:8080/h2-console`