package com.example.demo.rest;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Astgh on 8/2/2017.
 */
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;


    @GetMapping("/tasks")
    public ResponseEntity getAll(){
        List<Task> allTasks = taskService.getAllTasks();
        if(allTasks.isEmpty()){
            return ResponseEntity.ok("There are no task added. Please add a task");
        }else
        return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getById(@PathVariable("id") long id){
        Task task = taskService.getById(id);
        if(task==null){
            return ResponseEntity.ok("There are no task added. Please add a task");
        }else
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){taskService.deleteById(id);
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("Deleted");}


    @PostMapping(value = "/tasks/add", consumes = "application/json")
    public ResponseEntity add(@RequestBody Task task) {
        taskService.save(task);
        return ResponseEntity.ok("created");
    }

    @PutMapping(value = "/tasks/{id}", consumes = "application/json")
    public ResponseEntity updateTask(@PathVariable("id") long id, @RequestBody Task task) {
        if (taskService.getById(id)!=null){
            taskService.updateTask(id,task);
            return ResponseEntity.ok("updated");
        } else return ResponseEntity.badRequest().build();

    }




    @GetMapping("/tasks/byUserId/{id}")
    public ResponseEntity getAllTasksByUserId(@PathVariable("id") long userId){
        User user = userService.getById(userId);
        List<Task> tasksByUserID = taskService.getAllTasksByUser(user);
        if (user==null){
            return ResponseEntity.ok("There are no user available.First add the user");
        } else if (tasksByUserID.isEmpty()){
            return ResponseEntity.ok("No tasks is available for that user.");
        }else
        return ResponseEntity.ok(tasksByUserID);
    }

}
