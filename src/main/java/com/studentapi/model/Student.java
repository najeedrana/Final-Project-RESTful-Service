package com.studentapi.model;

/** Represents one student stored by the REST API. */
public class Student {
    private long id;
    private String name;
    private String email;
    private String course;
    private long createdAt;
    private long updatedAt;

    /** Required by JSON binding and JDBC mapping. */
    public Student() { }

    /** Creates a student record. */
    public Student(long id, String name, String email, String course, long createdAt, long updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }
    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }
}
