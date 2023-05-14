package org.uoi.diploma_management_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.uoi.diploma_management_application.entity.*;
import org.uoi.diploma_management_application.service.*;

import java.util.List;

@Controller
public class ProfessorController {

    private ProfessorService professorService;

    private int state = 0;

    private String message = "";

    @Autowired
    public ProfessorController(ProfessorService theProfessorService) {
        professorService = theProfessorService;
    }

    @RequestMapping("/professor/dashboard")
    public String getProfessorHome(Authentication authentication,
                               Model theModel){
        User user = (User) authentication.getPrincipal();
        user.setProfessor(professorService.findById(user.getProfessor().getPId()));
        Professor professor = user.getProfessor();
        theModel.addAttribute("professor", professor);
        theModel.addAttribute("subjectList", professor.getSubjects());
        theModel.addAttribute("thesisList", professor.getThesis());
        if(state!=0){
            state = 0;
            theModel.addAttribute("successMessage", message);
        }
        return "professor/dashboard";
    }

    @RequestMapping("/professor/create-subject")
    public String createSubject(Authentication authentication,
                                Model theModel){

        Subject subject = new Subject();
        theModel.addAttribute("subject", subject);
        return "professor/create-subject";
    }


    @RequestMapping(value = "/professor/save_subject")
    public String saveSubject(Authentication authentication, @ModelAttribute("subject") Subject theSubject) {
        User user = (User) authentication.getPrincipal();
        Professor professor = user.getProfessor();
        theSubject.setProfessor(professor);
        professorService.saveSubject(theSubject);

        return "redirect:/professor/dashboard";
    }

    @RequestMapping(value ="/professor/delete-subject")
    public String deleteSubject(@RequestParam("subjectId") int theId) {

        // delete the employee
        professorService.deleteSubjectById(theId);

        // redirect to /employees/list ACTION
        return "redirect:/professor/dashboard";
    }


    @RequestMapping(value = "/professor/change")
    public String changeDetails(Authentication authentication,
                                           Model theModel) {

        User user = (User) authentication.getPrincipal();
        Professor professor = user.getProfessor();
        theModel.addAttribute("professor", professor);
        return "professor/professor-details";
    }

    @RequestMapping(value = "/professor/save_details")
    public String saveDetails(Authentication authentication, @ModelAttribute("professor") Professor theProfessor) {

        User user = (User) authentication.getPrincipal();
        Professor professor = user.getProfessor();
        // We use copyFields because saving the object theProfessor directly will not update User.professor
        professor.copyFields(theProfessor);
        // therefore we save User.professor
        professorService.save(professor);

        return "redirect:/professor/dashboard";
    }

    @RequestMapping("/professor/update-grade")
    public String updateGrade(@RequestParam("thesisId") int thesisId, Model theModel){
        theModel.addAttribute("thesisId", thesisId);
        return "/professor/update-grade-form";
    }

    @RequestMapping("/professor/save-grade")
    public String saveGrade(@RequestParam("thesisId") int thesisId, @RequestParam("gradeI") float gradeI,
                            @RequestParam("gradeR") float gradeR, @RequestParam("gradeP") float gradeP) {
        Thesis thesis = professorService.findThesisById(thesisId);
        float grade = professorService.calculateGrade(gradeI, gradeR, gradeP);
        professorService.saveThesisGrade(thesis, grade);

        return "redirect:/professor/dashboard";
    }

    @RequestMapping(value = "/professor/applications")
    public String viewApplications(@RequestParam("subjectId") int theId, Model theModel) {
        List<Student> students = professorService.findStudentsBySubjectId(theId);
        theModel.addAttribute("studentList",students);
        theModel.addAttribute("subjectId",theId);
        return "professor/applications-list";
    }

    @PostMapping("/professor/pick-student")
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
        int res = professorService.assignThesis(context.selectApplicant(students),
                professorService.findSubjectById(theId));
        state = res;
        if(state == -1){
            message = "Subject is taken by another student";
        }
        else if (state ==-2){
            message = "No students found meeting the criteria";
        }

        return "redirect:/professor/dashboard";
    }

    @PostMapping("/professor/pick-bythresholds")
    public String pickByThresholds(@RequestParam("th1") float th1, @RequestParam("th2") int th2,
                                   @RequestParam("subjectId") int theId){
        List<Student> students = professorService.findStudentsBySubjectId(theId);
        Context context = new Context(new ThresholdSelection(th1, th2));
        professorService.assignThesis(context.selectApplicant(students), professorService.findSubjectById(theId));
        if(state == -1){
            message = "Subject is taken by another student";
        }
        else if (state ==-2){
            message = "No students found meeting the criteria";
        }
        return "redirect:/professor/dashboard";
    }


}

