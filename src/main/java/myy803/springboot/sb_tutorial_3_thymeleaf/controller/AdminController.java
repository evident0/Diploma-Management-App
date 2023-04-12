package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;
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

    @RequestMapping(value = "/admin/details", method = RequestMethod.GET)
    @ResponseBody
    public String currentDetails(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return Integer.toString(user.getId());
    }
//find by username in professor table or whatever
    @RequestMapping(value = "/admin/more", method = RequestMethod.GET)
    @ResponseBody
    public String currentMore(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return "nothing";// user.getProfessorDetails();
    }
}

