/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.client.er;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import pe.edu.unsaac.in.sarad.controller.DBConfig;
import pe.edu.unsaac.in.sarad.client.model.Professor;
import pe.edu.unsaac.in.sarad.client.ui.MainWindow;


/**
 *
 * @author jbaldeon
 */
public class Main {
    static MainWindow mw;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
                
        
        //Properties prop = new Properties();
        MyProperties prop = MyProperties.getInstance();
        
        prop.load(new FileInputStream("C://Users//CARLOS1//Documents//GitHub//SARAD-Client//Client-UI//src//main//java//MyProperties.properties"));
        
        DBConfig.dbType = Integer.parseInt(prop.getProperty("dbType"));
        DBConfig.dbName = prop.getProperty("dbName");
        DBConfig.dbUser = prop.getProperty("dbUser");
        DBConfig.dbPassword = prop.getProperty("dbPassword");
        
        prop.setLanguage(prop.getProperty("language"));
        System.out.println(prop.getLanguage());
        
        //Leemos un XML
        File file = new File("profesor.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Professor.class);
        
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Professor p = (Professor) jaxbUnmarshaller.unmarshal(file);
        System.out.println(p.getDni() + "-" + p.getName() + " " + p.getLastName());
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        mw = new MainWindow();
        //Puedes usar cualquiera de los dos
        
        /*MyThread myThread = new MyThread();
        myThread.setMW(mw);
        myThread.start();
        */
        
        Thread myThread = new Thread(new MyRunnable(mw));
        myThread.start();
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
                mw.setVisible(true);
            }
        });
    }
}
