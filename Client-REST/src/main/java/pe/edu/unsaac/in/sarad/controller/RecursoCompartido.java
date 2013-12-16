/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbaldeon
 */
public class RecursoCompartido {
    
            public synchronized void espera(){
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ERController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

    
            public synchronized  void notifica(){
                this.notify();
            }
}
