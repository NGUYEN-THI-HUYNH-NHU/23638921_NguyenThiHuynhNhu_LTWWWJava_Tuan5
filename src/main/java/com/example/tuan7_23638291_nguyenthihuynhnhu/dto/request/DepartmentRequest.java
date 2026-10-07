package com.example.tuan7_23638291_nguyenthihuynhnhu.dto.request;

import java.io.Serializable;

public class DepartmentRequest implements Serializable {
    private String name;

    public DepartmentRequest() {
    }

    public DepartmentRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
