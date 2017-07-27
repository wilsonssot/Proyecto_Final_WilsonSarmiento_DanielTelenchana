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
public class ClientesIngreso extends javax.swing.JDialog {

    Coneccion cn = new Coneccion();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;
    String cedula, nombre, apellido, direccion, telefono;
    ArrayList listaCedulas = new ArrayList();

    /**
     * Creates new form ClientesIngreso
     */
    public ClientesIngreso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        deshabilitarCancelar();

    }

    public void deshabilitarCancelar() {
        jButtonCancelar.setEnabled(false);

        if (!jTextField_NomCli.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        } 
        if (!jTextField_ApeCli.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        } 
        if (!jTextField_DirCli.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_TelCli.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextFieldCedulaCli.getText().equals("")) {
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
        String cedula = jTextFieldCedulaCli.getText();
        String query = "select * from clientes where ced_cli = " + cedula + " ";
        st = cn.getConexion().createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            usu = rs.getString("CED_CLI");
        }
        if (cedula.equals(usu)) {
            JOptionPane.showMessageDialog(null, "Cliente ya EXISTE","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public boolean validarDatos() throws SQLException {
        if (!Metodos.verificadorCédula(jTextFieldCedulaCli.getText())) {
            JOptionPane.showMessageDialog(null, "Cédula Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (jTextField_NomCli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_ApeCli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el apellido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_DirCli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la dirección", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_TelCli.getText().equals("")) {
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
        jTextFieldCedulaCli.setText("");
        jTextField_ApeCli.setText("");
        jTextField_DirCli.setText("");
        jTextField_NomCli.setText("");
        jTextField_TelCli.setText("");
    }

    public void setearVariables() {
        cedula = jTextFieldCedulaCli.getText();
        nombre = jTextField_NomCli.getText();
        apellido = jTextField_ApeCli.getText();
        direccion = jTextField_DirCli.getText();
        telefono = jTextField_TelCli.getText();
    }

    public void ingresoClientesBase() throws SQLException {
        if (validarDatos()) {
            setearVariables();
            cn.Conectar();
            pst = cn.getConexion().prepareStatement("insert into clientes(CED_CLI,NOM_CLI,APE_CLI,DIR_CLI,TEL_CLI) values (?,?,?,?,?)");
            pst.setString(1, cedula);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, direccion);
            pst.setString(5, telefono);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            limpiarDatos();
            deshabilitarCancelar();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Vuelva a ingresar la cédula", "Cédula Errónea", JOptionPane.ERROR_MESSAGE);
            jTextFieldCedulaCli.setText("");
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
        jTextFieldCedulaCli = new javax.swing.JTextField();
        jTextField_NomCli = new javax.swing.JTextField();
        jTextField_ApeCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_DirCli = new javax.swing.JTextField();
        jTextField_TelCli = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("AGREGAR NUEVO CLIENTE"));

        jLabel1.setText("Cèdula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jTextFieldCedulaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCedulaCliKeyTyped(evt);
            }
        });

        jTextField_NomCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NomCliKeyTyped(evt);
            }
        });

        jTextField_ApeCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ApeCliKeyTyped(evt);
            }
        });

        jLabel5.setText("Telèfono:");

        jLabel6.setText("Direccion:");

        jTextField_DirCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DirCliKeyTyped(evt);
            }
        });

        jTextField_TelCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TelCliKeyTyped(evt);
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
                            .addComponent(jTextFieldCedulaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_NomCli)
                            .addComponent(jTextField_ApeCli, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_DirCli, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(jTextField_TelCli)))
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
                    .addComponent(jTextFieldCedulaCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_NomCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_DirCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_ApeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_TelCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                ingresoClientesBase();
            } else {

            }
        } catch (SQLException ex) {

            //Logger.getLogger(ClientesIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jTextField_NomCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NomCliKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_NomCli);
    }//GEN-LAST:event_jTextField_NomCliKeyTyped

    private void jTextField_ApeCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ApeCliKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_ApeCli);
    }//GEN-LAST:event_jTextField_ApeCliKeyTyped

    private void jTextField_DirCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DirCliKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_DirCli);
    }//GEN-LAST:event_jTextField_DirCliKeyTyped

    private void jTextField_TelCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TelCliKeyTyped
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextField_TelCli);
    }//GEN-LAST:event_jTextField_TelCliKeyTyped

    private void jTextFieldCedulaCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCedulaCliKeyTyped
        // TODO add your handling code here:
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextFieldCedulaCli);
    }//GEN-LAST:event_jTextFieldCedulaCliKeyTyped

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
            java.util.logging.Logger.getLogger(ClientesIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClientesIngreso dialog = new ClientesIngreso(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCedulaCli;
    private javax.swing.JTextField jTextField_ApeCli;
    private javax.swing.JTextField jTextField_DirCli;
    private javax.swing.JTextField jTextField_NomCli;
    private javax.swing.JTextField jTextField_TelCli;
    // End of variables declaration//GEN-END:variables
}
