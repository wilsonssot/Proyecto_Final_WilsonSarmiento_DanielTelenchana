/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParaBDD;

import ClasesSecundarias.Coneccion;
import ClasesSecundarias.Metodos;
import ClasesSecundarias.Proveedor;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Proveedores extends javax.swing.JDialog {

    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    Coneccion cn = new Coneccion();
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;

    /**
     * Creates new form Clientes
     */
    public Proveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        establecerModeloTabla();
        cargarDatosProveedores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void establecerModeloTabla() {
        jTable_DatosProveedores.setModel(modeloTabla);
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");
    }

    private void limpiarTabla() {
        for (int i = jTable_DatosProveedores.getRowCount() - 1; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    public void actualizarClientes() {
        limpiarTabla();
        cargarDatosProveedores();
    }

    private void actualizarUnDato() throws HeadlessException {
        // TODO add your handling code here:

        if (jTextField_Nom_Prov.getText().equals("")
                || jTextField_Dir_Prov.getText().equals("")
                || jTextField_Tel_Prov.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos sin llenar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Object[] datos = {jTextField_Cod_Prov.getText(), jTextField_Nom_Prov.getText(), jTextField_Dir_Prov.getText(),
                jTextField_Tel_Prov.getText()};
            try {
                cn.Conectar();
                String sql = "UPDATE PROVEEDORES SET "
                        + "NOM_PROV = '" + datos[1].toString() + "' , "
                        + "DIR_PROV = '" + datos[2].toString() + "' , "
                        + "TEL_PROV = '" + datos[3].toString() + "' "
                        + "WHERE CED_EMP = '" + datos[0].toString() + "'";
                pst = cn.getConexion().prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos actualizados correctamente!...");
                limpiarCampos();
                cargarDatosProveedores();
                deshabilitarComponentes();
                actualizarClientes();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar " + ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void cargarDatosProveedores() {
        Vector<Proveedor> proveedores = DatosProveedor();
        boolean existe = false;
        Object[] prov = new Object[6];
        for (int i = 0; i < proveedores.size(); i++) {
            prov[0] = proveedores.get(i).getCodigo();
            prov[1] = proveedores.get(i).getNombre();
            prov[2] = proveedores.get(i).getDireccion();
            prov[3] = proveedores.get(i).getNombre();

            for (int j = 0; j < jTable_DatosProveedores.getRowCount(); j++) {
                if (prov[0].toString().equals(jTable_DatosProveedores.getValueAt(j, 0))) {
                    existe = true;
                    break;
                } else {
                    existe = false;
                }
            }
            if (!existe) {
                modeloTabla.addRow(prov);
            }

        }
    }
    
    public Vector<Proveedor> DatosProveedor() {
        Vector<Proveedor> proveedores = new Vector<Proveedor>();
        Proveedor prov;
        try {

            cn.Conectar();
            st = cn.getConexion().createStatement();
            String sql = "select * from proveedores";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                prov = new Proveedor();
                prov.setCodigo(rs.getString(1));
                prov.setNombre(rs.getString(2));
                prov.setDireccion(rs.getString(3));
                prov.setTelefono(rs.getString(4));
                proveedores.add(prov);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error : " + ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NullPointerException ex1) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error : " + ex1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return proveedores;
    }

     public void buscarDato() {
        limpiarTabla();
        try {
            cn.Conectar();
            String consulta = "SELECT * FROM PROVEEDORES WHERE NOM_PROV LIKE " + "'" + jTextField_Buscar.getText() + "_%'";
            st = cn.getConexion().prepareStatement(consulta);
            rs = st.executeQuery(consulta);
            String[] fila = new String[6];
            while (rs.next()) {
                fila[0] = rs.getString("COD_PROV");
                fila[1] = rs.getString("NOM_PROV");
                fila[2] = rs.getString("DIR_PROV");
                fila[3] = rs.getString("TEL_PROV");
                modeloTabla.addRow(fila);
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error : " + ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
     public void habilitarComponentes() {
        jTextField_Nom_Prov.setEnabled(true);
        jTextField_Dir_Prov.setEnabled(true);
        jTextField_Tel_Prov.setEnabled(true);
    }
      public void deshabilitarComponentes() {
        jTextField_Nom_Prov.setEnabled(false);
        jTextField_Dir_Prov.setEnabled(false);
        jTextField_Tel_Prov.setEnabled(false);

    }
      public void limpiarCampos() {
        jTextField_Cod_Prov.setText("");
        jTextField_Nom_Prov.setText("");
        jTextField_Dir_Prov.setText("");
        jTextField_Tel_Prov.setText("");
    }
      
       private void mostrarValores() {
        // TODO add your handling code here:
        if (jTable_DatosProveedores.getSelectedRow() != -1) {
            habilitarComponentes();
            int fila = jTable_DatosProveedores.getSelectedRow();
            jTextField_Cod_Prov.setText(jTable_DatosProveedores.getValueAt(fila, 0).toString());
            jTextField_Nom_Prov.setText(jTable_DatosProveedores.getValueAt(fila, 1).toString());
            jTextField_Dir_Prov.setText(jTable_DatosProveedores.getValueAt(fila, 2).toString());
            jTextField_Tel_Prov.setText(jTable_DatosProveedores.getValueAt(fila, 3).toString());
        } else {
            deshabilitarComponentes();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DatosProveedores = new javax.swing.JTable();
        btnAgregarProveedor = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Cod_Prov = new javax.swing.JTextField();
        jTextField_Nom_Prov = new javax.swing.JTextField();
        jTextField_Dir_Prov = new javax.swing.JTextField();
        jTextField_Tel_Prov = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

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
        btnModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProveedorActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Dirección:");

        jLabel4.setText("Teléfono:");

        jTextField_Cod_Prov.setEnabled(false);

        jTextField_Nom_Prov.setEnabled(false);
        jTextField_Nom_Prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Nom_ProvKeyTyped(evt);
            }
        });

        jTextField_Dir_Prov.setEnabled(false);
        jTextField_Dir_Prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Dir_ProvKeyTyped(evt);
            }
        });

        jTextField_Tel_Prov.setEnabled(false);
        jTextField_Tel_Prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Tel_ProvKeyTyped(evt);
            }
        });

        jLabel5.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_Cod_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nom_Prov)
                    .addComponent(jTextField_Dir_Prov)
                    .addComponent(jTextField_Tel_Prov)
                    .addComponent(jTextField_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarProveedor)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarProveedor)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_Cod_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_Nom_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Dir_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_Tel_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarProveedor)
                            .addComponent(btnModificarProveedor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed
        actualizarUnDato();
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        new Proveedores(null, true).setVisible(true);
        cargarDatosProveedores();
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void jTextField_Nom_ProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Nom_ProvKeyTyped
        Metodos.validarLetras(evt, jTextField_Nom_Prov);
    }//GEN-LAST:event_jTextField_Nom_ProvKeyTyped

    private void jTextField_Dir_ProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Dir_ProvKeyTyped
       Metodos.validarLetras(evt, jTextField_Dir_Prov);
    }//GEN-LAST:event_jTextField_Dir_ProvKeyTyped

    private void jTextField_Tel_ProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Tel_ProvKeyTyped
      Metodos.validarTelefono(evt, jTextField_Tel_Prov);
    }//GEN-LAST:event_jTextField_Tel_ProvKeyTyped

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
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_DatosProveedores;
    private javax.swing.JTextField jTextField_Buscar;
    private javax.swing.JTextField jTextField_Cod_Prov;
    private javax.swing.JTextField jTextField_Dir_Prov;
    private javax.swing.JTextField jTextField_Nom_Prov;
    private javax.swing.JTextField jTextField_Tel_Prov;
    // End of variables declaration//GEN-END:variables
}
