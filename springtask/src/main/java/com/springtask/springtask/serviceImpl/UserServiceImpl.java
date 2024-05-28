package com.springtask.springtask.serviceImpl;

import com.springtask.springtask.model.User;
import com.springtask.springtask.repository.UserRepository;
import com.springtask.springtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public User saveUser(User user) {
       Optional<User> user1=userRepository.findByEmail(user.getEmail());
       if (user1.isPresent()){
           throw new IllegalArgumentException("user already exist");
       }
       try {
           return userRepository.save(user);
       }
       catch (IllegalArgumentException e){
           throw new IllegalArgumentException("email already exists");
       }
    }

    @Override
    public Optional <User> getUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void DeleteUser(String email) {
 Optional<User>optionalUser=userRepository.findByEmail(email);
 if(optionalUser.isPresent()){
     userRepository.deleteByEmail(email);
 }else
     throw new RuntimeException("No user found ");
    }
}
