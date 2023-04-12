package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.UserService;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "auth/signin";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/signup";
    }

    @RequestMapping("/save")
    public String registerUser(@ModelAttribute("user") User user, Model model){

        if(userService.isUserPresent(user)){
            model.addAttribute("successMessage", "User already registered!");
            return "auth/signin";
        }

        userService.saveUser(user);
        model.addAttribute("successMessage", "User registered successfully!");

        return "auth/signin";
    }
}

