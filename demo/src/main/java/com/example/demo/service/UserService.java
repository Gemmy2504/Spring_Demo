package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    public List<User> getAll(){
        try{
            return userRepository.findAll();
        }catch (Exception e){

            log.error(e.getMessage());
            return null;
        }

    }
    public User getByStatus(String status){
        try{
            return userRepository.findUserByStatus(status);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
    public User getById(long id){
        try{
            return userRepository.findById(id).get();
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
    public Long addUser(User user){
        try{
           return userRepository.save(user).getId();

        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
    public boolean delete(long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
    public boolean update(User user){
        try{
            User updatedUser = userRepository.findByEmail(user.getEmail());
            if(updatedUser != null){
                updatedUser.setEmail(user.getEmail());
                updatedUser.setPassword(user.getPassword());
                updatedUser.setName(user.getName());
                updatedUser.setAge(user.getAge());
                userRepository.save(updatedUser);
                return true;
            }
            return false;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
