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
public class Proveedores extends javax.swing.JDialog {

    /**
     * Creates new form Clientes
     */
    public Proveedores(java.awt.Frame parent, boolean modal) {
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

        btnAgregarProveedor = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        btnBuscarProveedor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DatosProveedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_2.png"))); // NOI18N
        btnAgregarProveedor.setText("AGREGAR");
        btnAgregarProveedor.setBorderPainted(false);
        btnAgregarProveedor.setContentAreaFilled(false);
        btnAgregarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarProveedor.setIconTextGap(-3);
        btnAgregarProveedor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_3.png"))); // NOI18N
        btnAgregarProveedor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_1.png"))); // NOI18N
        btnAgregarProveedor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregarProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnModificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_2.png"))); // NOI18N
        btnModificarProveedor.setText("MODIFICAR");
        btnModificarProveedor.setBorderPainted(false);
        btnModificarProveedor.setContentAreaFilled(false);
        btnModificarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarProveedor.setIconTextGap(-3);
        btnModificarProveedor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_3.png"))); // NOI18N
        btnModificarProveedor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_1.png"))); // NOI18N
        btnModificarProveedor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnModificarProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_2.png"))); // NOI18N
        btnBuscarProveedor.setText("BUSCAR");
        btnBuscarProveedor.setBorderPainted(false);
        btnBuscarProveedor.setContentAreaFilled(false);
        btnBuscarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProveedor.setIconTextGap(-3);
        btnBuscarProveedor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_3.png"))); // NOI18N
        btnBuscarProveedor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_1.png"))); // NOI18N
        btnBuscarProveedor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedores"));

        jTable_DatosProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Dirección", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_DatosProveedores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                        .addComponent(btnAgregarProveedor)
                        .addGap(18, 24, Short.MAX_VALUE)
                        .addComponent(btnModificarProveedor)
                        .addGap(24, 24, 24)
                        .addComponent(btnBuscarProveedor)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarProveedor)
                    .addComponent(btnAgregarProveedor)
                    .addComponent(btnModificarProveedor))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Proveedores dialog = new Proveedores(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_DatosProveedores;
    // End of variables declaration//GEN-END:variables
}