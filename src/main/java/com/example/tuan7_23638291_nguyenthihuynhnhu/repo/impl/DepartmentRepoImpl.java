package com.example.tuan7_23638291_nguyenthihuynhnhu.repo.impl;

import com.example.tuan7_23638291_nguyenthihuynhnhu.model.Department;
import com.example.tuan7_23638291_nguyenthihuynhnhu.repo.DepartmentRepo;
import com.example.tuan7_23638291_nguyenthihuynhnhu.util.DBUtil;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DepartmentRepoImpl implements DepartmentRepo {

    @Override
    public List<Department> getAll() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Department dept = new Department();
                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                list.add(dept);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Department getById(int id) {
        Department dept = null;
        String sql = "SELECT * FROM departments WHERE id = ?";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dept = new Department();
                    dept.setId(rs.getInt("id"));
                    dept.setName(rs.getString("name"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dept;
    }

    @Override
    public Department add(Department department) {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, department.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    department.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return department;
    }

    @Override
    public Department update(int id, Department department) {
        String sql = "UPDATE departments SET name = ? WHERE id = ?";
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, department.getName());
            ps.setInt(2, id);
            ps.executeUpdate();
            department.setId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return department;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM departments WHERE id = ?";
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
