package org.uoi.diploma_management_application.controller;

import org.uoi.diploma_management_application.entity.*;
import org.uoi.diploma_management_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    @RequestMapping("/student/dashboard")
    public String getUserHome(Authentication authentication,
                              Model theModel){

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


        return "student/dashboard";
    }


    @RequestMapping(value ="/student/apply-subject")
    public String applySubject(@RequestParam("subjectId") int theId, @RequestParam("thisStudentId") int theStudentId) {
        Student student = studentService.findById(theStudentId);
        Subject subject = studentService.findSubjectById(theId);
        Application theApplication = new Application(theStudentId,theId,student,subject);
        studentService.saveApplication(theApplication);
        return "redirect:/student/dashboard";
    }

    @RequestMapping("/student/available-subjects")
    public String getUserAvailableSubjects(Authentication authentication,
                                           Model theModel){
        User user = (User) authentication.getPrincipal();
        int studentId = user.getStudent().getStudentId();
        theModel.addAttribute("subjectList", studentService.getAvailableSubjects());
        theModel.addAttribute("student", studentId);
        return "student/available-subjects";
    }


    @RequestMapping(value = "/student/change")
    public String changeDetails(Authentication authentication, Model theModel) {
        User user = (User) authentication.getPrincipal();
        Student student = user.getStudent();
        theModel.addAttribute("student", student);
        return "student/student-details";
    }

    @RequestMapping(value = "/student/save_details")
    public String saveDetails(Authentication authentication, @ModelAttribute("student") Student theStudent) {

        User user = (User) authentication.getPrincipal();
        Student student = user.getStudent();
        // We use copyFields because saving the object theStudent directly will not update User.student
        student.copyFields(theStudent);
        // therefore we save User.student
       studentService.save(student);

        return "redirect:/student/dashboard";
    }

}
