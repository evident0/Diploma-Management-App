package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.ProfessorService;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private StudentService studentService;

    @Autowired
    public UserController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    @RequestMapping("/user/dashboard")
    public String getUserHome(){
//    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		 String currentPrincipalName = authentication.getName();
//		 System.err.println(currentPrincipalName);

        return "user/dashboard";
    }

    @RequestMapping(value = "/user/details", method = RequestMethod.GET)
    @ResponseBody
    public String currentDetails(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        //Integer.toString(user.getId())
        return user.getStudent().getFirstName();
    }

    @RequestMapping(value = "/user/change", method = RequestMethod.GET)
    @ResponseBody
    public String currentDetailsChangeName(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        //Integer.toString(user.getId())
        user.getStudent().setFirstName("new name");

        studentService.save(user.getStudent());
//lol
        return user.getStudent().getFirstName();
    }
}
