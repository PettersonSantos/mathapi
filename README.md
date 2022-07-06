# mathsApi

## Introduction
    This project is a simple API that simulates a calculator, has five endpoints
    -/min
    -/max
    -/avg
    -/median
    -/percentile

## Technologies

- Java 17 using springboot version 2.7.0
- Docker and Docker-compose

## Setup

### Dependencies

```bash
$ mvn clean install
```

### Docker Stack

```bash
$ docker-compose up -d
```

### Run tests

```bash
$ mvn test
```

### Internal structure

```bash
controller - REST controller ans basic validation
service - Business layer
```

# Final considerations
- The service is running on ports 8080.
- The Swagger is running on /swagger-ui

