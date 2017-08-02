package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Astgh on 8/2/2017.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user){userRepository.save(user);    }

    public User getById(long id){return userRepository.findOne(id);}
    public List< User> getAllUsers(){return userRepository.findAll();  }
    public void deleteById(long id){userRepository.delete(id);}
    public void updateUser(long id, User user){
    user.setId(id);
    userRepository.save(user);
    }

}
