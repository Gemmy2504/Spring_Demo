package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    private UserRepository userRepository;
    public Optional<User> login(String email, String password) {
       try{
          Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));

           if(user.isPresent()) {
               if(password.equals(user.get().getPassword())){
                   return user;
               }
               log.error("Wrong Password");
           }else
                log.error("User Not Found");
       }catch (Exception e){
          log.error(e.getMessage());
          return Optional.empty();
       }
        return Optional.empty();
    }

    public boolean register(User newUser) {
        try{
            Optional<User>user = Optional.ofNullable(userRepository.findByEmail(newUser.getEmail()));
            if(user.isPresent()) {
                log.error("User already exists");
                return false;
            }else {
                userRepository.save(newUser);
                return true;
            }

        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

}
