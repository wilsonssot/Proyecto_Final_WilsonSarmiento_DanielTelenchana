/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Acceso.Login;
import ClasesSecundarias.Usuario;
import ParaBDD.Clientes;
import ParaBDD.Inventario;
import ParaBDD.Proveedores;
import ParaBDD.Usuarios;
import java.awt.HeadlessException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author USER-11
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Clientes = new javax.swing.JButton();
        btn_Ventas = new javax.swing.JButton();
        btn_Inventory = new javax.swing.JButton();
        btn_Admin = new javax.swing.JButton();
        btn_Proveedores = new javax.swing.JButton();
        btn_Pedidos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btn_Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_clientes_1.png"))); // NOI18N
        btn_Clientes.setText("CLIENTES");
        btn_Clientes.setBorderPainted(false);
        btn_Clientes.setContentAreaFilled(false);
        btn_Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Clientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Clientes.setIconTextGap(-3);
        btn_Clientes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_clientes_3.png"))); // NOI18N
        btn_Clientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_clientes_2.png"))); // NOI18N
        btn_Clientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Clientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClientesActionPerformed(evt);
            }
        });

        btn_Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_vender_2.png"))); // NOI18N
        btn_Ventas.setText("VENTAS");
        btn_Ventas.setBorderPainted(false);
        btn_Ventas.setContentAreaFilled(false);
        btn_Ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Ventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Ventas.setIconTextGap(-3);
        btn_Ventas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_vender_3.png"))); // NOI18N
        btn_Ventas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_vender_1.png"))); // NOI18N
        btn_Ventas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VentasActionPerformed(evt);
            }
        });

        btn_Inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_inventario_2.png"))); // NOI18N
        btn_Inventory.setText("INVENTARIO");
        btn_Inventory.setBorderPainted(false);
        btn_Inventory.setContentAreaFilled(false);
        btn_Inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Inventory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Inventory.setIconTextGap(-3);
        btn_Inventory.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_inventario_3.png"))); // NOI18N
        btn_Inventory.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_inventario_1.png"))); // NOI18N
        btn_Inventory.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Inventory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InventoryActionPerformed(evt);
            }
        });

        btn_Admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_2.png"))); // NOI18N
        btn_Admin.setText("ADMINISTRADOR");
        btn_Admin.setActionCommand("JButtonAdm");
        btn_Admin.setBorderPainted(false);
        btn_Admin.setContentAreaFilled(false);
        btn_Admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Admin.setIconTextGap(-3);
        btn_Admin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_3.png"))); // NOI18N
        btn_Admin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_1.png"))); // NOI18N
        btn_Admin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdminActionPerformed(evt);
            }
        });

        btn_Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_2.png"))); // NOI18N
        btn_Proveedores.setText("PROVEEDORES");
        btn_Proveedores.setActionCommand("JButtonAdm");
        btn_Proveedores.setBorderPainted(false);
        btn_Proveedores.setContentAreaFilled(false);
        btn_Proveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Proveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Proveedores.setIconTextGap(-3);
        btn_Proveedores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_3.png"))); // NOI18N
        btn_Proveedores.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_1.png"))); // NOI18N
        btn_Proveedores.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Proveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProveedoresActionPerformed(evt);
            }
        });

        btn_Pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_2.png"))); // NOI18N
        btn_Pedidos.setText("PEDIDOS");
        btn_Pedidos.setActionCommand("JButtonAdm");
        btn_Pedidos.setBorderPainted(false);
        btn_Pedidos.setContentAreaFilled(false);
        btn_Pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Pedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Pedidos.setIconTextGap(-3);
        btn_Pedidos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_3.png"))); // NOI18N
        btn_Pedidos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_usuario_1.png"))); // NOI18N
        btn_Pedidos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Pedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PedidosActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_Proveedores)
                            .addComponent(btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Pedidos))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Ventas, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Clientes, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Inventory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Pedidos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Admin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Proveedores)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClientesActionPerformed
        // TODO add your handling code here:
        new Clientes(this, true).setVisible(true);

    }//GEN-LAST:event_btn_ClientesActionPerformed

    private void btn_VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VentasActionPerformed
        // TODO add your handling code here:
        new Ventas(this, true).setVisible(true);
    }//GEN-LAST:event_btn_VentasActionPerformed

    private void btn_InventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InventoryActionPerformed
        // TODO add your handling code here:
        new Inventario(this, true).setVisible(true);
    }//GEN-LAST:event_btn_InventoryActionPerformed

    private void btn_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdminActionPerformed
        // TODO add your handling code here:
        new Usuarios(this, true).setVisible(true);
    }//GEN-LAST:event_btn_AdminActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        confirmarSalida();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PedidosActionPerformed
        new Pedidos(this, true).setVisible(true);
    }//GEN-LAST:event_btn_PedidosActionPerformed

    private void btn_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProveedoresActionPerformed
       new Proveedores(this, true).setVisible(true);
    }//GEN-LAST:event_btn_ProveedoresActionPerformed

    private void confirmarSalida() throws HeadlessException {
        // TODO add your handling code here:
        JPasswordField jpf = new JPasswordField();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(new JLabel("Ingrese nuevamente la contraseña: "));
        panel.add(jpf);
        int resultado = JOptionPane.showConfirmDialog(this, panel, "Confirme Salida", JOptionPane.WARNING_MESSAGE);
        Usuario user = Login.obtenerUsuarioConectado();
        String Pass = new String(jpf.getPassword());
        if(user.getContraseña().equals(Pass) && resultado == 0){
            System.exit(0);
            
        }else{
            JOptionPane.showMessageDialog(null, "Error: Contraseña incorrecta");
        }
    }

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Admin;
    private javax.swing.JButton btn_Clientes;
    private javax.swing.JButton btn_Inventory;
    private javax.swing.JButton btn_Pedidos;
    private javax.swing.JButton btn_Proveedores;
    private javax.swing.JButton btn_Ventas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
