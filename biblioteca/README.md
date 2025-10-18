# Biblioteca (Spring Boot JDBC + Oracle XE)

**Group:** org.lemus  
**Artifact:** biblioteca

## Requisitos
- Java 17+
- Maven 3.9+
- Oracle Database 21c XE corriendo (service `XEPDB1` o `XE`)
- Usuario BD: `LIBSYS / Libsys_2025!`

## Ejecutar
```bash
mvn spring-boot:run
# o desde NetBeans: Run Project
```

## Configurar conexión
Edita `src/main/resources/application.properties` si tu servicio no es `XEPDB1`:
```
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XE
```

## Endpoints
- `POST /api/login`  body: `{ "username": "ana", "password": "ana123" }`
- `GET /api/libros?q=...`
- `POST /api/libros`
- `PUT /api/libros/{id}`
- `DELETE /api/libros/{id}`

## Notas
- SQL nativo con `JdbcTemplate` (sin ORM).
- Binds `?` para evitar inyección SQL.
- Requiere tablas `USUARIO`, `LIBRO`, `PRESTAMO` creadas en Oracle.
