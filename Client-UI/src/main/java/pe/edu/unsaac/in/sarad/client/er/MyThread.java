/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.client.er;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import pe.edu.unsaac.in.sarad.client.ui.MainWindow;

/**
 *
 * @author jbaldeon
 */
public class MyThread extends Thread{
    MainWindow mWindow;
    
    public MyThread(){        
    }
    
    public void setMW(MainWindow mw){
        mWindow = mw;
    }
    
    public void run(){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        
        while (true){
            date = new Date();        
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            mWindow.setTitle(sdf.format(date));
        }
    }
}
