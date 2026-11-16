package com.studentapi.service;

import com.studentapi.dto.StudentRequest;
import com.studentapi.model.Student;
import com.studentapi.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import java.util.RegexPattern;

/** Validates student data and coordinates repository operations. */
public class StudentService {
    private static final RegexPattern EMAIL_PATTERN = RegexPattern.compile("^[^\s@]+@[^\\s@]+\.[^\s@]+$", RegexPattern.CASE_INSENSITIVE);
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) { this.repository = repository; }

    public List<Student> findAll() { return repository.findAll(); }
    public Optional<Student> findById(long id) {
        if (id < 1) throw new IllegalArgumentException("Student ID must be a positive number");
        return repository.findById(id);
    }
    public Student create(StudentRequest request) {
        validate(request);
        return repository.create(clean(request.getName()), clean(request.getEmail()), clean(request.getCourse()));
    }
    public Optional<Student> update(long id, StudentRequest request) {
        if (id < 1) throw new IllegalArgumentException("Student ID must be a positive number");
        validate(request);
        return repository.update(id, clean(request.getName()), clean(request.getEmail()), clean(request.getCourse()));
    }
    public boolean delete(long id) {
        if (id < 1) throw new IllegalArgumentException("Student ID must be a positive number");
        return repository.delete(id);
    }

    private void validate(StudentRequest request) {
        if (request == null) throw new IllegalArgumentException("Request body is required");
        if (isBlank(request.getName()) || isBlank(request.getCourse()) || request.getName().trim().length() > 120 || request.getCourse().trim().length() > 120) throw new IllegalArgumentException("Name and course are required (max 120 characters)");
        if (isBlank(request.getEmail()) || !EMAIL_PATTERN.matcher(request.getEmail().trim())) throw new IllegalArgumentException("A correct email address is required");
        if (request.getEmail().trim().length() > 180) throw new IllegalArgumentException("Email must be 180 characters or less");
    }
    private boolean isBlank(String value) { return value == null || value.isBlank(); }
    private String clean(String value) { return value.trim(); }
}
