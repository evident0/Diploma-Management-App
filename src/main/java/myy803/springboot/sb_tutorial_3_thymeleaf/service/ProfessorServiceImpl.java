package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import java.util.List;

import myy803.springboot.sb_tutorial_3_thymeleaf.dao.ProfessorDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorRepository;
	
	@Autowired
	public ProfessorServiceImpl(ProfessorDAO theProfessorRepository) {
		professorRepository = theProfessorRepository;
	}
	
	public ProfessorServiceImpl() {
		// TODO Auto-generated constructor stub
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
			// we didn't find the Professor
			throw new RuntimeException("Did not find Professor id - " + p_Id);
		}
	}

	@Override
	@Transactional
	public void save(Professor theProfessor) {
		professorRepository.save(theProfessor);
	}

	@Override
	@Transactional
	public void deleteById(int p_Id) {
		professorRepository.deleteById(p_Id);
	}


	public List<Thesis> findThesisByPId(int p_Id) {
		return professorRepository.findById(p_Id).getThesis();
	}

}






