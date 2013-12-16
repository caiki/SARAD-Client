package pe.edu.unsaac.in.sarad.client.model;

import java.util.ArrayList;

public class Course {
	private String id;
	private String name;
	private float credits;
	private ArrayList<Course> requirements = new ArrayList<Course>();
	
	public ArrayList<Course> getRequirements() {
		return requirements;
	}
	public void setRequirements(ArrayList<Course> requirements) {
		this.requirements = requirements;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCredits() {
		return credits;
	}
	public void setCredits(float credits) {
		this.credits = credits;
	}

	
}
