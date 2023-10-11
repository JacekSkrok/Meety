
# Docker Postgres Setup
### Create Docker container with Postgres database:

`docker create --name postgres-db -e POSTGRES_PASSWORD=xxxxxxxx -p 5432:5432 postgres:11.5-alpine`
### Start container:

`docker start postgres-db`

### Stop container:

`docker stop postgres-db`
### Connection Info:

JDBC URL: `jdbc:postgresql://localhost:5432/meety-app`

Username: `postgres`

Password: `xxxxxxxx`
### Note: This stores the data inside the container - when you delete the container, the data is deleted as well.

### Connect to PSQL prompt from docker:
`docker exec -it postgres-db psql -U postgres`

# Application Database Setup
### Create the Database:

`psql> create database meety-app;`
### Setup the Tables:

`docker cp create_tables.sql postgres-db:/create_tables.sql`

`docker exec -it postgres-db psql -d meety-app -f create_tables.sql -U postgres`
### Install the Data:

`docker cp insert_data.sql postgres-db:/insert_data.sql`

`docker exec -it postgres-db psql -d meety-app -f insert_data.sql -U postgres`

## (alternative way):
### Setup the Tables

`psql -d meety-app -f create_tables.sql`
### Install the Data:

`psql -d meety-app -f insert_data.sql`
