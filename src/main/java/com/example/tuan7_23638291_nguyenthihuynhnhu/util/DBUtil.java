package com.example.tuan7_23638291_nguyenthihuynhnhu.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static DataSource dataSource;

    static {
        try {
            Context env = (Context) new InitialContext().lookup("java:comp/env");
            dataSource = (DataSource) env.lookup("jdbc/employee_db");
        } catch (NamingException e) {
            throw new RuntimeException("Không tìm thấy DataSource jdbc/employee_db trong JNDI", e);
        }
    }

    /**
     * Lấy Connection từ DataSource pool của Tomcat
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi kết nối cơ sở dữ liệu qua DataSource", e);
        }
    }
}