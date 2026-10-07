package com.example.tuan7_23638291_nguyenthihuynhnhu.repo.impl;

import com.example.tuan7_23638291_nguyenthihuynhnhu.model.Employee;
import com.example.tuan7_23638291_nguyenthihuynhnhu.repo.EmployeeRepo;
import com.example.tuan7_23638291_nguyenthihuynhnhu.util.DBUtil;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmployeeRepoImpl implements EmployeeRepo {

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        // Sử dụng DBUtil.getConnection() trực tiếp
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("ID"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDepartmentId(rs.getInt("department_id"));
                emp.setPositionId(rs.getInt("position_id"));
                list.add(emp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Employee getById(int id) {
        Employee emp = null;
        String sql = "SELECT * FROM employees WHERE ID = ?";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee();
                    emp.setId(rs.getInt("ID"));
                    emp.setName(rs.getString("name"));
                    emp.setRole(rs.getString("role"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setDepartmentId(rs.getInt("department_id"));
                    emp.setPositionId(rs.getInt("position_id"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return emp;
    }

    @Override
    public Employee add(Employee employee) {
        String sql = "INSERT INTO employees (name, role, salary, department_id, position_id) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getRole());
            ps.setObject(3, employee.getSalary());
            ps.setObject(4, employee.getDepartmentId());
            ps.setObject(5, employee.getPositionId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    employee.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public Employee update(int id, Employee employee) {
        String sql = "UPDATE employees SET name = ?, role = ?, salary = ?, department_id = ?, position_id = ? WHERE ID = ?";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getRole());
            ps.setObject(3, employee.getSalary());
            ps.setObject(4, employee.getDepartmentId());
            ps.setObject(5, employee.getPositionId());
            ps.setInt(6, id);
            ps.executeUpdate();
            employee.setId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}