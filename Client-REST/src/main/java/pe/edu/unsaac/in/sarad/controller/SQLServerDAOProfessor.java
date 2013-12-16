/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.unsaac.in.sarad.client.model.Professor;

/**
 *
 * @author jbaldeon
 */
public class SQLServerDAOProfessor implements DAOProfessor{

    @Override
    public void add(Professor p) {
        Connection conn = null;
        PreparedStatement  pstmt = null;
        try {
            //Paso 1: Registrar el driver
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Paso 2: Obtener la conexión
            String jdbcURL = "jdbc:sqlserver://inti.lab.inf.pucp.edu.pe:1433;"
                                        + "databaseName=inf282";
            String user = "inf282";
            String password = "inf282db";
            conn = DriverManager.getConnection(jdbcURL, user, password);
            //Paso 3: Preparar la sentencia
           pstmt = conn.prepareStatement("INSERT INTO Professor "
                   + "(DNI, Nombre, ApellidoPat, ApellidoMat, CodigoPUCP) "
                   + "VALUES (?, ?,?,?,?)");
            pstmt.setString(1, p.getDni());
            pstmt.setString(2, p.getName());
            pstmt.setString(3, p.getLastName());
            pstmt.setString(4, p.getSecondLastName());
            pstmt.setString(5, p.getId());
            //Paso 4: Se ejecuta la sentencia
           int res = pstmt.executeUpdate();
           if (res == 0) {
               throw new Exception();
           }
        } catch (Exception ex) {
            Logger.getLogger(SQLServerDAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Paso 5: (EL MAS IMPORTANTE) Cerrar los objetos de conexión
            if (pstmt != null) {                
                try{ pstmt.close();} catch(Exception e) {e.printStackTrace();}
            }
            if (conn != null) {                
                try{ conn.close();} catch(Exception e) {e.printStackTrace();}
            }            
        }
    }

    @Override
    public int update(Professor p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Professor> queryAll() {
        ArrayList<Professor> list = new ArrayList<Professor>();
        Connection conn = null;
        PreparedStatement  pstmt = null;
        ResultSet rs = null;
        try {
            //Paso 1: Registrar el driver
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Paso 2: Obtener la conexión
            String jdbcURL = "jdbc:sqlserver://inti.lab.inf.pucp.edu.pe:1433;"
                                        + "databaseName=inf282";
            String user = "inf282";
            String password = "inf282db";
            conn = DriverManager.getConnection(jdbcURL, user, password);
            //Paso 3: Preparar la sentencia
           pstmt = conn.prepareStatement("SELECT * FROM Professor");
            
            //Paso 4: Se ejecuta la sentencia
           rs = pstmt.executeQuery();
           while (rs.next()){
               Professor p = new Professor();
               p.setDni(rs.getString("DNI"));
               p.setName(rs.getString("Nombre"));
               p.setLastName(rs.getString("ApellidoPat"));
               p.setSecondLastName(rs.getString("ApellidoMat"));               
               p.setId(rs.getString("CodigoPUCP"));
               p.setSection("Informatica");
               list.add(p);
           }
        } catch (Exception ex) {
            Logger.getLogger(SQLServerDAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Paso 5: (EL MAS IMPORTANTE) Cerrar los objetos de conexión
            if (pstmt != null) {                
                try{ pstmt.close();} catch(Exception e) {e.printStackTrace();}
            }
            if (conn != null) {                
                try{ conn.close();} catch(Exception e) {e.printStackTrace();}
            }            
        }
        return list;
    }

    @Override
    public Professor queryById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
