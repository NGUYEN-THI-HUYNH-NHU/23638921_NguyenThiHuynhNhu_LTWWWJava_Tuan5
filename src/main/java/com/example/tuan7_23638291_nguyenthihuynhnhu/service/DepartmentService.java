package com.example.tuan7_23638291_nguyenthihuynhnhu.service;

import com.example.tuan7_23638291_nguyenthihuynhnhu.dto.request.DepartmentRequest;
import com.example.tuan7_23638291_nguyenthihuynhnhu.dto.response.DepartmentResponse;
import com.example.tuan7_23638291_nguyenthihuynhnhu.model.Department;
import com.example.tuan7_23638291_nguyenthihuynhnhu.repo.DepartmentRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DepartmentService {
    @Inject
    private DepartmentRepo departmentRepo;

    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepo.getAll()
                .stream()
                .map(d -> new DepartmentResponse(d.getId(), d.getName()))
                .collect(Collectors.toList());
    }

    public DepartmentResponse getDepartmentById(int id) {
        Department d = departmentRepo.getById(id);
        return new DepartmentResponse(d.getId(), d.getName());
    }

    public DepartmentResponse addDepartment(DepartmentRequest request) {
        Department dept = new Department();
        dept.setName(request.getName());
        Department res = departmentRepo.add(dept);
        if (res != null)
            return new DepartmentResponse(res.getId(), dept.getName());
        return null;
    }

    public DepartmentResponse updateDepartment(int id, Department department) {
        Department d = departmentRepo.update(id, department);
        return new DepartmentResponse(d.getId(), d.getName());
    }

    public boolean deleteDepartment(int id) {
        return departmentRepo.delete(id);
    }
}
