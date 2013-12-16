/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.controller;

/**
 *
 * @author jbaldeon
 */
public class SQLServerDAOFactory extends DAOFactory {

    @Override
    public DAOProfessor getDAOProfessor() {
        return new SQLServerDAOProfessor();
    }
    
}
