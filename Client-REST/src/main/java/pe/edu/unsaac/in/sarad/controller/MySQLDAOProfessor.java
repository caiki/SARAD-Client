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
                    "INSERT INTO Docente (id, name, Categoria,Nombre,Especialidad)"+
                    "VALUES(?,?,?,?)");
            pstmt.setString(1, p.getId());
            pstmt.setString(2, p.getCategoria());
            pstmt.setString(3, p.getName());
            pstmt.setString(4, p.getEspecialidad());
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
                    "jdbc:mysql://diagonal.com.pe:3306/diagorfe_sarad",
                    "diagorfe_ingsoft", "$arad_1ng$0ft");
            //Paso 3: Preparamos la sentencia
            pstmt = conn.prepareStatement(
                    "SELECT * FROM Docente");
            //Paso 4: Ejecutar la sentencia            
            rs = pstmt.executeQuery();
            //Paso 4 y medio: Evaluamos los resultados
            while (rs.next()){
                String id = rs.getString("idDocente");
                String Categoria = rs.getString("Categoria");
                String Name = rs.getString("Nombre");
                String Especialidad = rs.getString("Especialidad");
                Professor p = new Professor(id, Categoria, Name, Especialidad);
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
