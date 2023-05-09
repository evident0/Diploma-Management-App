package org.uoi.diploma_management_application.service;

import java.util.Optional;
import org.uoi.diploma_management_application.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.uoi.diploma_management_application.dao.UserDAO;
import org.uoi.diploma_management_application.dao.ProfessorDAO;
import org.springframework.transaction.annotation.Transactional;
import org.uoi.diploma_management_application.entity.Professor;
import org.uoi.diploma_management_application.entity.Role;
import org.uoi.diploma_management_application.entity.Student;
import org.uoi.diploma_management_application.entity.User;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProfessorDAO professorDAO;

	@Autowired
	private StudentDAO studentDAO;


	@Override
	@Transactional
	public void saveUser(User user, String firstName, String lastName, String email) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userDAO.save(user);

		if (user.getRole() == Role.PROFESSOR) {
			Professor professor = new Professor(firstName,lastName,email);
			professor.setUser(user);
			professorDAO.save(professor);
		}else if (user.getRole() == Role.STUDENT) {
			Student student = new Student(firstName,lastName,email, 100,0);
			student.setUser(user);
			studentDAO.save(student);

		}
    }

	@Override
	public boolean isUserPresent(User user) {
		Optional<User> storedUser = userDAO.findByUsername(user.getUsername());
		return storedUser.isPresent();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 return userDAO.findByUsername(username).orElseThrow(
	                ()-> new UsernameNotFoundException(
	                        String.format("USER_NOT_FOUND", username)
	                ));
	}
}
