package com.example.tuan7_23638291_nguyenthihuynhnhu.dto.response;

import java.io.Serializable;

public class DepartmentResponse implements Serializable {
    private int id;
    private String name;

    public DepartmentResponse() {
    }

    public DepartmentResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
