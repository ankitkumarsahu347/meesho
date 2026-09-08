package com.meesho.service;

import com.meesho.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) { this.userDAO = userDAO; }

    public Integer login(String email, String password) { return userDAO.login(email, password); }
    public boolean register(String name, String email, String password) { return userDAO.register(name, email, password); }
}
