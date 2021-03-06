package org.niebieskidom.bluecamps.controller;

import org.niebieskidom.bluecamps.entity.*;
import org.niebieskidom.bluecamps.repositories.RoleRepository;
import org.niebieskidom.bluecamps.services.ChildService;
import org.niebieskidom.bluecamps.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final ChildService childService;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserController(UserService userService, ChildService childService, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.childService = childService;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @ModelAttribute("children")
    public List<Child> children() {
        return childService.getChildren();
    }


    @GetMapping("/admin")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {
        logger.info("customUser class {} ", customUser.getClass());
        return "You are logged as " + customUser;
    }

    @GetMapping("/adminHello")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }


    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }

    //napis poprawnie
    @GetMapping("/logged/{username}")
    public String showLoggedUser(@PathVariable String username, Model model) {
        User user = userService.findByUserName(username);
//
//        Optional<User> user = Optional.ofNullable(userService.findByUserName(username));
//        User user1 = user.orElse(null);
        model.addAttribute("user", user);
        return "users/userLogged";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "users/userForm";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult bindingResult) {
        if (user.getId() == null) {
            List<User> users = userService.showUsers();
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername())) {
                    FieldError error = new FieldError("user", "username", "Nazwa użytkownika już istnieje w bazie danych");
                    bindingResult.addError(error);
                }
            }
        }
        if (bindingResult.hasErrors()) {
            return "users/userForm";
        } else {
            Set<Role> roles = new HashSet<>();
            Role role = roleRepository.findByName("ROLE_USER");
            roles.add(role);
            user.setEnabled(1);
            user.setRoles(roles);
            String password = user.getPassword();
            String hashPassword = bCryptPasswordEncoder.encode(password);
            user.setPassword(hashPassword);
            userService.saveUser(user);
        }
        return "redirect:/user/all";
    }

    @GetMapping("/edit")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/all";
    }

//    @GetMapping("/edit/{id}")
//    public String updateUser(@PathVariable Long id, Model model) {
//        Optional<User> optionalUser = userService.getUser(id);
//        User user = optionalUser.orElse(null);
//        if (user == null) {
//            return "Have a problem dude.";
//        }
//        model.addAttribute("user", user);
//        return "users/userForm";
//    }


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
        user.getRoles().clear();
        user.getChildren().clear();
        userService.deleteUser(id);
        return "redirect:/user/all";
    }


    @PostMapping("/children")
    public String childrenOfUser( Model model, @RequestParam long id){
        List<Child> children = childService.findChildrenByUserId(id);
        model.addAttribute("children",children);
        return "children/childrenList";
    }

}