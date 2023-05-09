package org.uoi.diploma_management_application.service;

import org.uoi.diploma_management_application.entity.Student;
import java.util.List;
import java.util.Random;

public class RandomSelection implements SelectionStrategy{

    @Override
    public Student selectApplicant(List<Student> applicants) {
        if(applicants.size()==0){
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(applicants.size());
        return applicants.get(index);
    }
}
