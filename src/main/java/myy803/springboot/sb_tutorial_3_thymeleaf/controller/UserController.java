package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Professor;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.ProfessorService;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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


    @RequestMapping(value = "/user/apply", method = RequestMethod.GET)
    @ResponseBody
    public String apply(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        //Integer.toString(user.getId())
        return studentService.getAvailableSubjects().toString();
    }





    @RequestMapping(value = "/user/thesis", method = RequestMethod.GET)
    @ResponseBody
    public String showThesis(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        //Integer.toString(user.getId())
        Student student = user.getStudent();



        return student.getThesis().getTitle();
    }


    @RequestMapping(value = "/user/change")
    public String changeDetails(Authentication authentication, Model theModel) {

        User user = (User) authentication.getPrincipal();
        Student student = user.getStudent();

        theModel.addAttribute("student", student);

        return "user/student-details";
    }

    @RequestMapping(value = "/user/save_details")
    public String saveDetails(Authentication authentication, @ModelAttribute("student") Student theStudent) {

        User user = (User) authentication.getPrincipal();
        Student student = user.getStudent();
        // We use copyFields because saving the object theProfessor directly will not update User.professor
        student.copyFields(theStudent);
        // therefore we save User.professor
       studentService.save(student);

        return "redirect:/user/dashboard";
    }

}
