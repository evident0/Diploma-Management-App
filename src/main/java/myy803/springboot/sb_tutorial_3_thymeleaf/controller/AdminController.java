package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AdminController {

    @RequestMapping("/admin/dashboard")
    public String getAdminHome(){
        return "admin/dashboard";
    }

    @RequestMapping(value = "/admin/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}

