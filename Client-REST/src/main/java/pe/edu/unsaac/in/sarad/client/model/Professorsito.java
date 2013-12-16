
package pe.edu.unsaac.in.sarad.client.model;

import com.google.gson.Gson;
import java.io.Serializable;
//import org.json;

public class Professorsito implements Serializable{
    protected String p_name;
    protected String p_code;
    
    public String getCode() {
        return p_code;
    }

    public void setCode(String value) {
        this.p_code = value;
    }

    public String getName() {
        return p_name;
    }

    public void setName(String value) {
        this.p_name = value;
    }
//    public JsonElement prof_toJson(Professorsito Pprof){
//       
//    Gson gson = new Gson();        
//    //System.out.println(gson.toJson(prof));
//        return gson.toJsonTree(Pprof);
//    }
    public Professorsito prof_fromJson(String valuejson){
    Gson gson = new Gson();
    Professorsito prof1 = (Professorsito) gson.fromJson(valuejson, Professorsito.class);    
    return prof1;
   }
 /*
    public static void main(String[] args) {
    String json = "{\"p_name\":\"Unai\",\"p_code\":28}";
    Professorsito prof = new Professorsito();
    prof =prof.prof_fromJson(json);
    System.out.println("prof.getCode()>"+prof.getCode()+"prof.getName()>"+prof.getName());
    
//    JsonElement je= prof.prof_toJson(prof);
//    je.getAsString();
    }*/
}
//Consulta sera necesario que cree una clase persona que heredara a otras
//Crear un mediador
