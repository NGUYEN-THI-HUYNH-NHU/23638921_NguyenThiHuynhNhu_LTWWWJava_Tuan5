package com.example.tuan7_23638291_nguyenthihuynhnhu.repo;

import com.example.tuan7_23638291_nguyenthihuynhnhu.model.Department;

import java.util.List;

public interface DepartmentRepo {
    List<Department> getAll();

    Department getById(int id);

    Department add(Department department);

    Department update(int id, Department department);

    boolean delete(int id);
}
