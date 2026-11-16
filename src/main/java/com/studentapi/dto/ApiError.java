package com.studentapi.dto;

/** Consistent JSON error response. */
public class ApiError {
    private String error;
    public ApiError() { }
    public ApiError(String error) { this.error = error; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}
