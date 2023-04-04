package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import java.util.List;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Professor;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.ProfessorService;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@Autowired
	public ProfessorController(ProfessorService theProfessorService) {
		professorService = theProfessorService;
	}

	@RequestMapping("/list")
	public String test(Model theModel) {

		// get professors from db
		List<Thesis> thesisList = professorService.findThesisByPId(4);
		System.out.println(thesisList);
		return "helloworld";
	}

	// add mapping for "/list"
/*
	@RequestMapping("/list")
	public String listProfessors(Model theModel) {

		// get professors from db
		List<Professor> theProfessors = professorService.findAll();

		// add to the spring model
		theModel.addAttribute("professors", theProfessors);

		return "professors/list-professors";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Professor theProfessor = new Professor();

		theModel.addAttribute("professor", theProfessor);

		return "professors/professor-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("professorId") int theId,
									Model theModel) {

		// get the professor from the service
		Professor theProfessor = professorService.findById(theId);

		// set professor as a model attribute to pre-populate the form
		theModel.addAttribute("professor", theProfessor);


		// send over to our form
		return "professors/professor-form";
	}


	@RequestMapping("/save")
	public String saveProfessor(@ModelAttribute("professor") Professor theProfessor){


		// save the professor
		professorService.save(theProfessor);

		// redirect to /professors/list ACTION
		return "redirect:/professors/list";
	}


	@RequestMapping("/delete")
	public String delete(@RequestParam("professorId") int theId) {

		// delete the professor
		professorService.deleteById(theId);

		// redirect to /professors/list ACTION
		return "redirect:/professors/list";

	}
	*/
}


















