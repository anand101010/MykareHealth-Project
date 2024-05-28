package com.springtask.springtask.service;

import com.springtask.springtask.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
   User saveUser(User user);
  Optional<User>  getUser(String email, String password);
    List<User> getAllUser();
    void DeleteUser(String email);
}
