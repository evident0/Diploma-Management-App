package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Thesis;
import org.springframework.stereotype.Service;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;

@Service
public interface UserService {
	public void saveUser(User user,  String firstName, String lastName, String email);
    public boolean isUserPresent(User user);


}
