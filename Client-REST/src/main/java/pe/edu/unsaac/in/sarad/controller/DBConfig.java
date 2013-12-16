/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jbaldeon
 */
public class DBConfig {
    public static int dbType;
    public static String dbName;
    public static String dbUser;
    public static String dbPassword;
    private Connection conn;
    
    public DBConfig() throws SQLException{
        conn = DriverManager.getConnection(
                    "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/" + DBConfig.dbName, //inf282g9,
                    DBConfig.dbUser, DBConfig.dbPassword);
    }
    
    public Connection getConnection(){
        return conn;
    }
}
