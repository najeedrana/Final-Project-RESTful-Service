package com.studentapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.studentapi.model.Student;
import java.util.LinkedHashMap;
import java.util.Map;

/** Student representation returned by the API, including HATEOAS links. */
public class StudentResponse {
    private long id;
    private String name;
    private String email;
    private String course;
    @JsonProperty("_links")
    private Map<String, ApiLink> links = new LinkedHashMap<>();

    public StudentResponse() { }

    public StudentResponse(Student student, String itemUrl) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.course = student.getCourse();
        links.put("self", new ApiLink(itemUrl, "GET"));
        links.put("update", new ApiLink(itemUrl, "PUT"));
        links.put("delete", new ApiLink(itemUrl, "DELETE"));
    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public Map<String, ApiLink> getLinks() { return links; }
    public void setLinks(Map<String, ApiLink> links) { this.links = links; }
}
