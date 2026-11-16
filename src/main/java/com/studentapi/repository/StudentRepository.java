package com.studentapi.repository;

import com.studentapi.model.Student;
import java.util.List;
import java.util.Optional;

/** Persistence contract, keeping database details out of the service layer. */
public interface StudentRepository {
    List<Student> findAll();
    Optional<Student> findById(long id);
    Student create(String name, String email, String course);
    Optional<Student> update(long id, String name, String email, String course);
    boolean delete(long id);
}
