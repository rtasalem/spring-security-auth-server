# Spring Security Authenticated Server

## Acknowledgements

Credit to [unkownkoder on Youtube](https://www.youtube.com/@unknownkoder) for their tutorial on [How to Create a Login System with Spring Data JPA and JWTs](https://youtu.be/TeBt0Ike_Tk?si=ua8exzVlrdtlj9FD).

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

While following unknownkoder's tutorial, the Lombok dependency was installed to reduce the amount of overall boilerplate code that was written in the tutorial itself. This project is also configured to run within a Docker container.

## Getting Started

```
docker compose build
docker compose up -d
```
