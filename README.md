# Mini Web Framework en Java

Framework HTTP simple en Java para:

- Definir servicios REST `GET` con lambdas.
- Extraer query parameters con `HttpRequest`.
- Servir archivos estáticos desde `target/classes`.

## Arquitectura

- `HttpServer`: recibe conexiones, parsea la petición, enruta endpoints dinámicos y fallback a archivos estáticos.
- `HttpRequest`: encapsula la URI y los query params (`getValues`).
- `StaticFileHandler`: configura y resuelve la carpeta de estáticos.
- `WebMethod`: interfaz funcional para handlers `GET`.
- `WebAppExample`: aplicación de ejemplo construida sobre el framework.

## Características implementadas

1. `HttpServer.get(path, (req, res) -> ...)`
2. `req.getValues("name")` para query params
3. `HttpServer.staticfiles("webroot/public")` (también soporta `"/webroot/public"`)
4. Servidor en `http://localhost:8080`
5. Entrega de archivos estáticos cuando no hay endpoint dinámico

## Aplicación de ejemplo

Archivo principal:

- `src/main/java/com/adojos/app/examples/WebAppExample.java`

Este ejemplo publica:

- `GET /App/hello?name=Daniel`
- `GET /App/pi`
- `GET /App/euler`
- `GET /index.html` (estático)

Archivo estático fuente:

- `src/main/resources/webroot/public/index.html`

Después de compilar, Maven lo copia en:

- `target/classes/webroot/public/index.html`

## Ejecución

### Requisitos

- Java 21
- Maven 3+

### Compilar

```bash
mvn clean compile
```

### Ejecutar ejemplo

```bash
java -cp target/classes com.adojos.app.examples.WebAppExample
```

### Probar en navegador

- `http://localhost:8080/App/hello?name=Daniel`
- `http://localhost:8080/App/pi`
- `http://localhost:8080/App/euler`
- `http://localhost:8080/index.html`

## Pruebas

Pruebas unitarias incluidas:

- `HttpRequestTest`
  - Extracción correcta de query params.
  - Parámetros inexistentes retornan `null`.
- `StaticFileHandlerTest`
  - Resolución de archivos con y sin `/` inicial en `staticfiles`.
  - Retorno `null` cuando el archivo no existe.

Ejecutar pruebas:

```bash
mvn test
```

## Estructura relevante

- `src/main/java/com/adojos/app/HttpServer.java`
- `src/main/java/com/adojos/app/HttpRequest.java`
- `src/main/java/com/adojos/app/StaticFileHandler.java`
- `src/main/java/com/adojos/app/WebMethod.java`
- `src/main/java/com/adojos/app/examples/WebAppExample.java`
- `src/main/resources/webroot/public/index.html`
- `src/test/java/com/adojos/app/HttpRequestTest.java`
- `src/test/java/com/adojos/app/StaticFileHandlerTest.java`
