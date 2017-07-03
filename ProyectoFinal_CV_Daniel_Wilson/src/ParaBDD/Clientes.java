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
public class Clientes extends javax.swing.JDialog {

    /**
     * Creates new form Clientes
     */
    public Clientes(java.awt.Frame parent, boolean modal) {
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

        btnAgregarCliente = new javax.swing.JButton();
        btnModificarCliente = new javax.swing.JButton();
        btnBuscarClientes = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DatosClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_2.png"))); // NOI18N
        btnAgregarCliente.setText("AGREGAR");
        btnAgregarCliente.setBorderPainted(false);
        btnAgregarCliente.setContentAreaFilled(false);
        btnAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarCliente.setIconTextGap(-3);
        btnAgregarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_3.png"))); // NOI18N
        btnAgregarCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_agregar_cliente_1.png"))); // NOI18N
        btnAgregarCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnModificarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_2.png"))); // NOI18N
        btnModificarCliente.setText("MODIFICAR");
        btnModificarCliente.setBorderPainted(false);
        btnModificarCliente.setContentAreaFilled(false);
        btnModificarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarCliente.setIconTextGap(-3);
        btnModificarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_3.png"))); // NOI18N
        btnModificarCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_editar_cliente_1.png"))); // NOI18N
        btnModificarCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnModificarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnBuscarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_2.png"))); // NOI18N
        btnBuscarClientes.setText("BUSCAR");
        btnBuscarClientes.setBorderPainted(false);
        btnBuscarClientes.setContentAreaFilled(false);
        btnBuscarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarClientes.setIconTextGap(-3);
        btnBuscarClientes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_3.png"))); // NOI18N
        btnBuscarClientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/boton_buscar_clientes_1.png"))); // NOI18N
        btnBuscarClientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBuscarClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jTable_DatosClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Dirección", "Teléfono", "Ciudad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_DatosClientes);

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
                        .addComponent(btnAgregarCliente)
                        .addGap(18, 24, Short.MAX_VALUE)
                        .addComponent(btnModificarCliente)
                        .addGap(24, 24, 24)
                        .addComponent(btnBuscarClientes)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarClientes)
                    .addComponent(btnAgregarCliente)
                    .addComponent(btnModificarCliente))
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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes dialog = new Clientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBuscarClientes;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_DatosClientes;
    // End of variables declaration//GEN-END:variables
}