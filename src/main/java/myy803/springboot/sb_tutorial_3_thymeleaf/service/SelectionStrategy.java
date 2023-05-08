package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;

import java.util.List;

public interface SelectionStrategy {

    public Student selectApplicant(List<Student> applicants);
}
