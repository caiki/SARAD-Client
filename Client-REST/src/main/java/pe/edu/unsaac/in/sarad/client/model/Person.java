package pe.edu.unsaac.in.sarad.client.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Person {
	
	protected String dni;
	protected String name;
	protected String lastName;	
	protected String secondLastName;
	protected String address;
	protected String telephoneNumber;
	protected Date birthday;

	public abstract  String getResume();
	/*
	{
		return dni + " - " + name + " " +lastName + " "  + secondLastName; 
	}
	*/
	public Person(){		
	}
	public Person(String dni){
		this.dni = dni;
	}
	public Person(String dni, String name){
		this.dni=dni; this.name = name;
	}
	
                @XmlAttribute
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
                @XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
                @XmlElement
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
                @XmlElement
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
                @XmlElement
	public String getAddress() {
		return address;
	}                
	public void setAddress(String address) {
		this.address = address;
	}
                @XmlElement
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
                @XmlElement
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}

