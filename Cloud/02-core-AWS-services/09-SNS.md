<img src="../images/core-AWS-services/SNS/sns.png" width="80%" height="400">

<img src="../images/core-AWS-services/SNS/benefits-of-SNS.png" width="80%" height="400">

<img src="../images/core-AWS-services/SNS/architect.png" width="80%" height="400">

<img src="../images/core-AWS-services/SNS/keep-in-mind.png" width="80%" height="400">

<img src="../images/core-AWS-services/SNS/topics-of-sns.png" width="80%" height="400">

<img src="../images/core-AWS-services/SNS/cost.png" width="80%" height="400">

<h3>SNS Standard vs FIFO</h3>

| Feature | Standard SNS | FIFO SNS |
|---------|--------------|----------|
| Ordering | Best effort | Ordered |
| Throughput | Very high | Lower than Standard |
| Duplicate Handling | Possible | Built-in deduplication |
| Use Case | Notifications | Ordered events |
| Example | Email / CloudWatch alerts | Financial / Order processing |

<h3>Easy Memory Trick</h3>

> **Standard = Speed + Scale**

> **FIFO = Order + Deduplication**
