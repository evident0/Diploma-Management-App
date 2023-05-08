package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.*;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

//TODO: change all references of admin to professor
@Controller
public class AdminController {

    private ProfessorService professorService;

    @Autowired
    public AdminController(ProfessorService theProfessorService) {
        professorService = theProfessorService;
    }

    @RequestMapping("/admin/dashboard")
    public String getAdminHome(Authentication authentication,
                               Model theModel){
        User user = (User) authentication.getPrincipal();
        user.setProfessor(professorService.findById(user.getProfessor().getPId()));
        Professor professor = user.getProfessor();
        theModel.addAttribute("professor", professor);
        theModel.addAttribute("subjectList", professor.getSubjects());
        return "admin/dashboard";
    }

    @RequestMapping("/admin/create-subject")
    public String createSubject(Authentication authentication,
                                Model theModel){

        Subject subject = new Subject();
        theModel.addAttribute("subject", subject);
        return "admin/create-subject";
    }


    @RequestMapping(value = "/admin/save_subject")
    public String saveSubject(Authentication authentication, @ModelAttribute("subject") Subject theSubject) {
        User user = (User) authentication.getPrincipal();
        Professor professor = user.getProfessor();
        theSubject.setProfessor(professor);
        professorService.saveSubject(theSubject);

        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value ="/admin/delete-subject")
    public String deleteSubject(@RequestParam("subjectId") int theId) {

        // delete the employee
        professorService.deleteSubjectById(theId);

        // redirect to /employees/list ACTION
        return "redirect:/admin/dashboard";
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

    @RequestMapping(value = "/admin/applications")
    public String viewApplications(@RequestParam("subjectId") int theId, Model theModel) {
        List<Student> students = professorService.findStudentsBySubjectId(theId);
        theModel.addAttribute("studentList",students);
        theModel.addAttribute("subjectId",theId);
        return "/admin/applications";
    }

    @PostMapping("/admin/pick-student")
    public String pickStudent(@RequestParam("pickMethod") String pickMethod, @RequestParam("subjectId") int theId){
        List<Student> students = professorService.findStudentsBySubjectId(theId);
        Context context = new Context();
        switch (pickMethod) {
            case "bestAVG":
                context.setStrategy(new BestGradeSelection());
                break;
            case "fewestCourses":
                context.setStrategy(new FewestCoursesSelection());
                break;
            default:
                context.setStrategy(new RandomSelection());
                break;
        }
        assignThesis(context.selectApplicant(students), professorService.findSubjectById(theId));
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/admin/pick-bythresholds")
    public String pickByThresholds(@RequestParam("th1") float th1, @RequestParam("th2") int th2,
                                   @RequestParam("subjectId") int theId){
        List<Student> students = professorService.findStudentsBySubjectId(theId);
        Context context = new Context(new ThresholdSelection(th1, th2));
        assignThesis(context.selectApplicant(students), professorService.findSubjectById(theId));
        return "redirect:/admin/dashboard";
    }

     private void assignThesis(Student student, Subject subject){
         if(student!=null) {
             Thesis newTheis = new Thesis(subject, student);
             professorService.saveThesis(newTheis);
             ApplicationKey applicationId = new ApplicationKey(subject.getSubjectId(),student.getStudentId());
             professorService.deleteApplicationById(applicationId);
         }
     }

}

