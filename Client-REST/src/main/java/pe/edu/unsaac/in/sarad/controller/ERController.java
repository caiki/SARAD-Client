package pe.edu.unsaac.in.sarad.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import pe.edu.unsaac.in.sarad.client.model.Professor;

public class ERController {
	static ArrayList<Professor> professorList = new ArrayList<Professor>();
        
            
            
                public static void saveAllDataInFiles(){
                    try {
                        FileOutputStream output = new FileOutputStream("Data.bin"); 
                        ObjectOutputStream objOutput = new ObjectOutputStream(output);
                        objOutput.writeObject(professorList);
                    } catch(Exception e){
                        e.printStackTrace();
                    }    
                    
                }
                
                public static ArrayList<Professor> getAllProfessors(){
                    DAOFactory daoFactory = DAOFactory
                                .getDAOFactory(DBConfig.dbType);
                                 //.getDAOFactory(DAOFactory.MYSQL);
                    DAOProfessor daoProfessor = daoFactory.getDAOProfessor();
                    professorList = daoProfessor.queryAll();
                    return professorList;
                }
                
	public static void addProfessor(Professor p, RecursoCompartido rs){
		//professorList.add(p);
                                    //saveAllDataInFiles();
                         DAOFactory daoFactory = DAOFactory
                                 .getDAOFactory(DBConfig.dbType);
                         DAOProfessor daoProfessor = daoFactory.getDAOProfessor();
                         daoProfessor.add(p);
                         //The Marshaller class is responsible for governing the process of serializing Java content trees back into XML data
                         //Para grabar como un xml
                        try {                         
                         File file = new File("profesor.xml");
                         JAXBContext jaxbContext = JAXBContext.newInstance(Professor.class);
                         Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                         jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                         
                         jaxbMarshaller.marshal(p, file);
                         jaxbMarshaller.marshal(p, System.out);
                        } catch (JAXBException ex) {
                            Logger.getLogger(ERController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        ERController er = new ERController();
                        rs.notifica();
	}
	
	public static Professor searchProfessorByIdPUCP (String idPUCP){
		Professor p = null;
		for (int i=0; i < professorList.size(); i++){
			if (professorList.get(i).getId().equalsIgnoreCase(idPUCP)){
				return professorList.get(i);
			}
		}
		return p;
	}
        
                public static void updateProfessor (Professor p) {
                    for (int i=0; i < professorList.size(); i++){
                        if (professorList.get(i).getDni().equalsIgnoreCase(p.getDni())){
                            professorList.set(i, p);
                        }
                    }                    
                }
}
