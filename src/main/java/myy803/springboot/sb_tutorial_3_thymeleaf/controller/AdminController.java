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
//TODO: change all references of admin to professor
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
        return user.getProfessor().getFirstName();
    }

    @RequestMapping(value = "/admin/get_thesis", method = RequestMethod.GET)
    @ResponseBody
    public String currentMore(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user.getProfessor().getThesis().toString();// user.getProfessorDetails();
    }

    @RequestMapping(value = "/admin/change")
    public String changeDetails(Authentication authentication,
                                           Model theModel) {

        User user = (User) authentication.getPrincipal();
        Professor professor = user.getProfessor();

        theModel.addAttribute("professor", professor);

        return "admin/professor-details";
    }

    @RequestMapping(value = "/admin/save_details")
    public String saveDetails(Authentication authentication, @ModelAttribute("professor") Professor theProfessor) {

        User user = (User) authentication.getPrincipal();
        Professor professor = user.getProfessor();
        // We use copyFields because saving the object theProfessor directly will not update User.professor
        professor.copyFields(theProfessor);
        // therefore we save User.professor
        professorService.save(professor);

        return "redirect:/admin/dashboard";
    }
}

