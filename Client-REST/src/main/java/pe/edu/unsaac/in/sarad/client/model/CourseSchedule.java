package pe.edu.unsaac.in.sarad.client.model;

import java.util.ArrayList;
import java.util.Date;
public class CourseSchedule {
	private String id;
	private ArrayList<String> classrooms = new ArrayList<String>(); //s� o no
	private ArrayList<Date> dates = new ArrayList<Date>(); //s� o no
	private int vacancy;
	private ArrayList<ScheduleCourseStudent> list = 
		new ArrayList<ScheduleCourseStudent>(); //Tiene que instanciarse
	private Professor professor;
	
	public boolean regStudent(Student s){
		if (vacancy > 0 ) {
			ScheduleCourseStudent scs = new ScheduleCourseStudent();
			//s = new Student(); //JAM�S HAGAN ESTO
			scs.setStudent(s);
			scs.setScore(0);
			list.add(scs);
			vacancy--;
			return true;
		}  else return false;
	}
	
	public ScheduleCourseStudent searchSCStudentById(String id){
		for (int i=0; i<list.size(); i++){
			if (list.get(i).getStudent().getId().equalsIgnoreCase(id)){
				return list.get(i);
			}
		}
		return null;
	}
	
	public String getStudentsReport(){
		String cad = "Reporte de alumnos\n==================\n";
		for (int i=0; i<list.size(); i++){
			cad += list.get(i).getStudent().getResume() + " - " + 
						list.get(i).getScore() + "\n";
		}
		return cad;
	}
	
	public ArrayList<ScheduleCourseStudent> getList() {
		return list;
	}
	public void setList(ArrayList<ScheduleCourseStudent> list) {
		this.list = list;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<String> getClassrooms() {
		return classrooms;
	}
	public void setClassrooms(ArrayList<String> classrooms) {
		this.classrooms = classrooms;
	}
	public ArrayList<Date> getDates() {
		return dates;
	}
	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	
}
