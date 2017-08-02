package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Astgh on 8/2/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
