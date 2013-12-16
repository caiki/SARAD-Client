/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.controller;

import java.util.ArrayList;
import pe.edu.unsaac.in.sarad.client.model.Professor;

/**
 *
 * @author jbaldeon
 */
public interface DAOProfessor {
    void add(Professor p);
    int update(Professor p);
    int delete (int id);
    ArrayList<Professor> queryAll();
    Professor queryById(int id);
}
