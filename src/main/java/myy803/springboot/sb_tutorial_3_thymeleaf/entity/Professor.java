package myy803.springboot.sb_tutorial_3_thymeleaf.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="professor")
public class Professor {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p_id")
	private int pId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@OneToMany(targetEntity = Thesis.class, cascade = CascadeType.MERGE, mappedBy = "professor", fetch = FetchType.LAZY)
	private List<Thesis> thesisList= new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private User user;

	@OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
	private List<Subject> subjects = new ArrayList<>();

	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "user_name")
	//Student student;

	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "user_name")//, referencedColumnName = "user_name")
	//private User user;
	// define constructors

	public User getUser() {
		return user;
	}
	
	public Professor() {
		
	}
	
	public Professor(int p_id, String firstName, String lastName, String email) {
		this.pId = p_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public void copyFields(Professor professor) {
		this.pId = professor.pId;
		this.firstName = professor.firstName;
		this.lastName = professor.lastName;
		this.email = professor.email;
	}


	public Professor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// define getter/setter
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getPId() {
		return pId;
	}

	public void setPId(int p_id) {
		this.pId = p_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// define tostring


	public List<Thesis> getThesis() {
		return thesisList;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	@Override
	public String toString() {
		return "Professor [id=" + pId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
		
}











