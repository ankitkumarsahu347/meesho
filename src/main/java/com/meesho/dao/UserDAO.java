package com.meesho.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer login(String email, String password) {
        return jdbcTemplate.query("SELECT id FROM users WHERE email=? AND password=?",
                rs -> rs.next() ? rs.getInt("id") : null, email, password);
    }

    public boolean register(String name, String email, String password) {
        try {
            return jdbcTemplate.update("INSERT INTO users(name,email,password) VALUES(?,?,?)", name, email, password) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
