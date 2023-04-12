package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user/dashboard")
    public String getUserHome(){
//    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		 String currentPrincipalName = authentication.getName();
//		 System.err.println(currentPrincipalName);

        return "user/dashboard";
    }
}
