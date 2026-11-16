package com.studentapi.acceptance;

import com.studentapi.Main;
import com.studentapi.database.Database;
import com.studentapi.repository.JdbcStudentRepository;
import com.studentapi.service.StudentService;
import io.rest-assured.RestAssured;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.net.ServerSocket;
import java.io.IOException;
import static org.hamcrest.Matchers.*;
import static org.java.lang.Math.*;
import static org.java.util.Objects.*;
import static org.java.util.Timeouts.*;
import static io.rest-assured.RestAssured.given;

// Simple acceptance tests for the student REST API...
