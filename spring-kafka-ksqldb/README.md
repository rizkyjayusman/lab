# ksqlDB Log Format Experiment: RAW vs JSON

## Overview

This project is an experimental setup to compare **ksqlDB query behavior
and performance** when processing log data in **Plain Text (RAW)**
format versus **JSON** format.\
The experiment uses a **Spring Boot Kafka Producer** that publishes logs
in two formats to different Kafka topics.

The main goal is to evaluate CPU cost, query complexity, robustness, and
long-term suitability for a **Log Lake** built on top of Kafka.

------------------------------------------------------------------------

## Docker Compose Configuration

This environment uses **Confluent Platform 7.5.0** with **Kafka KRaft
mode** (ZooKeeper-less).\
A fixed `CLUSTER_ID` is required for KRaft initialization.

### Key Characteristics

-   Kafka runs in **KRaft mode**
-   Single-node setup for experimentation
-   ksqlDB Server connected directly to Kafka
-   Schema Registry optional (recommended for JSON/Avro evolution)

### Example `docker-compose.yml`

``` yaml
services:
  broker:
    image: confluentinc/cp-kafka:7.5.0
    ports: ["9092:9092"]
    environment:
      KAFKA_NODE_ID: 1
      KAFKA_PROCESS_ROLES: 'broker,controller'
      KAFKA_CONTROLLER_QUORUM_VOTERS: '1@broker:29093'
      KAFKA_LISTENERS: 'PLAINTEXT://broker:29092,CONTROLLER://broker:29093,EXTERNAL://0.0.0.0:9092'
      KAFKA_ADVERTISED_LISTENERS: 'PLAINTEXT://broker:29092,EXTERNAL://localhost:9092'
      KAFKA_CONTROLLER_LISTENER_NAMES: 'CONTROLLER'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: 'CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT,EXTERNAL:PLAINTEXT'
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0
      CLUSTER_ID: 'MkU3OEVBNTcwNTJENDM2Qk'

  ksqldb-server:
    image: confluentinc/cp-ksqldb-server:7.5.0
    depends_on: [ broker ]
    ports: [ "8088:8088" ]
    environment:
      KSQL_BOOTSTRAP_SERVERS: "broker:29092"
      KSQL_LISTENERS: "http://0.0.0.0:8088"
      KSQL_KSQL_LOGGING_PROCESSING_STREAM_AUTO_CREATE: "true"
      KSQL_KSQL_LOGGING_PROCESSING_TOPIC_AUTO_CREATE: "true"
```

## ksqlDB Query Comparison

### 1. RAW / Plain Text Log Format

**Example Kafka value produced:**

    GET | /api/login | 200

#### Stream Definition

``` sql
CREATE STREAM raw_logs (
  data STRING
) WITH (
  KAFKA_TOPIC='log-raw',
  VALUE_FORMAT='KAFKA'
);
```

#### Query Example

``` sql
SELECT
  TRIM(SPLIT(data, '|')[0]) AS method,
  TRIM(SPLIT(data, '|')[1]) AS path,
  CAST(TRIM(SPLIT(data, '|')[2]) AS INT) AS status
FROM raw_logs
EMIT CHANGES;
```

#### Technical Drawbacks

-   **CPU Intensive**: `SPLIT()` and `TRIM()` executed per record per
    query.
-   **Repeated Parsing Logic**: Each consumer must re-implement parsing
    rules.
-   **Fragile Schema**:
    -   Missing delimiter breaks parsing.
    -   Field order changes silently corrupt data.
-   **No Schema Contract** between producer and consumer.
-   **Hard to Evolve**: Adding fields requires rewriting parsing logic.

➡ This format does not scale for high-throughput streaming analytics.

------------------------------------------------------------------------

### 2. JSON Log Format

**Example Kafka value produced:**

``` json
{
  "method": "GET",
  "path": "/api/login",
  "status": 200
}
```

#### Stream Definition

``` sql
CREATE STREAM json_logs (
  method STRING,
  path STRING,
  status INT
) WITH (
  KAFKA_TOPIC='log-json',
  VALUE_FORMAT='JSON'
);
```

#### Query Example

``` sql
SELECT
  method,
  path,
  status
FROM json_logs
WHERE status >= 500
EMIT CHANGES;
```

#### Technical Advantages

-   **Native Field Access** (no string parsing).
-   **Lower CPU Cost**: JSON deserialization happens once.
-   **Schema-Aware Contract** between producer and consumer.
-   **Readable SQL Queries**.
-   **Schema Evolution Friendly**.
-   **Tooling Compatible** with Kafka Connect & Schema Registry.

------------------------------------------------------------------------
