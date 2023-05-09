package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.*;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.ProfessorService;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private StudentService studentService;

    @Autowired
    public UserController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    @RequestMapping("/user/dashboard")
    public String getUserHome(Authentication authentication,
                              Model theModel){
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         String currentPrincipalName = authentication.getName();
//         System.err.println(currentPrincipalName);

        User user = (User) authentication.getPrincipal();
        user.setStudent(studentService.findById(user.getStudent().getStudentId()));
        Student student = user.getStudent();
        theModel.addAttribute("student", student);
        theModel.addAttribute("subjectList", studentService.getAvailableSubjects());
        List<Thesis> thesisList = new ArrayList<Thesis>();
        Thesis thesis = studentService.getThesis(student);
        if(thesis != null){
            thesisList.add(thesis);
        }
        theModel.addAttribute("thesisList", thesisList);


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

    @RequestMapping(value ="/user/apply-subject")
    public String applySubject(@RequestParam("subjectId") int theId, @RequestParam("thisStudentId") int theStudentId) {

        Student student = studentService.findById(theStudentId);
        Subject subject = studentService.findSubjectById(theId);

        Application theApplication = new Application(theStudentId,theId,student,subject);
        studentService.saveApplication(theApplication);


        return "redirect:/user/dashboard";

    }

    @RequestMapping("/user/available-subjects")
    public String getUserAvailableSubjects(Authentication authentication,
                                           Model theModel){

        User user = (User) authentication.getPrincipal();
        int studentId = user.getStudent().getStudentId();


        theModel.addAttribute("subjectList", studentService.getAvailableSubjects());
        theModel.addAttribute("student", studentId);

        return "user/available-subjects";
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
