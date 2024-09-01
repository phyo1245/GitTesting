package com.example.demo.repository;

import com.example.demo.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.status<>false")
    public List<User> showAllUsers();

    @Modifying
    @Transactional
    @Query("update User u set u.status=true where u.id=?1")
    public User deleteUser(Integer id);

    public User findByEmail(String email);
}
