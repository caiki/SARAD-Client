package pe.edu.unsaac.in.sarad.client.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor  implements Printable, Serializable{
	private String id;
        private String name;
        private String especialidad;
        private String categoria;
	
        public Professor(){                     
                 }
                 
	public String getResume() {
		return id + " - "  + name+ " " + especialidad + " - " + categoria;
	}
	
	
	public Professor(String pid, String pname,String pespecialidad, String pcategoria) {
		this.id = pid;
		this.name = pname;
                this.especialidad = pespecialidad;
                this.categoria = pcategoria;
	}
        @XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
                 
        @XmlElement
	public String getName() {
		return name;
	}
	public void setName(String pname) {
		this.name = pname;
	}
        
        @XmlElement
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String pespecialidad) {
		this.especialidad = pespecialidad;
	}
        
        @XmlElement
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String pcategoria) {
		this.categoria = pcategoria;
	}
        
	@Override
	public void printIt() {
		System.out.println("Codigo:\t" + id + " \nNombre:\t" +  name);
		
	}
	
}
