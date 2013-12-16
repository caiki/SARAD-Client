/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.unsaac.in.sarad.client.model.Professor;

/**
 *
 * @author jbaldeon
 */
public class MySQLDAOProfessor implements DAOProfessor {

    @Override
    public void add(Professor p) {
        //Pasos para la conexión a la BD
        Connection conn = null;
        PreparedStatement pstmt = null;
        //int result  = 0;
        try {
            //Paso 1: Registramos el driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Paso 2: Obtenemos la conexión            
            conn = new DBConfig().getConnection();
            //Paso 3: Preparamos la sentencia
            pstmt = conn.prepareStatement(
                    "INSERT INTO Professor(id, name, lastName,secondLastName, address, section)"+
                    "VALUES(?,?,?,?,?,?)");
            pstmt.setString(1, p.getId());
            pstmt.setString(2, p.getName());
            pstmt.setString(3, p.getLastName());
            pstmt.setString(4, p.getSecondLastName());
            pstmt.setString(5, p.getAddress());
            pstmt.setString(6, p.getSection());
            //Paso 4: Ejecutar la sentencia
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {//Paso 5: Cerramos la conexión
            conn.close(); } catch(Exception e) {e.printStackTrace();}
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
        //Pasos para la conexión a la BD
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs  = null;
        try {
            //Paso 1: Registramos el driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Paso 2: Obtenemos la conexión
            conn = DriverManager.getConnection(
                    "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g9",
                    "inf282g9", "madrugada");
            //Paso 3: Preparamos la sentencia
            pstmt = conn.prepareStatement(
                    "SELECT * FROM Professor");
            //Paso 4: Ejecutar la sentencia            
            rs = pstmt.executeQuery();
            //Paso 4 y medio: Evaluamos los resultados
            while (rs.next()){
                String id = rs.getString("ID");
                String name = rs.getString("name");
                String lName = rs.getString("lastName");
                String slName = rs.getString("secondLastName");
                String address = rs.getString("address");
                String section = rs.getString("section");
                Professor p = new Professor("11111111", name, lName, slName, 
                            address, "696969", null, id, section);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {//Paso 5: Cerramos la conexión
            conn.close(); } catch(Exception e) {e.printStackTrace();}
        }
        return list;
    }

    @Override
    public Professor queryById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
