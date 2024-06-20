# OmSaaS
Inventory management for medium scale enterprises.

- Backend Spring-boot based application capable of adding users, adding stores (warehouses and point of sale stores), placing orders and keeping track of inventory of the stores.
- Uses JPA(Hibernate) for persistence along with postgresql as DB
- SDK : OpenJDK version : 22

## Getting started

You can either run the application locally or through a pre-setup docker-compose file.
Local run requires postgtres DB to be setup locally and the initial sql setup script to be run.
Docker version launches a postgres DB container to connect to automatically

### Via Docker 

To run an instance via docker, go to the root folder of the project and execute the following command

```
docker-compose up --build
```

