package com.example.demo.repository;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Astgh on 8/2/2017.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task,Long >{
    List<Task> findTasksByUser(User user);
}
