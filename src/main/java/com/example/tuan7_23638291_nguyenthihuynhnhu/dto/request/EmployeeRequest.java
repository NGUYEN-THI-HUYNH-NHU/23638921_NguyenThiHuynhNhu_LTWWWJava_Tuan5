package com.example.tuan7_23638291_nguyenthihuynhnhu.dto.request;

import java.io.Serializable;

public class EmployeeRequest implements Serializable {
    private String name;
    private String role;
    private Double salary;
    private Integer departmentId;
    private Integer positionId;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, String role, Double salary, Integer departmentId, Integer positionId) {
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.departmentId = departmentId;
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
