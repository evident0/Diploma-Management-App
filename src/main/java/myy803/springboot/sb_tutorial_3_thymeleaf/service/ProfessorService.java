package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import java.util.List;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.*;

public interface ProfessorService {

	public List<Professor> findAll();

	public Professor findByFirstName(String firstName);

	public Subject findSubjectById(int subjectId);
	
	public Professor findById(int p_Id);
	
	public void save(Professor theProfessor);

	public void saveSubject(Subject theSubject);

	public List<Student> findStudentsBySubjectId(int subjectId);
	
	public void deleteById(int p_Id);

	public void deleteSubjectById(int s_Id);

	public List<Thesis> findThesisByPId(int p_Id);
	
}
