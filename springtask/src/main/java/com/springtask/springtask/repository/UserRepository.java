package com.springtask.springtask.repository;

import com.springtask.springtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndPassword(String email,String password);
Optional<User> findByEmail(String email);

Optional<User> deleteByEmail(String email);



}
