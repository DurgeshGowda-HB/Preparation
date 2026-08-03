## Amazon DynamoDB

Amazon DynamoDB is a **fully managed NoSQL database** service provided by AWS for storing and retrieving large amounts of data with **low latency**.

>it's non-relational database

<h3>Why Do We Need DynamoDB?</h3>

Traditional relational databases may require more management and scaling effort.

DynamoDB is designed for:

- High Performance
- Automatic Scaling
- Low Latency
- Serverless Applications

<h2>What is Amazon DynamoDB?</h2>

> **Definition:** Amazon DynamoDB is a fully managed NoSQL database service that provides fast and predictable performance with automatic scaling.

Simply:

> **DynamoDB = A fast, scalable NoSQL database managed by AWS.**

<h3>How DynamoDB Works</h3>

```text
Application
      │
      ▼
Amazon DynamoDB
      │
Store / Retrieve Data
```

<h2>Key Concepts</h2>

### Table

> A **Table** is a collection of data.

Example:

```text
Student Table
```

### Item

> An **Item** is a single record in a table.

Example:

```text
Student
├── ID : 101
├── Name : Durgesh
└── Age : 21
```

### Attribute

> An **Attribute** is a property of an Item.

Example:

- ID
- Name
- Age

<h3>Common Use Cases</h3>

- User Profiles
- Shopping Carts
- Gaming Applications
- IoT Applications
- Serverless Applications
- Real-time Applications

<h3>Benefits of DynamoDB</h3>

- Fully Managed
- NoSQL Database
- Automatic Scaling
- Low Latency
- Highly Available
- Serverless

<h3>DynamoDB vs RDS</h3>

| DynamoDB | Amazon RDS |
|-----------|------------|
| NoSQL Database | Relational Database (SQL) |
| Schema Flexible | Fixed Schema |
| Automatic Scaling | Manual / Auto Scaling |
| Best for High-Speed Applications | Best for Relational Data |

<h3>Amazon S3 vs Amazon DynamoDB</h3>

| Feature | Amazon S3 | Amazon DynamoDB |
|---------|-----------|-----------------|
| Service Type | Object Storage Service | Managed NoSQL Database |
| Stores | Files (Objects) | Structured NoSQL Data |
| Data Limit | Up to **5 TB** per object | Up to **400 KB** per item |
| Latency | Milliseconds | Single-digit milliseconds |
| Best Used For | Images, Videos, Documents, Backups, Logs | User Profiles, Session Data, Shopping Carts, Real-time Applications |
| Data Structure | Buckets → Objects | Tables → Items → Attributes |
| Cost Model | Charged based on storage, requests, and data transfer | Charged based on storage and read/write capacity (or on-demand requests) |

<h2>Key Takeaways</h2>

- DynamoDB is a **fully managed NoSQL database**.
- Data is stored in **Tables**, **Items**, and **Attributes**.
- It provides **high performance** and **low latency**.
- DynamoDB automatically scales based on application demand.
- It is widely used in **serverless**, **real-time**, and **high-traffic** applications.