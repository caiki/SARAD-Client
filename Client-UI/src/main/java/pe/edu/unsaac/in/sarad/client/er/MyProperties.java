/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.client.er;

import java.util.Properties;

/**
 *
 * @author jbaldeon
 */
public class MyProperties extends Properties{
        private static MyProperties obj;
        private String language;
        
        private MyProperties(){
            language = "SP_PE";
        }//This is the language 
        public static MyProperties getInstance(){
            if (obj == null){
                obj = new MyProperties();
                return obj;
            } else
                return obj;
        }
        public String getLanguage(){
            return language;
        }
        public void setLanguage(String l){
            language = l;
        }
}
