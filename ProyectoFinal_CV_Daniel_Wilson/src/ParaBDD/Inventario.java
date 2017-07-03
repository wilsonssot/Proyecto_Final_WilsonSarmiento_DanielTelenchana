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
public class Inventario extends javax.swing.JDialog {

    /**
     * Creates new form Clientes
     */
    public Inventario(java.awt.Frame parent, boolean modal) {
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

        btnAgregarCalzado = new javax.swing.JButton();
        btnModificarCalzado = new javax.swing.JButton();
        btnBuscarCalzado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Inventario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregarCalzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_2.png"))); // NOI18N
        btnAgregarCalzado.setText("AGREGAR");
        btnAgregarCalzado.setBorderPainted(false);
        btnAgregarCalzado.setContentAreaFilled(false);
        btnAgregarCalzado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarCalzado.setIconTextGap(-3);
        btnAgregarCalzado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_3.png"))); // NOI18N
        btnAgregarCalzado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_1.png"))); // NOI18N
        btnAgregarCalzado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregarCalzado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnModificarCalzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_2.png"))); // NOI18N
        btnModificarCalzado.setText("MODIFICAR");
        btnModificarCalzado.setBorderPainted(false);
        btnModificarCalzado.setContentAreaFilled(false);
        btnModificarCalzado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarCalzado.setIconTextGap(-3);
        btnModificarCalzado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_3.png"))); // NOI18N
        btnModificarCalzado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_1.png"))); // NOI18N
        btnModificarCalzado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnModificarCalzado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnBuscarCalzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_2.png"))); // NOI18N
        btnBuscarCalzado.setText("BUSCAR");
        btnBuscarCalzado.setBorderPainted(false);
        btnBuscarCalzado.setContentAreaFilled(false);
        btnBuscarCalzado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarCalzado.setIconTextGap(-3);
        btnBuscarCalzado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_3.png"))); // NOI18N
        btnBuscarCalzado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_1.png"))); // NOI18N
        btnBuscarCalzado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBuscarCalzado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario"));

        jTable_Inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Marca", "Modelo", "Talla", "Precio Compra", "Precio Venta", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Inventario);

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
                        .addComponent(btnAgregarCalzado)
                        .addGap(18, 24, Short.MAX_VALUE)
                        .addComponent(btnModificarCalzado)
                        .addGap(24, 24, 24)
                        .addComponent(btnBuscarCalzado)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarCalzado)
                    .addComponent(btnAgregarCalzado)
                    .addComponent(btnModificarCalzado))
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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inventario dialog = new Inventario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarCalzado;
    private javax.swing.JButton btnBuscarCalzado;
    private javax.swing.JButton btnModificarCalzado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Inventario;
    // End of variables declaration//GEN-END:variables
}