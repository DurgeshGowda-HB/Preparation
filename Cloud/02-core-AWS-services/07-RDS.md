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

This is the architecture we are building:

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

<h2>-> Why EC2 and RDS are in the Same VPC
</h2>
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

<h2>-> DB Subnet Group (this is insdide the RDS)
</h2>
This was one of the biggest concepts we learned.
A DB subnet group is a collection of existing subnets that RDS can use.
It does not create new subnets.

We already had:

Private Subnet 1
Private Subnet 2

Then created:
```
DB Subnet Group
│
├── Private Subnet 1
└── Private Subnet 2
```
The subnets were in different Availability Zones:

Private Subnet 1 → AZ-A

Private Subnet 2 → AZ-B

Simple memory trick

Subnet
= Actual network

DB Subnet Group
= Collection of subnets for RDS

<h2>-> we created two separate security group for ec2 and rds
</h2>

For the EC2 instance, we granted internet access restricted only to my specific IP address. For the RDS security, we added a rule to its security group that references the security group attached to the EC2 instance. This configuration allows the EC2 instance to be accessed over the internet from my IP, while ensuring the RDS database can only be accessed through that specific EC2 instance


```EC2
Security Group
sec-for-ec2

RDS
Security Group (here we add mysql/oracle and instead of ip we give the ec2 security group)
sec-for-rds
```

```
EC2 Security Group
│
└── SSH : 22
    Source → Your Laptop IP

RDS Security Group
│
└── MySQL : 3306
    Source → EC2 Security Group
```

<h2>After doing all this</h2>

inside the ec2 run this commond
```
sudo dnf install mariadb105 -y
```
next get the endpoint of rds and put it in the terminal and enter password and you are inside the db

and if anything does click mind see the full architecture 