package pe.edu.unsaac.in.sarad.client.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor extends Person implements Printable, Serializable{
	private String id;
	private String section;
	
                 public Professor(){                     
                 }
                 
	public String getResume() {
		return id + " - "  + name+ " " + lastName + " - " + section;
	}
	
	
	public Professor(String dni, String name,String lastName, String sLastName,
								String address, String tNumber, Date birthday,
								String id, String section) {
		super(dni, name);
		this.lastName = lastName;
		super.secondLastName = sLastName;
		this.address = address;
		telephoneNumber = tNumber;
		super.birthday = birthday;
		this.id = id;
		this.section = section;
	}
                  @XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
                 
                  @XmlElement
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}


	@Override
	public void printIt() {
		System.out.println("Codigo:\t" + id + " \nNombre:\t" +  name);
		
	}
	
}
