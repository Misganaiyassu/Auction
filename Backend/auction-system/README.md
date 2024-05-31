# auction-system

## Requirements

- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## How to run it?

- Clone the repository
- Update env variables

```bash
cp .env.example .env
```

- Install dependencies

```bash
docker compose run app mvn clean install
```

- Run app

```bash
docker compose up
```