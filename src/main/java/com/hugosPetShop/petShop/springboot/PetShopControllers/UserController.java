package com.hugosPetShop.petShop.springboot.PetShopControllers;

import com.hugosPetShop.petShop.springboot.exception.UserNotFoundException;
import com.hugosPetShop.petShop.springboot.models.User;
import com.hugosPetShop.petShop.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/users")
    User newUser(@RequestBody User userDetails){
        return userRepository.save(userDetails);
    }

    @PutMapping("/users/{id}")
    User editUser(@PathVariable Long id, @RequestBody User userDetails){
        return userRepository.findById(id)
                .map(user -> {
                    if (userDetails.getName() != null) {
                        user.setName(userDetails.getName());
                    }
                    if (userDetails.getEmail() != null) {
                        user.setEmail(userDetails.getEmail());
                    }
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundException(id));
    }

    @DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User has been successfully deleted";
    }

}
