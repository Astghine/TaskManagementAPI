package com.example.demo.rest;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Astgh on 8/2/2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getAll(){
        List<User> allUsers = userService.getAllUsers();
        if (allUsers.isEmpty()){
            return ResponseEntity.ok("No user is found");
        }
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getById(@PathVariable("id") long id){
        User user = userService.getById(id);
        if (user!=null){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.ok("No user is found");
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id){userService.deleteById(id);
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
    return ResponseEntity.ok("Deleted");}


    @PostMapping(value = "/users/add", consumes = "application/json")
    public ResponseEntity add(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("created");
    }

    @PutMapping(value = "/users/{id}", consumes = "application/json")
    public ResponseEntity updateUser(@PathVariable("id") long id, @RequestBody User user) {
        if (userService.getById(id)!=null){
        userService.updateUser(id,user);
        return ResponseEntity.ok("updated");
        } else return ResponseEntity.badRequest().build();
    }

}
