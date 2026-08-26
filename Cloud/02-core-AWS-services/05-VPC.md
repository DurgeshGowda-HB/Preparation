## Amazon Virtual Private Cloud (Amazon VPC)

Amazon VPC (Virtual Private Cloud) is a service that allows you to create a **private and isolated virtual network** within AWS to securely launch and manage AWS resources.

<h3>Why Do We Need VPC?</h3>

When deploying applications in AWS, we need:

- Network Isolation
- Secure Communication 
- Protection from Unauthorized Users

VPC provides a secure environment for AWS resources.

<h2>What is Amazon VPC?</h2>

> **Definition:** Amazon VPC is a service that enables you to create a logically isolated virtual network in the AWS Cloud.

Simply:

> **VPC = Your own private network inside AWS.**

<h3>How VPC Works</h3>

```text
                  Amazon VPC
         ┌─────────────────────────┐
         │                         │
         │   Public Subnet         │
Internet │      EC2                │
────────►│                         │
         │   Private Subnet        │
         │      RDS                │
         │                         │
         └─────────────────────────┘
```

<h2>Key Components</h2>

### VPC

A private virtual network that contains AWS resources.

### Public Subnet

> A subnet that allows resources to communicate with the internet.

Common Resources:

- EC2 Web Server
- Load Balancer
- NAT Gateway

### Private Subnet

> A subnet that does **not** allow direct internet access.

Common Resources:

- Amazon RDS
- Internal Servers
- Databases

### Internet Gateway (IGW)

> Allows communication between a VPC and the Internet.

### Route Table

> Defines how network traffic is routed within the VPC.

### Security Group

> Acts as a **virtual firewall** for AWS resources.

Controls:

- Inbound Traffic
- Outbound Traffic

<h3>Common Use Cases</h3>

- Secure Web Applications
- Multi-tier Architectures
- Hosting Databases
- Enterprise Networks
- Private APIs

<h3>Benefits of Amazon VPC</h3>

- Network Isolation
- Enhanced Security
- Flexible Networking
- High Availability
- Secure Resource Communication

<img src="../images/core-AWS-services/VPC/VPC-ex.png" width="80%" height="400">
<img src="../images/core-AWS-services/VPC/keep-in-mind-vpc.png" width="80%" height="400">



<h2>Key Takeaways</h2>

- Amazon VPC provides a **private network** inside AWS.
- A VPC contains one or more **Subnets**.
- **Public Subnets** are used for internet-facing resources.
- **Private Subnets** are used for secure internal resources.
- **Internet Gateway** enables internet connectivity.
- **Route Tables** control network traffic.
- **Security Groups** protect AWS resources by acting as virtual firewalls.

## Amazon VPC

> **VPC = Your private network inside AWS.**

Think:

```text
AWS
└── VPC
    ├── Public Subnets
    │    └── EC2
    │
    └── Private Subnets
         └── Database / Backend
```

---

## Important VPC Terms

| Term                  | Remember as                       |
| --------------------- | --------------------------------- |
| **VPC**               | AWS network                       |
| **CIDR**              | IP range                          |
| **Subnet**            | Smaller network                   |
| **Route Table**       | Where traffic goes                |
| **Internet Gateway**  | VPC ↔ Internet                    |
| **NAT Gateway**       | Private subnet → Internet         |
| **Security Group**    | EC2 firewall                      |
| **Availability Zone** | Physical location inside a Region |

## Creating VPC

We created:

```text
Name: demo-vpc
CIDR: 10.0.0.0/16
IPv6: None
Tenancy: Default
```

We selected:

```text
VPC and more
```

AWS automatically created:

```text
VPC
├── 2 Public Subnets
├── 2 Private Subnets
├── Route Tables
├── Internet Gateway
└── S3 VPC Endpoint
```

We used:

```text
Availability Zones → 2
NAT Gateway → None
```

> **NAT Gateway was not created to avoid unnecessary charges.**

## CIDR

> **CIDR = IP address range available in the VPC/subnet.**

Our VPC:

```text
10.0.0.0/16
```

Example subnet ranges:

```text
VPC: 10.0.0.0/16
│
├── Public:  10.0.0.0/21
└── Private: 10.0.64.0/21
```

## Subnet

> **Subnet = smaller network inside a VPC.**

Our VPC:

```text
demo-vpc
│
├── Public Subnet 1
├── Public Subnet 2
├── Private Subnet 1
└── Private Subnet 2
```

Each subnet belongs to an **Availability Zone**.

Example:

