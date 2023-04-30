package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import java.util.Optional;

import myy803.springboot.sb_tutorial_3_thymeleaf.dao.StudentDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Professor;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Role;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import myy803.springboot.sb_tutorial_3_thymeleaf.dao.UserDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.dao.ProfessorDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;
import org.springframework.transaction.annotation.Transactional;

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
	public void saveUser(User user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);



        userDAO.save(user);


		if (user.getRole() == Role.PROFESSOR) {
			Professor professor = new Professor("test","test","test");
			professor.setUser(user);
			System.out.println("THE ID ::::::: professor: " + professor.getPId());
			professorDAO.save(professor);
		}else if (user.getRole() == Role.STUDENT) {
			Student student = new Student("test","test","test");
			student.setUser(user);
			System.out.println("THE ID ::::::: student: " + student.getStudentId());
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
