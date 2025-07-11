# Docker + Postgres + Spring Boot

```mermaid
flowchart LR

    subgraph Docker
        direction TB

        postgres[Postgres]
        spring-boot[Spring Boot]

        spring-boot <--> postgres
    end

    consumer[Consumer] <--> spring-boot
```

## Run the stack

```
docker compose up -d --build
```

## Run the API in development mode

```
cd api
mvn clean package -DskipTests
docker compose up -d postgres
mvn spring-boot:run
```
