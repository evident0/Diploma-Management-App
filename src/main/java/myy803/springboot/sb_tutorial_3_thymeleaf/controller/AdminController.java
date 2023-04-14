package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Professor;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.ProfessorService;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AdminController {

    private ProfessorService professorService;

    @Autowired
    public AdminController(ProfessorService theProfessorService) {
        professorService = theProfessorService;
    }

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
        //Integer.toString(user.getId())
        return user.getProfessor().getFirstName();
    }
//find by username in professor table or whatever
    @RequestMapping(value = "/admin/get_thesis", method = RequestMethod.GET)
    @ResponseBody
    public String currentMore(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user.getProfessor().getThesis().toString();// user.getProfessorDetails();
    }

    @RequestMapping(value = "/admin/change")
    public String currentDetailsChangeName(Authentication authentication,
                                           Model theModel) {

        User user = (User) authentication.getPrincipal();

        Professor professor = user.getProfessor();
        System.out.println(professor);
        System.out.println("THE USERNAMEMMMMMMM====== "+professor.getUser().getUsername());

        theModel.addAttribute("professor", professor);

        return "admin/professor-details";
    }

    @RequestMapping(value = "/admin/save_details")
    public String saveDetails(Authentication authentication, @ModelAttribute("professor") Professor theProfessor) {

        User user = (User) authentication.getPrincipal();
        Professor professor = user.getProfessor();
        // We use copyFields because saving the object theProfessor directly will not update User.professor
        // therefore we save User.getProfessor()
        professor.copyFields(theProfessor);

        professorService.save(professor);


        return "redirect:/admin/dashboard";
    }
}

