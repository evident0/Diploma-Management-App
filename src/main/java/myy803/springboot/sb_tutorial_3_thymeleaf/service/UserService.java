package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import org.springframework.stereotype.Service;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;

@Service
public interface UserService {
	public void saveUser(User user);
    public boolean isUserPresent(User user);
}
