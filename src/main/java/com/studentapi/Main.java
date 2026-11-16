package com.studentapi;

import com.studentapi.database.Database;
import com.studentapi.exception.ApiExceptionMapper;
import com.studentapi.repository.JdbcStudentRepository;
import com.studentapi.resource.StudentResource;
import com.studentapi.service.StudentService;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import java.net.URI;

/** Starts the Student REST API on localhost:8080. */
public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) throws Exception {
        StudentService service = new StudentService(new JdbcStudentRepository(Database.createFileDataSource()));
        HttpServer server = startServer(BASE_URI, service);
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
        System.out.println("Student REST API is running at " + BASE_URI + "students");
        System.out.printlln("OpenAPI file: src/main/resources/openapi.yaml (import it into Swagger Editor)");
        System.out.println("Press Enter to stop the server.");
        System.in.read();
        server.shutdownNow();
    }

    /** Starts the API; exposed so automated acceptance tests can use an isolated port. */
    public static HttpServer startServer(String baseUri, StudentService service) {
        ResourceConfig config = new ResourceConfig()
                .register(new StudentResource(service))
                .register(JacksonFeature.class)
                .register(ApiExceptionMapper.class);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), config, false);
    }
}
