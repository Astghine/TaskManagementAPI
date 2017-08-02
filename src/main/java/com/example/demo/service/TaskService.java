package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Astgh on 8/2/2017.
 */

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public void save(Task task){taskRepository.save(task);    }

    public Task getById(long id){return taskRepository.findOne(id);}
    public List< Task> getAllTasks(){return taskRepository.findAll();  }
    public void deleteById(long id){taskRepository.delete(id);}
    public void updateTask(long id, Task task){

        taskRepository.save(task);
    }

    public List<Task> getAllTasksByUser(User user){

        return taskRepository.findTasksByUser(user);

    }

}
