package Healthy.Healthy.app.service;


import Healthy.Healthy.app.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
}

