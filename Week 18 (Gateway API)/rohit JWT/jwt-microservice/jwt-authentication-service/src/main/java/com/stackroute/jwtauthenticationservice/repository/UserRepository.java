package com.stackroute.jwtauthenticationservice.repository;

import com.stackroute.jwtauthenticationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findByIdAndPassword(String id,String password);
}
