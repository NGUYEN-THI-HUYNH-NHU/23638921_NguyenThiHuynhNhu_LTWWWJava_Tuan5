package com.example.tuan7_23638291_nguyenthihuynhnhu.service;

import com.example.tuan7_23638291_nguyenthihuynhnhu.model.Employee;
import com.example.tuan7_23638291_nguyenthihuynhnhu.repo.EmployeeRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EmployeeService {
    @Inject
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return employeeRepo.getAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepo.getById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.add(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {
        return employeeRepo.update(id, employee);
    }

    public boolean deleteEmployee(int id) {
        return employeeRepo.delete(id);
    }
}
