package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.Child;
import org.niebieskidom.bluecamps.entity.User;
import org.niebieskidom.bluecamps.services.ChildService;
import org.niebieskidom.bluecamps.services.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class UserController {
    private UserService userService;
    private final ChildService childService;


    public UserController(UserService userService, ChildService childService) {
        this.userService = userService;
        this.childService = childService;
    }

    @ModelAttribute("children")
    public List<Child> children() {
        return childService.getChildren();
    }


    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "users/userForm";
    }


    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/userForm";
        } else {
            userService.addUser(user);
            return "redirect:/user/all";
        }
    }

    @PostMapping("/edit")
    public String editUser(Model model, @RequestParam long id) {
        Optional<User> user = userService.getUser(id);
        model.addAttribute("user", user);
        return "users/userForm";
    }


    @PostMapping("delete")
    public String deleteUser(Model model, @RequestParam long id) {
        model.addAttribute("id", id);
        return "users/deleteConfirmation";
    }

    @PostMapping("delete/confirmed")
    public String executeDeleteUser(@RequestParam Long id) {
        Optional<User> optionalUser = userService.getUser(id);
        User user = optionalUser.orElse(null);
        if (user == null) {                   //dodaj obsługę błędu
            return "have problems";
        }
        userService.deleteUser(id);
        return "redirect:/user/all";
    }

}