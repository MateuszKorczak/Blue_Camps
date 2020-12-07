package org.niebieskidom.bluecamps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "users/login";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "Here you can find some details for logged users";
    }

}
