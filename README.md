# Test Java Inditex Price 
(José Manuel López González)

Aplicacion Sprint Boot acorde a los requisitos de la prueba técnica basada en un servicio REST API.

## Indice
- [Tecnologías usadas](#tecnologias-usadas)
- [Instalación](#instalación)
- [Documentacion API](#Documentacion-api)

## Tecnologías usadas
- **Java 21**
- **Spring Boot** para el desarrollo de la aplicación.
- **Spring Data JPA** interaccion con la base de datos.
- **H2 In-memory Database**
- **MapStruct** Para el mapeo entre las diferentes capas de la aplicación.
- **Lombok**
- **Swagger/OpenAPI** documentación Api.

## Instalación

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your_username/price-query-service.git.
    cd price-query-service.
    ```

2. **Configuración para arrancar la aplicación**:

    - Hay que tener una version 21 de Java.
    - Usar el comando 'mvn clean install' de maven.
    - Lanzar 'mvn spring-boot:run' para arrancar la aplicación.

3. **Acceso a la docuemntación API**
   - Abre tu navegador con la aplicacion arrancanda y poner esta url `http://localhost:8080/swagger-doc.html`.

## Documentation API

### Price

**Endpoint**: `/api/price`

**Method**: `GET`

**Parameters**:
- `applicationDate` (required): La fecha del price que es aplicada (en formato `ISO_LOCAL_DATE_TIME`).
- `productId` (required): Id del producto.
- `brandId` (required): Id de la branch.

Ejemplo:
```bash
curl -X GET "http://localhost:8080/api/price?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1"
```