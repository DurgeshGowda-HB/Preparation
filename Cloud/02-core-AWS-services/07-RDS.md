## Amazon RDS

Amazon RDS (Relational Database Service) is a **fully managed relational database service** provided by AWS.

<h3>Why Do We Need RDS?</h3>

Applications need databases to store structured data.

Instead of installing and managing a database server ourselves, we can use **Amazon RDS**.

```text
Users
  │
  ▼
EC2 (Spring Boot Application)
  │
  ▼
Amazon RDS
  │
  ▼
MySQL / PostgreSQL
```

<h2>What is Amazon RDS?</h2>

> **Definition : Amazon RDS is a managed AWS service that makes it easier to set up, operate, and scale relational databases.**

Simply:

> **RDS = Managed SQL Database in AWS.**

<h3>Supported Database Engines</h3>

- MySQL
- PostgreSQL
- MariaDB
- Oracle
- Microsoft SQL Server
- Amazon Aurora

<h3>Why Use RDS?</h3>

AWS manages many infrastructure tasks such as:

- Database setup
- Hardware management
- Automated backups
- Software patching
- Monitoring
- Recovery

This allows developers to focus on the **application and database design** instead of managing the database server.

<h2>Why Do We Need DynamoDB If RDS Exists?</h2>

RDS and DynamoDB solve **different database problems**.

> **RDS = Relational data + SQL + Relationships**

> **DynamoDB = NoSQL + Low Latency + Massive Scale**

<h3>When to Use RDS?</h3>

Use RDS when your application needs:

- Relational data
- SQL queries
- Relationships between tables
- Transactions
- Complex queries

Example:

```text
Hospital Management System

Patients
   │
   ├── Doctors
   │
   ├── Appointments
   │
   └── Billing
```

These entities have relationships, making a relational database such as **RDS** a good choice.

<h3>When to Use DynamoDB?</h3>

Use DynamoDB when your application needs:

- Very low latency
- Massive scalability
- Flexible NoSQL data
- High-speed key-based access
- Serverless applications

Example:

```text
Shopping Cart

User 101 → Cart Data
User 102 → Cart Data
User 103 → Cart Data
```

The application mainly needs fast access to a user's cart.

<h2>RDS vs DynamoDB</h2>

| Feature | Amazon RDS | Amazon DynamoDB |
|---------|------------|-----------------|
| Database Type | Relational / SQL | NoSQL |
| Data Model | Tables, Rows, Columns | Tables, Items, Attributes |
| Query | SQL | NoSQL API |
| Relationships | Strong support | Not the main focus |
| Schema | Structured | Flexible |
| Best For | Relational applications | High-scale, low-latency applications |
| Examples | Hospital, Banking, Order Systems | Shopping Carts, Sessions, Real-time Data |

<h3>Can We Use Both?</h3>

Yes. A single application can use both services for different types of data.

```text
                 Application
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
        RDS                 DynamoDB
          │                     │
     Customer Data          Session Data
     Order Data             Cart Data
     Payment Data           Real-time Data
```

-> Why not install MySQL on EC2?

You can, but then you must manage:

1. Installation
2. Updates
3. Backups
4. Recovery
5. Scaling
6. Monitoring
7. Security

AWS does all of this for you with RDS.
<h2>Key Takeaways</h2>

- **RDS = Managed Relational / SQL Database.**
- RDS is useful when relationships and SQL queries are important.
- **DynamoDB = Managed NoSQL Database.**
- DynamoDB is useful for low-latency and highly scalable workloads.
- RDS is not "better" than DynamoDB.
- DynamoDB is not "better" than RDS.
- Choose the database based on the application's **data model and access pattern**.
- An application can use **both RDS and DynamoDB** when different workloads require different database types.

<h2>-> practice </h2>
<p>
In this practice exercise, we created a VPC with two public subnets and two private subnets. We launched an EC2 instance inside the public subnet and created an RDS database inside the private subnet. Both the EC2 instance and the RDS database reside within the same VPC. We can connect to the EC2 instance directly from a laptop because it has internet access. However, we cannot connect to the RDS database directly from the laptop. This is because the RDS database is placed in a private subnet with public access disabled. The RDS database can only be accessed securely through the EC2 instance, shielding it from the public internetThe Complete Architecture</p>

This is the diagram you should remember:

```
                         INTERNET
                            │
                            │
                       Your Laptop
                            │
                         SSH : 22
                            │
                            ▼
                  ┌──────────────────┐
                  │       EC2        │
                  │                  │
                  │  Public Subnet   │
                  │                  │
                  │ SG: sec-for-ec2  │
                  └────────┬─────────┘
                           │
                      MySQL : 3306
                           │
                           ▼
                  ┌──────────────────┐
                  │       RDS        │
                  │                  │
                  │  Private Subnet  │
                  │                  │
                  │ SG: sec-for-rds  │
                  └──────────────────┘

              Both are inside the same VPC
```

use this command to get correct IPV4 format ip address
```
curl ifconfig.me
```

-> Why EC2 and RDS are in the Same VPC

We put:

EC2 → demo-vpc
RDS → demo-vpc

because they need to communicate through the VPC's private networking.

But remember:

> Same VPC does not mean same subnet.

Our design was:
```
demo-vpc
│
├── Public Subnet
│    └── EC2
│
└── Private Subnet
     └── RDS
```
