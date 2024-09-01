package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public User insertUser(User user){
        return repo.save(user);
    }

    public List<User> showAllUsers(){
        return repo.showAllUsers();
    }

    public Optional<User> showByUserId(Integer id){
        return repo.findById(id);
    }

    public User updateUser(User user){
        return repo.save(user);
    }

    public User deleteUser(Integer id){
        return repo.deleteUser(id);
    }

    public User findEmail(String email){
        return repo.findByEmail(email);
    }
}
