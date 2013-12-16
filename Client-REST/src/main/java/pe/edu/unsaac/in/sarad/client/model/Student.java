package pe.edu.unsaac.in.sarad.client.model;

import java.util.Date;

public class Student extends Person {
	private String id;
	private String career;
	private String email;
	private String dni;
	
	public String getResume(){
		return id + " - " + name + " " + lastName;
	}
	
	
	public Student(String dni, String name,String lastName, String sLastName,
							String id, String career, String email) {
		//Aqui se invoca al constructor de la super clase.
		super(dni, name);
		this.lastName = lastName;
		super.secondLastName = sLastName;
		this.address = address;
		//telephoneNumber = tNumber;
		super.birthday = birthday;
		this.id = id;
		this.career = career;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
