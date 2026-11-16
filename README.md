# Web Services Final Project — Student REST API

A deliberately small Java RESTful web service for managing student records. It uses JAX-RS (Jersey), an H2 relational database, JSON, HTTP caching headers, ETags, and hypermedia links.

## 1. Technology

- Java 17
- Maven
- JAX-RS 3 / Jersey with Grizzly HTTP server
- H2 database (file-backed for normal use)
- JSON request and response bodies
- JUnit 5 and REST Assured tests
- OpenAPI 3.0 document for Swagger Editor

## 2. Run it

1. Open this folder in IntelliJ IDEA as a Maven project.
2. Select a JDK 17 or newer as the project SDK.
3. Allow Maven to download dependencies.
4. Run `com.studentapi.Main`.
5. The API runs at `http://localhost:8080/api/students`.

The H2 database file is created automatically in the `data/` folder. Student records persist between restarts.

## 3. Endpoints

| Method | URL | Purpose | Successful response |
|---|---|---|---|
| GET | `/api/students` | List students | 200 |
| GET | `/api/students/{id}` | Get one student | 200 |
| POST | `/api/students` | Create student | 201 |
| PUT | `/api/students/{id}` | Replace student | 200 |
| DELETE | `/api/students/{id}` | Delete student | 204 |

Example JSON for POST and PUT:

```json
{
  "name": "Jamie Lee",
  "email": "jamie@example.com",
  "course": "Web Services"
}
```

## 4. Swagger Editor

1. Open `https://editor.swagger.io/`.
2. Choose File → Import File and select `src/main/resources/openapi.yaml`.
3. Inspect the documented endpoints and schemas. The OpenAPI file describes the local API server at `http://localhost:8080/api`.
4. Keep screenshots of the imported specification and any request/response demonstrations required by the lecturer.

## 5. Postman

With the Java server running, create requests against `http://localhost:8080/api/students`:

- GET the collection.
- POST a student using Body → raw → JSON.
- GET the returned student's ID.
- PUT that ID with an updated JSON body.
- DELETE that ID.

For requests with JSON bodies, set `Content-Type: application/json`.

## 6. REST design notes

- **Resource-based URLs:** students are addressed by collection and item URLs.
- **Statelessness:** every request contains the information needed to process it; the server does not store client session state.
- **Cacheability:** GET responses include `Cache-Control: public, max-age=30`; individual student responses also include an ETag and support `If-None-Match` (304 Not Modified).
- **Hypermedia:** student representations contain `_links` for self, update and delete; the collection includes self and create links. This implements the hypermedia constraint referred to in the assignment's Richardson Maturity Model requirement (the brief labels it “level 4”).
- **Database:** H2 stores records in a relational table; SQL parameters are used for database operations.

## 7. Tests and JavaDoc

Run all tests from IntelliJ's Maven panel → Lifecycle → `test`, or run:

```bash
mvn test
```

The tests include:
- repository unit tests for create/read/update/delete and duplicate email handling;
- service unit tests for validation and input cleanup;
- REST Assured acceptance tests that start the HTTP API and send real GET, POST, PUT and DELETE requests, including cache/ETag and error checks.

Generate JavaDoc with:

```bash
mvn javadoc:javadoc
```

Output: `target/site/apidocs/`.

## 8. Simple responsibility split

For an individual submission, the responsibilities are separated in code: the resource handles HTTP, the service validates business rules, the repository handles persistence, and the tests act as QA. In a team submission, these can be assigned to separate members and tracked in Trello as requested in the brief.

## 9. Scope

This is a basic coursework implementation, not a production system. It intentionally omits authentication, roles, pagination, Docker, deployment and a front-end. Run the API locally and collect your own Postman/Swagger screenshots; the project does not claim those external demonstrations have already been performed.
