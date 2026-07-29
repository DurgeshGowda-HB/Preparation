## AWS Global Infrastructure

AWS Global Infrastructure is the worldwide network of **Regions, Availability Zones (AZs), and Edge Locations** that delivers AWS services securely, reliably, and with low latency.

<h3>Why Do We Need AWS Global Infrastructure?</h3>

AWS customers are located all over the world.

AWS uses Global Infrastructure to provide:

- High Availability
- Fault Tolerance
- Low Latency
- Better Performance

<img width="800" height="450" alt="image" src="AWS-global-Infrastructure" />


<h2>1. Region</h2>

> **Definition:** A Region is a separate geographic location where AWS operates multiple Availability Zones.

Examples:

- Mumbai (`ap-south-1`)
- Singapore (`ap-southeast-1`)
- US East (`us-east-1`)

A Region is completely independent of other Regions.

<h2>2. Availability Zone (AZ)</h2>

> **Definition:** An Availability Zone (AZ) is one or more physically separate data centers inside a Region.

Each AZ has:

- Independent Power Supply
- Cooling Systems
- Networking
- Physical Security

Example:

```text
Mumbai Region
│
├── AZ-A
├── AZ-B
└── AZ-C
```

If one AZ fails, applications running in another AZ continue to work.

<h2>3. Edge Location</h2>

> **Definition:** Edge Locations are AWS locations placed closer to users to deliver content with low latency.

Used by services like:

- Amazon CloudFront
- Route 53

Purpose:

- Faster content delivery
- Lower latency
- Better user experience

<h3>AWS Global Infrastructure</h3>

```text
                    AWS Global Infrastructure
                              │
          ┌───────────────────┼───────────────────┐
          │                   │                   │
       Regions         Availability Zones     Edge Locations
     (Geographic)      (Data Centers)       (Near Users)
```

<h3>Region vs Availability Zone vs Edge Location</h3>

| Region | Availability Zone | Edge Location |
|---------|-------------------|---------------|
| Geographic area | One or more isolated data centers | Location closer to users |
| Contains multiple AZs | Part of a Region | Outside Regions |
| Used to deploy applications | Provides High Availability | Provides Low Latency |

<h3>Remember</h3>

- **Region → Geographic Location**
- **Availability Zone → Data Centers inside a Region**
- **Edge Location → Faster content delivery near users**
