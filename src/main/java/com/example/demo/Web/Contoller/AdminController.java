package com.example.demo.Web.Contoller;

import com.example.demo.Web.Models.User;
import com.example.demo.Web.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String printAllUsers (ModelMap model){
        model.addAttribute("users",userService.allUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id")int id, ModelMap model){
        model.addAttribute("user",userService.showUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin";
    }
    @GetMapping("/{id}/update")
    public String editUser(@PathVariable("id")int id, ModelMap model){
        model.addAttribute("user",userService.showUser(id));
        return "update";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUserParams(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User user,@PathVariable("id") int id){
        userService.removeUser(id);
        return "redirect:/admin";
    }


}
