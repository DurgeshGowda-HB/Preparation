## AWS Lambda

AWS Lambda is a **Serverless Compute Service** that allows you to run code **without provisioning or managing servers**.

<h3>Why Do We Need Lambda?</h3>

Traditionally, to run an application, we need to:

- Launch a Server
- Install Software
- Maintain the Server
- Scale the Server

With Lambda, AWS manages the server infrastructure for you.

<h2>What is AWS Lambda?</h2>

> **Definition:** AWS Lambda is a serverless compute service that runs your code in response to events and automatically manages the underlying infrastructure.

Simply:

> **Lambda = Run code without managing servers.**

<h3>How Lambda Works</h3>

```text
Event
   │
   ▼
AWS Lambda
   │
Runs Code
   │
   ▼
Returns Response
```

<h2>Common Event Triggers</h2>

A Lambda function can be triggered by:

- Amazon S3
- Amazon API Gateway
- Amazon DynamoDB
- Amazon CloudWatch
- Amazon SNS

Example :

```text
Image Uploaded
      │
      ▼
Amazon S3
      │
      ▼
AWS Lambda
      │
Processes Image
```

<h3>Common Use Cases</h3>

- Backend APIs
- File Processing
- Image Resizing
- Sending Notifications
- Data Processing
- Automation Tasks

<h3>Benefits of Lambda</h3>

- No server management
- Automatic scaling
- Pay only when code runs
- High Availability
- Easy integration with AWS services

<h3>Lambda Pricing</h3>

AWS charges based on:

- Number of requests
- Execution time

> **No running server = No server cost.**

<h2>Key Takeaways</h2>

- Lambda is a **Serverless Compute** service.
- It runs code only when triggered by an event.
- AWS automatically manages servers and scaling.
- You pay only for the execution time and requests.
- Lambda integrates seamlessly with many AWS services.
