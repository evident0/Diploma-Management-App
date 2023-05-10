package org.uoi.diploma_management_application.service;

import java.util.ArrayList;
import java.util.List;

import org.uoi.diploma_management_application.dao.ApplicationDAO;
import org.uoi.diploma_management_application.dao.ProfessorDAO;
import org.uoi.diploma_management_application.dao.SubjectDAO;
import org.uoi.diploma_management_application.dao.ThesisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uoi.diploma_management_application.entity.*;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorRepository;

	@Autowired
	private SubjectDAO subjectRepository;

	@Autowired
	private ThesisDAO thesisRepository;

	@Autowired
	private ApplicationDAO applicationRepository;
	
	@Autowired
	public ProfessorServiceImpl(ProfessorDAO theProfessorRepository, SubjectDAO theSubjectRepository,
								ThesisDAO theThesisRepository, ApplicationDAO theApplicationRepository) {
		professorRepository = theProfessorRepository;
		subjectRepository = theSubjectRepository;
		thesisRepository = theThesisRepository;
		applicationRepository = theApplicationRepository;
	}
	
	public ProfessorServiceImpl() {
	}

	@Override
	@Transactional
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	@Override
	@Transactional
	public Professor findById(int p_Id) {
		Professor result = professorRepository.findById(p_Id);
				
		if (result != null ) {
			return result;
		}
		else {
			throw new RuntimeException("Did not find Professor id - " + p_Id);
		}
	}

	@Override
	@Transactional
	public List<Student> findStudentsBySubjectId(int subjectId) {
		Subject subject = subjectRepository.findById(subjectId);
		List<Application> applications = subject.getApplications();
		List<Student> students = new ArrayList<Student>();
		for(Application application : applications){
			students.add(application.getStudent());
		}


		if (students != null ) {
			return students;
		}
		else {
			throw new RuntimeException("Did not find Subject id - " + subjectId);
		}
	}

	@Override
	@Transactional
	public Subject findSubjectById(int subjectId) {
		Subject result = subjectRepository.findById(subjectId);

		if (result != null ) {
			return result;
		}
		else {
			throw new RuntimeException("Did not find Subject id - " + subjectId);
		}
	}

	@Override
	@Transactional
	public Professor findByFirstName(String firstName) {
		Professor result = professorRepository.findByFirstName(firstName);

		if (result != null ) {
			return result;
		}
		else {
			throw new RuntimeException("Did not find Professor id - " + firstName);
		}
	}

	@Override
	@Transactional
	public void save(Professor theProfessor) {
		professorRepository.save(theProfessor);
	}

	@Override
	@Transactional
	public void saveThesis(Thesis theThesis) {
		thesisRepository.save(theThesis);
	}

	@Override
	@Transactional
	public void saveSubject(Subject theSubject) {
		subjectRepository.save(theSubject);
	}

	@Override
	@Transactional
	public void deleteSubjectById(int s_Id){
		subjectRepository.deleteById(s_Id);
	}

	@Override
	@Transactional
	public void deleteApplicationById(ApplicationKey applicationId){
		applicationRepository.deleteById(applicationId);
	}

	@Override
	@Transactional
	public void deleteById(int p_Id) {
		professorRepository.deleteById(p_Id);
	}

	@Override
	public List<Thesis> findThesisByPId(int p_Id) {
		return professorRepository.findById(p_Id).getThesis();
	}

	@Override
	public Thesis findThesisById(int t_Id) {
		return thesisRepository.findById(t_Id);
	}

	@Override
	@Transactional
	public int assignThesis(Student student, Subject subject){
		if(subject.getThesis()!=null){
			return -1;
		}
		if(student==null) {
			return -2;
		}
		Thesis newThesis = new Thesis(subject, student);
		saveThesis(newThesis);
		ApplicationKey applicationId = new ApplicationKey(subject.getSubjectId(),student.getStudentId());
		deleteApplicationById(applicationId);
		return 0;
	}

	@Override
	public float calculateGrade(float gradeI, float gradeR, float gradeP){
		return (float)(0.7*gradeI + 0.15*gradeR + 0.15*gradeP);
	}

	@Override
	@Transactional
	public void saveThesisGrade(Thesis thesis, float grade){
		thesis.setGrade(grade);
		thesisRepository.save(thesis);
	}
}
