package com.exampleSimpleFullStack.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(
                userRepository.findAll(),
                HttpStatusCode.valueOf(200)
        );
    }
    @GetMapping("/getAnyUser")
    public ResponseEntity<String> getAnyUser() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(
                    "No User was added :(",
                    HttpStatusCode.valueOf(200)
            );
        }
        else {
            return new ResponseEntity<>(
                    userList.get(userList.size() - 1).toString(),
                    HttpStatusCode.valueOf(200)
            );
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/postNewUser")
    public ResponseEntity<String> postNewUser(
            @RequestParam String userName,
            @RequestParam String userAge
    ) {
        User newUser = new User(userName, Integer.parseInt(userAge));
        userRepository.save(newUser);
        System.out.println("\n> Saved new User: " + newUser + "()" + userAge + "()" + Integer.getInteger(userAge));
        return new ResponseEntity<>(
                newUser.toString(),
                HttpStatusCode.valueOf(200)
        ) ;
    }
}
