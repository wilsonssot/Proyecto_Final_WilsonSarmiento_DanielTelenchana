/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import ClasesSecundarias.Coneccion;
import ClasesSecundarias.Metodos;
import ParaBDD.Clientes;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USER-12
 */
public class UsuariosIngreso extends javax.swing.JDialog {

    Coneccion cn = new Coneccion();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;
    String cedula, nombre, apellido, direccion, telefono;
    double sueldo;
    ArrayList listaCedulas = new ArrayList();

    /**
     * Creates new form ClientesIngreso
     */
    public UsuariosIngreso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        deshabilitarCancelar();

    }

    public void deshabilitarCancelar() {
        jButtonCancelar.setEnabled(false);

        if (!jTextField_NomUsu.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        } 
        if (!jTextField_ApeUsu.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        } 
        if (!jTextField_DirUsu.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_TelUsu.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_CedUsu.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }

//        if (res) {
//            jButtonCancelar.setEnabled(false);
//        } else {
//            jButtonCancelar.setEnabled(true);
//        }
    }

    public boolean existeCedula() throws SQLException {
        cn.Conectar();
        String usu = "";
        String cedula = jTextField_CedUsu.getText();
        String query = "select * from empleados where ced_emp = " + cedula + " ";
        st = cn.getConexion().createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            usu = rs.getString("CED_EMP");
        }
        if (cedula.equals(usu)) {
            JOptionPane.showMessageDialog(null, "Empleado ya EXISTE","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public boolean validarDatos() throws SQLException {
        if (!Metodos.verificadorCédula(jTextField_CedUsu.getText())) {
            JOptionPane.showMessageDialog(null, "Cédula Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (jTextField_NomUsu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_ApeUsu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el apellido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_DirUsu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la dirección", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_SueUsu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el sueldo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_TelUsu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese número celular", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (existeCedula()) {
            return true;
        } else {
            return false;
        }

    }

    public void limpiarDatos() {
        jTextField_CedUsu.setText("");
        jTextField_ApeUsu.setText("");
        jTextField_DirUsu.setText("");
        jTextField_NomUsu.setText("");
        jTextField_TelUsu.setText("");
    }

    public void setearVariables() {
        cedula = jTextField_CedUsu.getText();
        nombre = jTextField_NomUsu.getText();
        apellido = jTextField_ApeUsu.getText();
        direccion = jTextField_DirUsu.getText();
        sueldo = Double.valueOf(jTextField_SueUsu.getText());
        telefono = jTextField_TelUsu.getText();
    }

    public void ingresoUsuariosBase() throws SQLException {
        if (validarDatos()) {
            setearVariables();
            cn.Conectar();
            pst = cn.getConexion().prepareStatement("insert into empleados(CED_EMP,NOM_EMP,APE_EMP,DIR_EMP,SUE_EMP,TEL_EMP) values (?,?,?,?,?,?)");
            pst.setString(1, cedula);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, direccion);
            pst.setDouble(5, sueldo);
            pst.setString(6, telefono);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            limpiarDatos();
            deshabilitarCancelar();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Vuelva a ingresar la cédula", "Cédula Errónea", JOptionPane.ERROR_MESSAGE);
            jTextField_CedUsu.setText("");
        }
        pst.close();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_CedUsu = new javax.swing.JTextField();
        jTextField_NomUsu = new javax.swing.JTextField();
        jTextField_ApeUsu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_DirUsu = new javax.swing.JTextField();
        jTextField_TelUsu = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField_SueUsu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("AGREGAR NUEVO USUARIO"));

        jLabel1.setText("Cèdula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jTextField_CedUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CedUsuKeyTyped(evt);
            }
        });

        jTextField_NomUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NomUsuKeyTyped(evt);
            }
        });

        jTextField_ApeUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ApeUsuKeyTyped(evt);
            }
        });

        jLabel5.setText("Telèfono:");

        jLabel6.setText("Direccion:");

        jTextField_DirUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DirUsuKeyTyped(evt);
            }
        });

        jTextField_TelUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TelUsuKeyTyped(evt);
            }
        });

        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Sueldo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_CedUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_NomUsu)
                            .addComponent(jTextField_ApeUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_DirUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(jTextField_TelUsu)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_SueUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_CedUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_SueUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_NomUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_DirUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_ApeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_TelUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Guardar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        try {
            // TODO add your handling code here:
            if (validarDatos()) {
                ingresoUsuariosBase();
            } else {

            }
        } catch (SQLException ex) {

            //Logger.getLogger(ClientesIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jTextField_NomUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NomUsuKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_NomUsu);
    }//GEN-LAST:event_jTextField_NomUsuKeyTyped

    private void jTextField_ApeUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ApeUsuKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_ApeUsu);
    }//GEN-LAST:event_jTextField_ApeUsuKeyTyped

    private void jTextField_DirUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DirUsuKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_DirUsu);
    }//GEN-LAST:event_jTextField_DirUsuKeyTyped

    private void jTextField_TelUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TelUsuKeyTyped
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextField_TelUsu);
    }//GEN-LAST:event_jTextField_TelUsuKeyTyped

    private void jTextField_CedUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CedUsuKeyTyped
        // TODO add your handling code here:
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextField_CedUsu);
    }//GEN-LAST:event_jTextField_CedUsuKeyTyped

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarDatos();
        deshabilitarCancelar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuariosIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuariosIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuariosIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuariosIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsuariosIngreso dialog = new UsuariosIngreso(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_ApeUsu;
    private javax.swing.JTextField jTextField_CedUsu;
    private javax.swing.JTextField jTextField_DirUsu;
    private javax.swing.JTextField jTextField_NomUsu;
    private javax.swing.JTextField jTextField_SueUsu;
    private javax.swing.JTextField jTextField_TelUsu;
    // End of variables declaration//GEN-END:variables
}
