package com.springtask.springtask.controller;

import com.springtask.springtask.model.User;
import com.springtask.springtask.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/api")
@ApiOperation("userController")
public class UserController {
    @Autowired
     UserService userService;
    @ApiOperation("register user")

    @PostMapping("/register")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        try {
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @ApiOperation("get user by email and password")
    @GetMapping("/getuser")
    public Optional<User> getUserByEmailAndPassword(@RequestParam String email,
                                                    @RequestParam String password){
        try{
           return userService.getUser(email,password);
        }catch (Exception e){
            throw new RuntimeException("no user found");
        }

}
@ApiOperation("get all users")
@GetMapping("/getalluser")
    public List<User>getAllUser(){
        return userService.getAllUser();
}

@ApiOperation("delete users by email")
        @DeleteMapping("/delete")
    public ResponseEntity<User>deleteUser(@RequestParam String email){
            try {
                userService.DeleteUser(email);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            catch (Exception e){
                throw new RuntimeException("User not found");
    }
}

}
