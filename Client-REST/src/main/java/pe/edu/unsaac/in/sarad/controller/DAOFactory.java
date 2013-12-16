/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.controller;

/**
 *
 * @author jbaldeon
 */
public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public static final int SQLServer = 2;
    public static DAOFactory getDAOFactory(int dbType) {
        DAOFactory daoFactory = null;
        switch(dbType) {
            case MYSQL: daoFactory = new MySqlDAOFactory(); break;
            case SQLServer: daoFactory = new SQLServerDAOFactory(); break;
        }
        return daoFactory;
    }
    public abstract DAOProfessor getDAOProfessor();
}
