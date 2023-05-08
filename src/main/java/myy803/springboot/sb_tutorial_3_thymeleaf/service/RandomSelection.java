package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;

import java.util.List;
import java.util.Random;

public class RandomSelection implements SelectionStrategy{

    @Override
    public Student selectApplicant(List<Student> applicants) {
        Random random = new Random();
        int index = random.nextInt(applicants.size());
        return applicants.get(index);
    }
}
