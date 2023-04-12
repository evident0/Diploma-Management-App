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
	private int p_id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@OneToMany(targetEntity = Thesis.class, cascade = CascadeType.MERGE, mappedBy = "professor", fetch = FetchType.EAGER)
	private List<Thesis> thesisList= new ArrayList<>();

	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "user_name")
	//Student student;

	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "user_name")//, referencedColumnName = "user_name")
	//private User user;
	// define constructors

	//public User getUser() {
	//	return user;
	//}
	
	public Professor() {
		
	}
	
	public Professor(int p_id, String firstName, String lastName, String email) {
		this.p_id = p_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Professor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// define getter/setter
	
	public int getPId() {
		return p_id;
	}

	public void setPId(int p_id) {
		this.p_id = p_id;
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

	@Override
	public String toString() {
		return "Professor [id=" + p_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
		
}











