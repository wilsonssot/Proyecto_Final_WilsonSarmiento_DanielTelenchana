/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParaBDD;

/**
 *
 * @author Usuario
 */
public class Usuarios extends javax.swing.JDialog {

    /**
     * Creates new form Clientes
     */
    public Usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DatosUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_2.png"))); // NOI18N
        btnAgregarUsuario.setText("AGREGAR");
        btnAgregarUsuario.setBorderPainted(false);
        btnAgregarUsuario.setContentAreaFilled(false);
        btnAgregarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarUsuario.setIconTextGap(-3);
        btnAgregarUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_3.png"))); // NOI18N
        btnAgregarUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_1.png"))); // NOI18N
        btnAgregarUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_2.png"))); // NOI18N
        btnModificarUsuario.setText("MODIFICAR");
        btnModificarUsuario.setBorderPainted(false);
        btnModificarUsuario.setContentAreaFilled(false);
        btnModificarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarUsuario.setIconTextGap(-3);
        btnModificarUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_3.png"))); // NOI18N
        btnModificarUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_1.png"))); // NOI18N
        btnModificarUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnModificarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_2.png"))); // NOI18N
        btnBuscarUsuario.setText("BUSCAR");
        btnBuscarUsuario.setBorderPainted(false);
        btnBuscarUsuario.setContentAreaFilled(false);
        btnBuscarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarUsuario.setIconTextGap(-3);
        btnBuscarUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_3.png"))); // NOI18N
        btnBuscarUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_1.png"))); // NOI18N
        btnBuscarUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBuscarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        jTable_DatosUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Dirección", "Teléfono", "Cargo", "Sueldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_DatosUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(btnModificarUsuario)
                        .addGap(72, 72, 72)
                        .addComponent(btnBuscarUsuario)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarUsuario)
                    .addComponent(btnAgregarUsuario)
                    .addComponent(btnModificarUsuario))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuarios dialog = new Usuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_DatosUsuarios;
    // End of variables declaration//GEN-END:variables
}
