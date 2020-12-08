package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.User;
import org.niebieskidom.bluecamps.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello() {
        return "home";
    }


    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("admin");
        user.setEnabled(1);
        user.setFirstName("Mateusz");
        user.setLastName("Korczak");
        user.setEmail("mateusz@mail.com");
        userService.saveUser(user);
        return "user";
    }


    @GetMapping("/create-admin")
    @ResponseBody
    public String createAin() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEnabled(1);
        user.setFirstName("Tomek");
        user.setLastName("Kotwica");
        user.setEmail("tomek@mail.com");
        userService.saveUser(user);
        return "admin";
    }
}