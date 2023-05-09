package org.uoi.diploma_management_application.service;

import java.util.List;


import org.uoi.diploma_management_application.entity.*;

public interface ProfessorService {

	public List<Professor> findAll();

	public Professor findByFirstName(String firstName);

	public Subject findSubjectById(int subjectId);
	
	public Professor findById(int p_Id);
	
	public void save(Professor theProfessor);

	public void saveSubject(Subject theSubject);

	public void saveThesis(Thesis theThesis);

	public List<Student> findStudentsBySubjectId(int subjectId);
	
	public void deleteById(int p_Id);

	public void deleteSubjectById(int s_Id);

	public void deleteApplicationById(ApplicationKey applicationId);

	public List<Thesis> findThesisByPId(int p_Id);

	public Thesis findThesisById(int t_Id);

	public int assignThesis(Student student, Subject subject);

	public float calculateGrade(float gradeI, float gradeR, float gradeP);

	public void saveThesisGrade(Thesis thesis, float grade);
	
}
