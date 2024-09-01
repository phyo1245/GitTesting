package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/saveUser")
    public User save(@RequestBody User user){
        return service.insertUser(user);
    }

    @GetMapping("/showUsers")
    public List<User> showAllUsers(){
        return service.showAllUsers();
    }

    @GetMapping("/showById/{id}")
    public Optional<User> showById(@PathVariable("id")String id){
        return service.showByUserId(Integer.parseInt(id));
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @PutMapping("/deleteUser/{id}")
    public User delete(@PathVariable("id")String id){
        Optional<User> user = service.showByUserId(Integer.parseInt(id));
        User obj = null;
        if(user.isPresent()){
            obj = user.get();
            obj.setStatus(true);
        }
        return service.updateUser(obj);
    }

    @PutMapping("/delete/{id}")
    public User deletetest2(@PathVariable("id")String id){
        return service.deleteUser(Integer.parseInt(id));
    }

    @GetMapping("/findByEmail/{email}")
    public User findEmail(@PathVariable("email")String email){
        return service.findEmail(email);
    }
}
