/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unsaac.in.sarad.client.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import pe.edu.unsaac.in.sarad.controller.ERController;
import pe.edu.unsaac.in.sarad.controller.RecursoCompartido;
import pe.edu.unsaac.in.sarad.client.model.Professor;

/**
 *
 * @author jbaldeon
 */
public class ProfessorW extends javax.swing.JInternalFrame {
    RecursoCompartido rs = new RecursoCompartido();
    /**
     * Creates new form ProfessorW
     */
    public ProfessorW() {
        initComponents();
        tblProfessor.setModel(myModel);
        //myModel.fireTableChanged(null);
        
        Thread tableThread = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true){
                        synchronized(this){
                            rs.espera();                         
                         }
                         refreshTable();
                   /* try {
                        //Thread.sleep(5000);
                        }    
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProfessorW.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    */                   
                }
            }            
        });
        
        tableThread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtSLastName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtTNumber = new javax.swing.JTextField();
        lblPhoto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAddPhoto = new javax.swing.JButton();
        txtPhotoFile = new javax.swing.JTextField();
        txtIdPUCP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnApply = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("DNI");

        txtDNI.setName("txtDNI"); // NOI18N

        jLabel2.setText("Nombre");

        txtName.setName("txtName"); // NOI18N

        jLabel3.setText("Apellido paterno");

        txtLastName.setName("txtLastName"); // NOI18N

        txtSLastName.setName("txtSLastName"); // NOI18N

        txtAddress.setName("txtAddress"); // NOI18N

        txtTNumber.setName("txtTNumber"); // NOI18N

        lblPhoto.setText("Aquí va la foto");
        lblPhoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblPhoto.setName("lblFoto"); // NOI18N

        jLabel5.setText("Suba su foto");

        btnAddPhoto.setText("Subir");
        btnAddPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhotoActionPerformed(evt);
            }
        });

        txtPhotoFile.setName("txtPhotoFile"); // NOI18N

        txtIdPUCP.setName("txtIdPUCP"); // NOI18N

        jLabel6.setText("Apellido materno");

        jLabel7.setText("Dirección");

        jLabel8.setText("Teléfono");

        jLabel9.setText("Código PUCP");

        btnApply.setText("Agregar");
        btnApply.setName("btnApply"); // NOI18N
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.setName("btnDelete"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de profesores"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfessorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProfessor);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDNI)
                                        .addComponent(txtLastName)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSLastName)
                                        .addComponent(txtAddress)
                                        .addComponent(txtTNumber)
                                        .addComponent(txtIdPUCP))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAddPhoto))
                                .addComponent(txtPhotoFile))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnAddPhoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdPUCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhotoFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApply)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        //JOptionPane.showMessageDialog(this, txtName.getText());
        
        Professor p = new Professor(txtDNI.getText(), txtName.getText(), 
                txtLastName.getText(), txtSLastName.getText(), txtAddress.getText(), 
                txtTNumber.getText(), null, txtIdPUCP.getText(), "Informática");
        ERController.addProfessor(p, rs);        
        //refreshTable();
        
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnAddPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, file.getAbsolutePath());
            lblPhoto.setIcon(new ImageIcon(file.getAbsolutePath()));            
        }
    
    }//GEN-LAST:event_btnAddPhotoActionPerformed

    private void tblProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfessorMouseClicked
        int rowSel = tblProfessor.getSelectedRow();
        Professor p = professorList.get(rowSel);
        txtDNI.setText(p.getDni());
        txtName.setText(p.getName());
        txtLastName.setText(p.getLastName());
        
    }//GEN-LAST:event_tblProfessorMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Professor p = new Professor(txtDNI.getText(), txtName.getText(), 
                txtLastName.getText(), txtSLastName.getText(), txtAddress.getText(), 
                txtTNumber.getText(), null, txtIdPUCP.getText(), "Informática");
        ERController.updateProfessor(p);
        refreshTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    ProfessorTableModel myModel = new ProfessorTableModel();
    ArrayList<Professor> professorList = ERController.getAllProfessors();
    
    public void refreshTable(){
        professorList = ERController.getAllProfessors();
        myModel.fireTableChanged(null);
    }
            
    class ProfessorTableModel extends AbstractTableModel{
        public static final int COLS = 3;
        @Override
        public int getRowCount() {
            return professorList.size();
        }

        @Override
        public int getColumnCount() {
            return COLS;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String value = "";
            switch(columnIndex){
                case 0: value = professorList.get(rowIndex).getId(); break;
                case 1: value = professorList.get(rowIndex).getName() + " " +
                                            professorList.get(rowIndex).getLastName(); break;
                case 2: value = professorList.get(rowIndex).getSection(); break;                        
            }
            return value;
        }
        
        public String getColumnName(int col){
            switch(col){
                case 0: return "Código"; 
                case 1: return "Nombre completo";
                case 2: return "Sección";
                default: return "";   
            }
        }
        
    }
         
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPhoto;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtIdPUCP;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhotoFile;
    private javax.swing.JTextField txtSLastName;
    private javax.swing.JTextField txtTNumber;
    // End of variables declaration//GEN-END:variables
}
