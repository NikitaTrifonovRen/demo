package com.example.demo.Web.Contoller;

import com.example.demo.Web.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("user")
    public String showUser(Model model, Principal principal){
        model.addAttribute("user",userService.findByName(principal.getName()));
        return "userPage";
    }
}
