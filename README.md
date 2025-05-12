# API Backend - Spring Boot + Docker

Esta es una aplicación backend construida con Spring Boot. Se proporciona un contenedor Docker para facilitar su ejecución en entornos locales.

## 🧰 Requisitos

- Docker instalado
- Git instalado (opcional)
- No necesitas tener Java instalado localmente gracias al contenedor

## 🚀 Despliegue local usando Docker

1. **Clona este repositorio:**

   ```bash
   git clone https://github.com/Andresafcf/api-franquicia.git
   
   ```

2. **Construye el JAR de la aplicación (si aún no está):**

   ```bash
   ./mvnw clean package -DskipTests
   ```

3. **Construye la imagen de Docker:**

   ```bash
   docker build -t mi-app-backend .
   ```

4. **Ejecuta el contenedor:**

   ```bash
   docker run -p 8080:8080 mi-app-backend
   ```

5. **Abre en el navegador:**

   ```text
   http://localhost:8080
   ```

   Esto redirigirá automáticamente a Swagger UI para explorar la documentación de la API:

   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## 📚 Swagger

Esta API utiliza **Springdoc OpenAPI** para documentar los endpoints. La documentación interactiva está disponible automáticamente en:

```
http://localhost:8080/swagger-ui/index.html
```

## 📦 Contenido del proyecto

- `Dockerfile` – Define la imagen base y cómo correr la app
- `target/api-0.0.1-SNAPSHOT.jar` – Archivo generado por Maven
- `src/` – Código fuente
- `README.md` – Este archivo :)

## 🛠 Construcción manual sin Docker (opcional)

Si tienes Java 17 instalado localmente:

```bash
java -jar target/api-0.0.1-SNAPSHOT.jar

💾 Exportar imagen Docker (opcional)

```bash
docker save -o mi-app-backend.tar mi-app-backend
```
Para cargarla en otra máquina:

```bash
docker load -i mi-app-backend.tar
```
