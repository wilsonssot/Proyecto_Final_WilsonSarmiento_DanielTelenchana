/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import ClasesSecundarias.Coneccion;
import ClasesSecundarias.Metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class PoductosIngreso extends javax.swing.JDialog {

    Coneccion cn = new Coneccion();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;
    String codigo, nombre, marca, modelo;
    double talla, precio, stock;
    ArrayList listaProductos = new ArrayList();
    /**
     * Creates new form PoductosIngreso
     */
    public PoductosIngreso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
     public void deshabilitarCancelar() {
        jButtonCancelar.setEnabled(false);

        if (!jTextField_Nom_Pro.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_Marca_Pro.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_Modelo_Pro.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_Talla_Pro.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_Pre_Pro.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }
        if (!jTextField_Stock_Pro.getText().equals("")) {
            jButtonCancelar.setEnabled(true);
        }

//        if (res) {
//            jButtonCancelar.setEnabled(false);
//        } else {
//            jButtonCancelar.setEnabled(true);
//        }
    }

    public boolean existeProducto() throws SQLException {
        cn.Conectar();
        String usu = "";
        String codigo = jTextField_Cod_Pro.getText();
        String query = "select * from producto_calzado where cod_pro = " + codigo + " ";
        st = cn.getConexion().createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            usu = rs.getString("COD_PRO");
        }
        if (codigo.equals(usu)) {
            JOptionPane.showMessageDialog(null, "Producto ya EXISTE", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public boolean validarDatos() throws SQLException {

        if (jTextField_Nom_Pro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_Marca_Pro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la marca del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_Modelo_Pro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el modelo del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_Talla_Pro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la talla del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_Pre_Pro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el precio del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextField_Stock_Pro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el stock del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (existeProducto()) {
            return true;
        } else {
            return false;
        }

    }

    public void limpiarDatos() {
        jTextField_Cod_Pro.setText("");
        jTextField_Nom_Pro.setText("");
        jTextField_Marca_Pro.setText("");
        jTextField_Modelo_Pro.setText("");
        jTextField_Talla_Pro.setText("");
        jTextField_Pre_Pro.setText("");
        jTextField_Stock_Pro.setText("");
    }

    public void setearVariables() {
        codigo = jTextField_Cod_Pro.getText();
        nombre = jTextField_Nom_Pro.getText();
        marca = jTextField_Marca_Pro.getText();
        modelo = jTextField_Modelo_Pro.getText();
        talla = Double.valueOf(jTextField_Talla_Pro.getText());
        precio = Double.valueOf(jTextField_Pre_Pro.getText());
        stock = Double.valueOf(jTextField_Stock_Pro.getText());
    }

    public void ingresoProductosBase() throws SQLException {
        if (validarDatos()) {
            setearVariables();
            cn.Conectar();
            pst = cn.getConexion().prepareStatement("insert into producto_calzado(COD_PRO,NOM_PRO,MAR_PRO,MOD_PRO,COD_TALL_P,PRE_PRO,EXISTENCIA) values (?,?,?,?,?,?,?)");
            pst.setString(1, codigo);
            pst.setString(2, nombre);
            pst.setString(3, marca);
            pst.setString(4, modelo);
            pst.setDouble(5, talla);
            pst.setDouble(6, precio);
            pst.setDouble(7, stock);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            limpiarDatos();
            deshabilitarCancelar();
            this.dispose();
        } else {
           JOptionPane.showMessageDialog(null, "");
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
        jTextField_Cod_Pro = new javax.swing.JTextField();
        jTextField_Nom_Pro = new javax.swing.JTextField();
        jTextField_Marca_Pro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Pre_Pro = new javax.swing.JTextField();
        jTextField_Stock_Pro = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Talla_Pro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Modelo_Pro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("AGREGAR NUEVO PRODUCTO"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Marca:");

        jTextField_Cod_Pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Cod_ProKeyTyped(evt);
            }
        });

        jTextField_Nom_Pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Nom_ProKeyTyped(evt);
            }
        });

        jTextField_Marca_Pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Marca_ProKeyTyped(evt);
            }
        });

        jLabel5.setText("Stock:");

        jLabel6.setText("Precio:");

        jTextField_Pre_Pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Pre_ProKeyTyped(evt);
            }
        });

        jTextField_Stock_Pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Stock_ProKeyTyped(evt);
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

        jLabel4.setText("Talla:");

        jTextField_Talla_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Talla_ProActionPerformed(evt);
            }
        });

        jLabel7.setText("Modelo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Cod_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Nom_Pro)
                            .addComponent(jTextField_Marca_Pro, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jTextField_Modelo_Pro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Talla_Pro, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jTextField_Stock_Pro)
                            .addComponent(jTextField_Pre_Pro))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_Cod_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nom_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Talla_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Marca_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_Pre_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Stock_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jTextField_Modelo_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Guardar)
                    .addComponent(jButtonCancelar)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_Cod_ProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Cod_ProKeyTyped
        // TODO add your handling code here:
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextField_Cod_Pro);
    }//GEN-LAST:event_jTextField_Cod_ProKeyTyped

    private void jTextField_Nom_ProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Nom_ProKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_Nom_Pro);
    }//GEN-LAST:event_jTextField_Nom_ProKeyTyped

    private void jTextField_Marca_ProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Marca_ProKeyTyped
        deshabilitarCancelar();
        Metodos.validarLetras(evt, jTextField_Marca_Pro);
    }//GEN-LAST:event_jTextField_Marca_ProKeyTyped

    private void jTextField_Pre_ProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Pre_ProKeyTyped
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextField_Pre_Pro);
    }//GEN-LAST:event_jTextField_Pre_ProKeyTyped

    private void jTextField_Stock_ProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Stock_ProKeyTyped
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextField_Stock_Pro);
    }//GEN-LAST:event_jTextField_Stock_ProKeyTyped

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        try {
            // TODO add your handling code here:
            if (validarDatos()) {
                ingresoProductosBase();
            } else {

            }
        } catch (SQLException ex) {

            //Logger.getLogger(ClientesIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarDatos();
        deshabilitarCancelar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextField_Talla_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Talla_ProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Talla_ProActionPerformed

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
            java.util.logging.Logger.getLogger(PoductosIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PoductosIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PoductosIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PoductosIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PoductosIngreso dialog = new PoductosIngreso(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_Cod_Pro;
    private javax.swing.JTextField jTextField_Marca_Pro;
    private javax.swing.JTextField jTextField_Modelo_Pro;
    private javax.swing.JTextField jTextField_Nom_Pro;
    private javax.swing.JTextField jTextField_Pre_Pro;
    private javax.swing.JTextField jTextField_Stock_Pro;
    private javax.swing.JTextField jTextField_Talla_Pro;
    // End of variables declaration//GEN-END:variables
}
