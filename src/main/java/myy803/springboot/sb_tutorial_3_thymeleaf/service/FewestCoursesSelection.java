package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;

import java.util.List;

public class FewestCoursesSelection implements SelectionStrategy{

    @Override
    public Student selectApplicant(List<Student> applicants) {
        if(applicants.size()==0){
            return null;
        }
        Student best = applicants.get(0);
        for (Student applicant : applicants) {
            if (applicant.getRemainingCourses() < best.getRemainingCourses()) {
                best = applicant;
            }
        }
        return best;
    }
}
