package com.example.startweb.web;

import com.example.startweb.db.User;
import com.example.startweb.db.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("/first")
public class MyContoller {
    //
//    @GetMapping
//    public String get() {
//        return "Hi there!";
//    }
    UserRepository userRepository;


    public MyContoller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hi")
    public String get(@RequestParam int id) {

        Iterable<User> all = userRepository.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return "Hi " + userOptional.get().getName();
        }

        return "Hi there!" + id;

    }

    @GetMapping("/bye")
    public String getBye(@RequestParam int id) {
        return "Bye!" + id;
    }
}
