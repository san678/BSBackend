package com.afexam.fullstackbackend.controller;

import com.afexam.fullstackbackend.exception.UserNotFoundException;
import com.afexam.fullstackbackend.model.User;
import com.afexam.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;


//create connection with backend and frontend
@CrossOrigin("http://localhost:3000/")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //add user
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    //view all users
    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //get user by id
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    //edit user
    @PutMapping("/user/{id} ")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() ->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "user with id"+ id +"has been deleted success";
    }
}
