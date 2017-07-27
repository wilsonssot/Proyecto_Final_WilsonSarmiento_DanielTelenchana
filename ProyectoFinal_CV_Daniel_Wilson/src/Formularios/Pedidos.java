/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Acceso.Login;
import ClasesSecundarias.Material;
import ClasesSecundarias.Coneccion;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ClasesSecundarias.Pedido;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/*import ClasesSecundarias.Coneccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;*/
/**
 *
 * @author Usuario
 */
public class Pedidos extends javax.swing.JDialog {

    ArrayList<Pedido> lista = new ArrayList<Pedido>();

    Coneccion cn = new Coneccion();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement st = null;
    String codigo, material, cantidad, precio, vTotal;

    /**
     * Creates new form Ventas
     */
    public Pedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        deshabilitarComponentes();
        llenarComboBox();
    }

    public void setearVariables() {
        for (int i = 0; i < lista.size(); i++) {
            codigo = lista.get(i).getCodigo();
            material = lista.get(i).getMaterial();
            cantidad = lista.get(i).getCantidad();
            precio = lista.get(i).getPrecio();
            vTotal = lista.get(i).getTotal();
        }
    }

    public void ingresoPedidos() throws SQLException {
        for (int i = 0; i < lista.size(); i++) {
            if (ValidarControlesIngresoPedidos()) {
                setearVariables();
                cn.Conectar();
                pst = cn.getConexion().prepareStatement("insert into pedidos(COD_PED,MAT_PED,CANT_PED,PREC_PED,VTOTAL_PED) values(?,?,?,?,?)");
                pst.setString(1, codigo);
                pst.setString(2, material);
                pst.setString(3, cantidad);
                pst.setString(4, precio);
                pst.setString(5, vTotal);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Ingresados correctamente");
            }
        }

    }

    //Revisar Codigo para mostrar los proveedores
    /* public void mostrarProveedores() throws SQLException {
        cn.Conectar();
        String usu = " ";
        String codigo = jTextField_Cod_Prov.getText();
        String query = "select * from proveedores where cod_prov = " + codigo + " ";
        st = cn.getConexion().createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            usu = rs.getString("COD_PROV");
        }
        if (codigo.equals(usu)) {
            jTextField_Nom_Prov.setText(rs.getString("NOM_PROV"));
            jTextField_Dir_Prov.setText(rs.getString("DIR_PROV"));
            jTextField_Tel_Prov.setText(rs.getString("TEL_PROV"));
        }
    }*/
    public void CargarDatosProveedor() {
        try {
            cn.Conectar();
            int cont = 0;
            String usu = "";
            String codigo = jTextField_Cod_Prov.getText();
            String query = "select * from proveedores where cod_prov = " + codigo + " ";
            st = cn.getConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                cont++;
                if (codigo.equals(rs.getString("COD_PROV"))) {
                    jTextField_Nom_Prov.setText(rs.getString("NOM_PROV"));
                    jTextField_Dir_Prov.setText(rs.getString("DIR_PROV"));
                    jTextField_Tel_Prov.setText(rs.getString("TEL_PROV"));
                    JOptionPane.showMessageDialog(null, "Carga de datos Exitosa!...");
                    habilitarComponentes();
                }

            }
            st.close();
            rs.close();
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "Proveedor no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error BDD: " + ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);

        } catch (java.lang.NullPointerException ex1) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error BDD: " + ex1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void habilitarComponentes() {
        jComboBox_Materiales.setEnabled(true);
        jTextField_Precio.setEnabled(true);
        jTextField_Nom_Prov.setEnabled(true);
        jTextField_Tel_Prov.setEnabled(true);
        jTextField_Dir_Prov.setEnabled(true);
        jTextField_Cant_Material.setEnabled(true);
        //jButton_Añadir.setEnabled(true);
        jTable_Pedidos.setEnabled(true);
        //jButtonFacturar.setEnabled(true);
        //jButtonLimpiarDatos.setEnabled(true);
    }

    public void deshabilitarComponentes() {
        jComboBox_Materiales.setEnabled(false);
        //jTextField_Talla.setEnabled(false);
        //jTextField_Modelo.setEnabled(false);
        //jTextField_TipoZapato.setEnabled(false);
        jTextField_Precio.setEnabled(false);
        jTextField_Nom_Prov.setEnabled(false);
        jTextField_Tel_Prov.setEnabled(false);
        jTextField_Dir_Prov.setEnabled(false);
        jTextField_Cant_Material.setEnabled(false);
        jButton_Añadir_Pedido.setEnabled(false);
        //jTable_CarritoCompra.setEnabled(false);
        jButton_RealizarPedido.setEnabled(false);
        jButton_LimpiarDatos.setEnabled(false);

    }

    public boolean ValidarControlesIngresoPedidos() {
        if ("".equals(jTextField_Cod_Prov.getText())) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el código", "ERROR", HEIGHT);
            return false;
        }
        if ("".equals(jComboBox_Materiales.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione material", "ERROR", HEIGHT);
        }
        if ("".equals(jTextField_Cant_Material.getText())) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese la cantidad", "ERROR", HEIGHT);
        }
        return true;
    }

    public Vector<Material> datosParaComboBox() {
        Vector<Material> material = new Vector<Material>();
        Material mat;
        jComboBox_Materiales.removeAllItems();
        try {

            cn.Conectar();
            st = cn.getConexion().createStatement();
            String sql = "select * from materiales";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                mat = new Material();
                mat.setId(rs.getInt(1));
                mat.setNombre(rs.getString(2));
                mat.setDescripcion(rs.getString(3));
                mat.setPrecioC(rs.getFloat(4));
                material.add(mat);
            }
            st.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error : " + ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NullPointerException ex1) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error : " + ex1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return material;

    }

    public void llenarComboBox() {

        Vector<Material> mat = datosParaComboBox();
        DefaultComboBoxModel modeloMaterial = new DefaultComboBoxModel(mat);
//        for (int i = 0; i < cal.size(); i++) {
//            modeloProductos.addElement(cal.get(i).toString());
//        }
        jComboBox_Materiales.setModel(modeloMaterial);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Nom_Prov = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Tel_Prov = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Dir_Prov = new javax.swing.JTextField();
        jTextField_Cod_Prov = new javax.swing.JTextField();
        jButton_Cargar_Prov = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_Materiales = new javax.swing.JComboBox<>();
        jButton_Añadir_Pedido = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField_Cant_Material = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Precio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Pedidos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel_Total_Pedido = new javax.swing.JLabel();
        jButton_LimpiarDatos = new javax.swing.JButton();
        jButton_RealizarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel_Fondo.setBorder(javax.swing.BorderFactory.createTitledBorder("PEDIDOS"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PROVEEDOR"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel4.setText("Teléfono:");

        jLabel5.setText("Dirección:");

        jButton_Cargar_Prov.setText("Cargar>>");
        jButton_Cargar_Prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cargar_ProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_Nom_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_Cod_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton_Cargar_Prov)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_Tel_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField_Dir_Prov, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Tel_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Cod_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cargar_Prov))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Nom_Prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Dir_Prov)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("CALZADO"));

        jLabel6.setText("Material:");

        jComboBox_Materiales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton_Añadir_Pedido.setText("Añadir >>");
        jButton_Añadir_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Añadir_PedidoActionPerformed(evt);
            }
        });

        jLabel9.setText("Cantidad:");

        jLabel3.setText("metros");

        jLabel7.setText("Precio:");

        jLabel8.setText("$");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_Materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_Cant_Material, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jButton_Añadir_Pedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Materiales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Cant_Material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jButton_Añadir_Pedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DETALLE PEDIDO"));

        jTable_Pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Material", "Cantidad", "V/Compra", "V/T"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Pedidos);

        jLabel10.setText("Total del pedido:");

        jLabel_Total_Pedido.setText(" ");
        jLabel_Total_Pedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton_LimpiarDatos.setText("Limpiar Datos");

        jButton_RealizarPedido.setText("Realizar Pedido");
        jButton_RealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RealizarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_RealizarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_LimpiarDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Total_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel_Total_Pedido)
                    .addComponent(jButton_LimpiarDatos)
                    .addComponent(jButton_RealizarPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_FondoLayout = new javax.swing.GroupLayout(jPanel_Fondo);
        jPanel_Fondo.setLayout(jPanel_FondoLayout);
        jPanel_FondoLayout.setHorizontalGroup(
            jPanel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_FondoLayout.setVerticalGroup(
            jPanel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Añadir_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Añadir_PedidoActionPerformed
        if (ValidarControlesIngresoPedidos()) {

            double total;
            total = Double.valueOf(jTextField_Cant_Material.getText()) * Double.valueOf(jTextField_Precio.getText());
            Pedido pedido = new Pedido(jTextField_Cod_Prov.getText(),
                    jComboBox_Materiales.getSelectedItem().toString(),
                    String.valueOf(jTextField_Cant_Material.getText()),
                    jTextField_Precio.getText(),
                    String.valueOf(total));
            lista.add(pedido);
            mostrar();
            limpiarDatos();

            double sumaTotal = 0;

            for (int i = 0; i < lista.size(); i++) {
                double suma = Double.valueOf(lista.get(i).getTotal());
                sumaTotal = sumaTotal + suma;
            }
            jLabel_Total_Pedido.setText(String.valueOf(sumaTotal));

        }
    }//GEN-LAST:event_jButton_Añadir_PedidoActionPerformed

    private void Facturar() throws HeadlessException, NumberFormatException, SQLException {
        // TODO add your handling code here:

        int codDetalle = 0;
        LocalDate todayLocalDate = LocalDate.now(ZoneId.of("America/Bogota"));
        String codProv = jTextField_Cod_Prov.getText();
        double total = Double.valueOf(jLabel_Total_Pedido.getText());
        if (jTable_Pedidos.getRowCount() > 0) {
            try {
                cn.Conectar();
                String sql = "insert into pedidos (CED_EMP_P,COD_PROV_P,FEC_PED,TOTAL) values(?,?,?,?)";
                pst = cn.getConexion().prepareStatement(sql, new String[]{"NUM_PED"});
                pst.setString(1, Login.obtenerUsuarioConectado().getCedula());
                pst.setString(2, codProv);
                pst.setDate(3, java.sql.Date.valueOf(todayLocalDate));
                pst.setDouble(4, total);
                //pst.executeUpdate();
                int affectedRows = pst.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        affectedRows = generatedKeys.getInt(1);
                        codDetalle = affectedRows;
                        cn.getConexion().close();
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema " + ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen artículos a facturar");
        }

        paraTablaDetalle(codDetalle);

    }

    private void paraTablaDetalle(int codigo) {
        //Enviar los datos a la tabla detalle

        //
        if (codigo == 0) {
            try {
                cn.Conectar();
                String query = "insert into detalle_pedido (NUM_VEN,COD_PRO_V,CANTIDAD) values (?,?,?)";
                pst = cn.getConexion().prepareStatement(query);
                boolean ok = false;
                int size = jTable_CarritoCompra.getRowCount();
                for (int i = 0; i < size; i++) {
                    pst.setInt(1, codigo);
                    pst.setString(2, jTable_CarritoCompra.getValueAt(i, 0).toString());
                    pst.setInt(3, Integer.valueOf(jTable_CarritoCompra.getValueAt(i, 2).toString()));
                    pst.executeUpdate();
                    ok = true;
                }
                if (ok) {

                    JOptionPane.showMessageDialog(null, "Venta exitosa!...");
                    limpiarValores();
                    deshabilitarCancelar();
                    deshabilitarComponentes();
                    limpiarTabla();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema " + ex.toString());
            }
        }

    }

    public void limpiarDatos() {
        jTextField_Cod_Prov.setText("");
        jTextField_Nom_Prov.setText("");
        jTextField_Dir_Prov.setText("");
        jTextField_Tel_Prov.setText("");
        jTextField_Cant_Material.setText("");
        jTextField_Precio.setText("");
        jComboBox_Materiales.setSelectedItem("");
    }

    private void jButton_RealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RealizarPedidoActionPerformed
        try {
            if (ValidarControlesIngresoPedidos()) {
                ingresoPedidos();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jButton_RealizarPedidoActionPerformed

    private void jButton_Cargar_ProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cargar_ProvActionPerformed
        CargarDatosProveedor();
    }//GEN-LAST:event_jButton_Cargar_ProvActionPerformed

    /**/
    public void mostrar() {
        String datos[][] = new String[lista.size()][5];

        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getCodigo();
            datos[i][1] = lista.get(i).getMaterial();
            datos[i][2] = lista.get(i).getCantidad();
            datos[i][3] = lista.get(i).getPrecio();
            datos[i][4] = lista.get(i).getTotal();
        }

        jTable_Pedidos.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "Codigo", "Material", "Cantidad", "Precio", "V.Total"
                }
        ));

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
            java.util.logging.Logger.getLogger(Pedidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pedidos dialog = new Pedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Añadir_Pedido;
    private javax.swing.JButton jButton_Cargar_Prov;
    private javax.swing.JButton jButton_LimpiarDatos;
    private javax.swing.JButton jButton_RealizarPedido;
    private javax.swing.JComboBox<String> jComboBox_Materiales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Total_Pedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Pedidos;
    private javax.swing.JTextField jTextField_Cant_Material;
    private javax.swing.JTextField jTextField_Cod_Prov;
    private javax.swing.JTextField jTextField_Dir_Prov;
    private javax.swing.JTextField jTextField_Nom_Prov;
    private javax.swing.JTextField jTextField_Precio;
    private javax.swing.JTextField jTextField_Tel_Prov;
    // End of variables declaration//GEN-END:variables
}