```text
ap-south-2a
├── Public Subnet
└── Private Subnet

ap-south-2b
├── Public Subnet
└── Private Subnet
```

## Public Subnet

> **Public Subnet = Subnet whose route table has a route to an Internet Gateway.**

Flow:

```text
Internet
   ↓
Internet Gateway
   ↓
Public Route Table
   ↓
Public Subnet
   ↓
EC2
```

For our EC2 we also enabled:

```text
Auto-assign Public IP → Enabled
```

## Private Subnet

> **Private Subnet = Subnet with no direct route to an Internet Gateway.**

Example:

```text
Private Subnet
      ↓
Backend
      ↓
Database
```

Commonly used for:

* Databases
* Internal backend services
* Internal applications


## Public vs Private Subnet

> **The name of the subnet does NOT make it public. The route table determines it.**

### Public

```text
Subnet
 ↓
Route Table
 ↓
0.0.0.0/0 → Internet Gateway
 ↓
Public Subnet
```

### Private

```text
Subnet
 ↓
Route Table
 ↓
No direct Internet Gateway route
 ↓
Private Subnet
```

## Route Table

> **Route Table = tells AWS where network traffic should go.**

Our public route table:

```text
Destination       Target

10.0.0.0/16       local
0.0.0.0/0         Internet Gateway
```

### Remember

```text
10.0.0.0/16 → local
        ↓
Traffic inside VPC

0.0.0.0/0 → Internet Gateway
        ↓
Traffic outside VPC
```

## Internet Gateway

> **Internet Gateway = connection between VPC and Internet.**

Flow:

```text
EC2
 ↓
Public Subnet
 ↓
Route Table
 ↓
Internet Gateway
 ↓
Internet
```

The Internet Gateway is attached to the VPC.

## NAT Gateway

> **NAT Gateway allows private-subnet resources to access the internet without allowing direct inbound internet access.**

Flow:

```text
Private EC2
    ↓
NAT Gateway
    ↓
Internet Gateway
    ↓
Internet
```

Remember:

```text
Private EC2 → Internet ✅
Internet → Private EC2 ❌
```

> **NAT Gateway can cost money, so we didn't create one during practice.**



## Security Group

> **Security Group = virtual firewall for EC2.**

Security Groups are associated with resources such as EC2 instances and belong to a VPC.

## EC2 Inside Our VPC

Our EC2 setup:

```text
VPC
→ demo-vpc

Subnet
→ demo-subnet-public1-ap-south-2a

Public IP
→ Enabled

Security Group
→ demo-vpc-ec2-sg
```

Then connected using:

```bash
ssh -i "amaterasu.pem" ec2-user@YOUR-PUBLIC-DNS
```

## Important Mistake We Learned

We accidentally launched EC2 into:

```text
Private Subnet
```

Even though the EC2 had a public IP, SSH **timed out**.

Why?

```text
EC2
 ↓
Private Subnet
 ↓
Private Route Table
 ↓
No direct Internet Gateway route
 ↓
❌ SSH timeout
```

### Lesson

> **Public IP alone does NOT make an EC2 publicly reachable.**

For typical public EC2 access:

```text
Public IP
    +
Public Subnet
    +
Route Table → Internet Gateway
    +
Security Group allowing SSH
```

---

## Complete VPC Flow

```text
                         INTERNET
                            │
                            ▼
                    Internet Gateway
                            │
                            ▼
                    Public Route Table
                            │
              ┌─────────────┴─────────────┐
              ▼                           ▼
       Public Subnet 1             Public Subnet 2
              │                           │
              ▼                           ▼
             EC2                         EC2


                    VPC: 10.0.0.0/16
                            │
              ┌─────────────┴─────────────┐
              ▼                           ▼
       Private Subnet 1             Private Subnet 2
              │                           │
              ▼                           ▼
           Backend                    Database
              │
              ▼
         NAT Gateway
              │
              ▼
       Internet Gateway
              │
              ▼
           Internet
```


## Easy Memory Trick

> **VPC = AWS Network**

> **CIDR = IP Range**

> **Subnet = Smaller Network**

> **Route Table = Where Traffic Goes**

> **Internet Gateway = VPC ↔ Internet**

> **NAT Gateway = Private → Internet**

> **Security Group = Firewall**

> **Public Subnet = Route to IGW**

> **Private Subnet = No direct route to IGW**

###  Most Important

```text
Public Subnet
    ↓
Route Table
    ↓
Internet Gateway
    ↓
Internet
```

```text
Private Subnet
    ↓
NAT Gateway
    ↓
Internet
```
