# Kafka Basics Demo

A compact Java learning project focused on the fundamentals of Apache Kafka and event-driven data flow.

## What this repository demonstrates
- Kafka producers and consumers in Java
- event streaming concepts
- integrating streaming data with OpenSearch
- working with external event sources
- local development with Docker Compose

## Project structure
- `kafka-basics/` — basic Kafka client examples
- `kafka-producer-wikimedia/` — publishes Wikimedia event stream data into Kafka
- `kafka-consumer-opensearch/` — consumes Kafka events and indexes them into OpenSearch

## Tech stack
- Java 17
- Apache Kafka client
- OpenSearch
- Docker Compose
- OkHttp / EventSource
- Gson

## Why it matters
This project was part of my hands-on learning in distributed systems and messaging patterns. It helped build practical understanding of producer/consumer behavior, stream ingestion, and how event pipelines can feed search and analytics platforms.

## Running locally
### Start OpenSearch
```bash
cd kafka-consumer-opensearch
docker compose up -d
```

### Build a module
```bash
mvn clean package
```

Run the modules from your IDE or with Maven depending on the class entry points available in each module.

## Notes
This is a learning-oriented project rather than a production-ready platform, but it reflects practical work with Kafka-based workflows and event-driven thinking.
