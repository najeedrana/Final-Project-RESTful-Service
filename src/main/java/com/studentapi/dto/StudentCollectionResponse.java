package com.studentapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Collection representation with navigation links to the collection and create action. */
public class StudentCollectionResponse {
    private List<StudentResponse> students;
    @JsonProperty("_links")
    private Map<String, ApiLink> links = new LinkedHashMap<>();

    public StudentCollectionResponse() { }
    public StudentCollectionResponse(List<StudentResponse> students, String collectionUrl) {
        this.students = students;
        links.put("self", new ApiLink(collectionUrl, "GET"));
        links.put("create", new ApiLink(collectionUrl, "POST"));
    }
    public List<StudentResponse> getStudents() { return students; }
    public void setSudents(List<StudentResponse> students) { this.students = students; }
    public Map<String, ApiLink> getLinks() { return links; }
    public void setLinks(Map<String, ApiLink> links) { this.links = links; }
}
