package com.example.tuan7_23638291_nguyenthihuynhnhu.repo;

import com.example.tuan7_23638291_nguyenthihuynhnhu.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    List<Employee> getAll();

    Employee getById(int id);

    Employee add(Employee employee);

    Employee update(int id, Employee employee);

    boolean delete(int id);
}
