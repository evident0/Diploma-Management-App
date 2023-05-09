package org.uoi.diploma_management_application.service;

import org.springframework.stereotype.Service;

import org.uoi.diploma_management_application.entity.User;

@Service
public interface UserService {
	public void saveUser(User user,  String firstName, String lastName, String email);
    public boolean isUserPresent(User user);


}
