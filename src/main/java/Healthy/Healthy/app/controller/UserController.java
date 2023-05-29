package Healthy.Healthy.app.controller;

import Healthy.Healthy.app.entity.User;
import Healthy.Healthy.app.enums.Gender;
import Healthy.Healthy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public void signIn(@RequestBody User user) {
        userService.signIn(user);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        userService.signUp(user);
    }
    @GetMapping("/gender")
    public List<String> getGenderOptions() {
        return Arrays.stream(Gender.values())
                .map(Gender::getValue)
                .collect(Collectors.toList());
    }
}
