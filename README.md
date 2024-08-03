# Spring Security Authenticated Server

## Acknowledgements

Credit to [unkownkoder on Youtube](https://www.youtube.com/@unknownkoder) for their tutorial on [_How to Create a Login System with Spring Data JPA and JWTs_](https://youtu.be/TeBt0Ike_Tk?si=ua8exzVlrdtlj9FD).

## Prequisites

- Maven
- Docker

## Summary

This is a Spring Security authentication server. The server enables users with the `admin` role to access both the user and admin endpoints, while for users the admin endpoint is locked down and only access to the user endpoint is permitted.

### Dependencies

- Spring Security
- OAuth 2.0 Resource Server
- Spring Web
- Spring Data JPA
- H2 Database
- Spring Boot DevTools
- Lombok

### Personal Touches

While following unknownkoder's tutorial, additional enhancements were made to the codebase:

- The Lombok dependency was installed to reduce the amount of overall boilerplate code that was written during the tutorial.
- The server is configured to run within a Docker container.
- All endpoints are documented via Swagger.

## Getting Started

```
docker compose build
docker compose up -d
```

To access the Swagger UI, visit the following endpoint: [localhost:8000/swagger-ui/index.html](http://localhost:8000/swagger-ui/index.html).
