package myy803.springboot.sb_tutorial_3_thymeleaf.controller;

import java.util.List;

import myy803.springboot.sb_tutorial_3_thymeleaf.dao.StudentDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.*;
import myy803.springboot.sb_tutorial_3_thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.springboot.sb_tutorial_3_thymeleaf.service.ProfessorService;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

	private ProfessorService professorService;

	private StudentService studentService;


	@Autowired
	public ProfessorController(ProfessorService theProfessorService, StudentService theStudentService) {
		professorService = theProfessorService;
		studentService = theStudentService;
	}

	@RequestMapping("/list")
	public String test(Model theModel) {

		// get professors from db
		List<Thesis> thesisList = professorService.findThesisByPId(4);
		System.out.println(thesisList);
		return "helloworld";
	}

	@RequestMapping("/please")
	public String testPlease(Model theModel) {

		// get professors from db
		List<Application> thesisList = studentService.listStudentSubjects(1);
		System.out.println(thesisList);
		return "helloworld";
	}

	@RequestMapping("/please_save")
	public String testPleaseSave(Model theModel) {

		// get professors from db
		//List<Application> thesisList = studentService.listStudentSubjects(1);
		Application application = new Application(1,5,
				studentService.findById(1),
				studentService.findSubjectById(5));
		//Application application = new Application(new Student(1, "Bob",
		//		"Smith", "bob@protonmail.com"), new Subject(5, "subject5", "d5"));

		System.out.println(application);

		studentService.saveApplication(application);

		//thesisList.add(application);
		//studentService.findById(1).getApplications().add(application);

		studentService.findById(1).setFirstName("Not bob");

		studentService.save(studentService.findById(1));

		System.out.println(studentService.findById(1).getApplications());

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


















