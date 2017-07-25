/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import ClasesSecundarias.Calzado;
import ClasesSecundarias.Coneccion;
import ClasesSecundarias.Metodos;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Ventas extends javax.swing.JDialog {

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
     * Creates new form Ventas
     */
    public Ventas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        deshabilitarComponentes();
        deshabilitarCancelar();
        llenarComboBox();
        establecerModeloTabla();
    }

    public void establecerModeloTabla() {
        jTable_CarritoCompra.setModel(modeloTabla);
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Valor/U");
        modeloTabla.addColumn("Valor/T");

    }

    public void CargarDatosCedula() {
        try {
            cn.Conectar();
            int cont = 0;
            String usu = "";
            String cedula = jTextField_CedCli.getText();
            String query = "select * from clientes where ced_cli = " + cedula + " ";
            st = cn.getConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                cont++;
                if (cedula.equals(rs.getString("CED_CLI"))) {
                    jTextField_NomCli.setText(rs.getString("NOM_CLI"));
                    jTextField_ApeCli.setText(rs.getString("APE_CLI"));
                    jTextField_DirCli.setText(rs.getString("DIR_CLI"));
                    jTextField_TelCli.setText(rs.getString("TEL_CLI"));
                    JOptionPane.showMessageDialog(null, "Carga de datos Exitosa!...");
                    habilitarComponentes();
                }

            }
            st.close();
            rs.close();
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "Cliente no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error BDD: "+ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }catch (java.lang.NullPointerException ex1){
            JOptionPane.showMessageDialog(null, "Ocurrió un error BDD: "+ex1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Vector<Calzado> datosParaComboBox() {
        Vector<Calzado> zapatos = new Vector<Calzado>();
        Calzado cal;
        jComboBox_Marcas.removeAllItems();
        try {

            cn.Conectar();
            st = cn.getConexion().createStatement();
            String sql = "select * from producto_calzado";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                cal = new Calzado();
                cal.setId(rs.getInt(1));
                cal.setNombre(rs.getString(2));
                cal.setMarca(rs.getString(3));
                cal.setModelo(rs.getString(4));
                cal.setTalla(rs.getString(5));
                cal.setPrecio(rs.getFloat(6));
                cal.setExistencia(rs.getInt(7));
                zapatos.add(cal);
            }
            st.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error : "+ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch (java.lang.NullPointerException ex1){
            JOptionPane.showMessageDialog(null, "Ocurrió un error : "+ex1.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return zapatos;

    }

    public void llenarComboBox() {

        Vector<Calzado> cal = datosParaComboBox();
        DefaultComboBoxModel modeloProductos = new DefaultComboBoxModel(cal);
//        for (int i = 0; i < cal.size(); i++) {
//            modeloProductos.addElement(cal.get(i).toString());
//        }
        jComboBox_Marcas.setModel(modeloProductos);
    }

    public void habilitarComponentes() {
        jComboBox_Marcas.setEnabled(true);
        //jTextField_Talla.setEnabled(true);
        //jTextField_Modelo.setEnabled(true);
        //jTextField_TipoZapato.setEnabled(true);
        jTextField_Cantidad.setEnabled(true);
        jTextField_Total.setEnabled(true);
        //jButton_Añadir.setEnabled(true);
        jTable_CarritoCompra.setEnabled(true);
        //jButtonFacturar.setEnabled(true);
        //jButtonLimpiarDatos.setEnabled(true);
        jButton_Eliminar.setEnabled(true);

    }

    public void deshabilitarComponentes() {
        jComboBox_Marcas.setEnabled(false);
        //jTextField_Talla.setEnabled(false);
        //jTextField_Modelo.setEnabled(false);
        //jTextField_TipoZapato.setEnabled(false);
        jTextField_Cantidad.setEnabled(false);
        jTextField_Total.setEnabled(false);
        jButton_Añadir.setEnabled(false);
        //jTable_CarritoCompra.setEnabled(false);
        jButtonFacturar.setEnabled(false);
        jButton_Cancelar.setEnabled(false);
        jButton_Limpiar.setEnabled(false);
        jButton_Eliminar.setEnabled(false);

    }

    public void limpiarValores() {
        jTextField_ApeCli.setText("");
        jTextField_Cantidad.setText("");
        jTextField_CedCli.setText("");
        jTextField_NomCli.setText("");
        jTextField_DirCli.setText("");
        jTextField_TelCli.setText("");
        jTextField_Total.setText("");
        jTextField_Precio.setText("");
        

    }

    public void deshabilitarCancelar() {
        boolean res;

        if (jTextField_NomCli.getText().equals("")) {
            res = true;
        } else {
            res = false;
        }
        if (jTextField_ApeCli.getText().equals("")) {
            res = true;
        } else {
            res = false;
        }
        if (jTextField_DirCli.getText().equals("")) {
            res = true;
        } else {
            res = false;
        }
        if (jTextField_TelCli.getText().equals("")) {
            res = true;
        } else {
            res = false;
        }
        if (jTextField_CedCli.getText().equals("")) {
            res = true;
        } else {
            res = false;
        }

        if (res) {
            jButton_Limpiar.setEnabled(false);
        } else {
            jButton_Limpiar.setEnabled(true);
        }
    }

    public void llenarDatosVendidos(Calzado zapato) {
        Object zapVendido[] = new Object[5];
        zapVendido[0] = zapato.getId();
        zapVendido[1] = zapato.getNombre() + " " + zapato.getMarca() + " " + zapato.getModelo() + " " + zapato.getTalla();
        zapVendido[2] = jTextField_Cantidad.getText();
        zapVendido[3] = zapato.getPrecio();
        zapVendido[4] = (zapato.getPrecio() * Double.valueOf(jTextField_Cantidad.getText()));
        modeloTabla.addRow(zapVendido);
        double total = 0, valor;
        for (int i = 0; i < jTable_CarritoCompra.getRowCount(); i++) {
            valor = (double) jTable_CarritoCompra.getValueAt(i, 4);
            total += valor;
        }
        jTextField_Total.setText(String.valueOf(total));

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
        jTextField_CedCli = new javax.swing.JTextField();
        jTextField_NomCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_ApeCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_TelCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_DirCli = new javax.swing.JTextField();
        jButton_Cargar = new javax.swing.JButton();
        jButton_Limpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_Marcas = new javax.swing.JComboBox<>();
        jButton_Añadir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField_Cantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Precio = new javax.swing.JTextField();
        jButton_Eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_CarritoCompra = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButtonFacturar = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        jTextField_Total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel_Fondo.setBorder(javax.swing.BorderFactory.createTitledBorder("VENTA DE CALZADO"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL CLIENTE"));

        jLabel1.setText("Céd/Ruc:");

        jTextField_CedCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CedCliKeyTyped(evt);
            }
        });

        jTextField_NomCli.setEditable(false);
        jTextField_NomCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NomCliKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jTextField_ApeCli.setEditable(false);
        jTextField_ApeCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ApeCliKeyTyped(evt);
            }
        });

        jLabel3.setText("Apellido:");

        jLabel4.setText("Teléfono:");

        jTextField_TelCli.setEditable(false);
        jTextField_TelCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TelCliKeyTyped(evt);
            }
        });

        jLabel5.setText("Dirección:");

        jTextField_DirCli.setEditable(false);
        jTextField_DirCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DirCliKeyTyped(evt);
            }
        });

        jButton_Cargar.setText("Cargar>>");
        jButton_Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CargarActionPerformed(evt);
            }
        });

        jButton_Limpiar.setText("Limpiar Datos");
        jButton_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_CedCli, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_TelCli, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_ApeCli)
                            .addComponent(jTextField_NomCli, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_DirCli))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton_Limpiar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_CedCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_TelCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_NomCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_DirCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_ApeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Limpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("CALZADO"));

        jLabel6.setText("Marca:");

        jComboBox_Marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Marcas.setEnabled(false);
        jComboBox_Marcas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_MarcasItemStateChanged(evt);
            }
        });

        jButton_Añadir.setText("Añadir >>");
        jButton_Añadir.setEnabled(false);
        jButton_Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AñadirActionPerformed(evt);
            }
        });

        jLabel9.setText("Cantidad:");

        jTextField_Cantidad.setEnabled(false);
        jTextField_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CantidadKeyTyped(evt);
            }
        });

        jLabel7.setText("Precio:");

        jTextField_Precio.setEditable(false);

        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setEnabled(false);
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox_Marcas, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_Precio)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_Cantidad)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton_Añadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Eliminar)))
                .addContainerGap(11, Short.MAX_VALUE))
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
                    .addComponent(jComboBox_Marcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Añadir)
                    .addComponent(jButton_Eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("CARRITO DE COMPRA"));

        jTable_CarritoCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripción", "Cantidad", "V/U", "V/T"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_CarritoCompra);

        jLabel10.setText("Total de la venta:");

        jButtonFacturar.setText("Facturar");
        jButtonFacturar.setEnabled(false);
        jButtonFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacturarActionPerformed(evt);
            }
        });

        jButton_Cancelar.setText("Cancelar");
        jButton_Cancelar.setEnabled(false);
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });

        jTextField_Total.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonFacturar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jButtonFacturar)
                    .addComponent(jButton_Cancelar)
                    .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_FondoLayout = new javax.swing.GroupLayout(jPanel_Fondo);
        jPanel_Fondo.setLayout(jPanel_FondoLayout);
        jPanel_FondoLayout.setHorizontalGroup(
            jPanel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jTextField_CedCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CedCliKeyTyped
        // TODO add your handling code here:
        deshabilitarCancelar();
        Metodos.validarTelefono(evt, jTextField_CedCli);

    }//GEN-LAST:event_jTextField_CedCliKeyTyped

    private void jTextField_NomCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NomCliKeyTyped
        // TODO add your handling code here:
        Metodos.validarLetras(evt, jTextField_NomCli);
    }//GEN-LAST:event_jTextField_NomCliKeyTyped

    private void jTextField_ApeCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ApeCliKeyTyped
        // TODO add your handling code here:
        Metodos.validarLetras(evt, jTextField_ApeCli);
    }//GEN-LAST:event_jTextField_ApeCliKeyTyped

    private void jTextField_TelCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TelCliKeyTyped
        // TODO add your handling code here:
        Metodos.validarTelefono(evt, jTextField_TelCli);
    }//GEN-LAST:event_jTextField_TelCliKeyTyped

    private void jTextField_DirCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DirCliKeyTyped
        // TODO add your handling code here:
        Metodos.validarLetras(evt, jTextField_DirCli);

    }//GEN-LAST:event_jTextField_DirCliKeyTyped

    private void jButton_CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CargarActionPerformed
        // TODO add your handling code here:

        CargarDatosCedula();
    }//GEN-LAST:event_jButton_CargarActionPerformed

    private void jButton_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LimpiarActionPerformed
        // TODO add your handling code here:
        deshabilitarComponentes();
        limpiarValores();
        deshabilitarCancelar();
    }//GEN-LAST:event_jButton_LimpiarActionPerformed

    private void jTextField_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadKeyTyped
        // TODO add your handling code here:
        Metodos.validarTelefono(evt, jTextField_Cantidad);
    }//GEN-LAST:event_jTextField_CantidadKeyTyped

    private void jComboBox_MarcasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_MarcasItemStateChanged
        establecerPrecioCalzado(evt);
    }//GEN-LAST:event_jComboBox_MarcasItemStateChanged

    private void establecerPrecioCalzado(ItemEvent evt) {
        // TODO add your handling code here:
        int cont = 0;
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cont++;
            Calzado zapato = (Calzado) jComboBox_Marcas.getSelectedItem();
            jTextField_Precio.setText(String.valueOf(zapato.getPrecio()));
        }
        if (cont != 0) {
            jButton_Añadir.setEnabled(true);
        }
    }

    private void jButton_AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AñadirActionPerformed
        AñadirCalzadoTabla();


    }//GEN-LAST:event_jButton_AñadirActionPerformed

    private void AñadirCalzadoTabla() throws HeadlessException {
        // TODO add your handling code here:
        if (!jTextField_Cantidad.getText().equals("")) {
            jButton_Cancelar.setEnabled(true);
            jButtonFacturar.setEnabled(true);
            int existencia;
            Calzado zapatoVendido = ((Calzado) (jComboBox_Marcas.getSelectedItem()));
            existencia = zapatoVendido.getExistencia();
            if (existencia > 24) {
                llenarDatosVendidos(zapatoVendido);
            } else if (existencia > 12) {
                JOptionPane.showMessageDialog(null, "Quedan " + existencia + " artículos de este tipo", "AVISO!", JOptionPane.WARNING_MESSAGE);
            } else if (existencia == 0) {
                JOptionPane.showMessageDialog(null, "Ya no quedan artículos de este tipo!", "ERROR!...", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Quedan pocos artículos de este tipo : " + existencia, "AVISO!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void jButtonFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacturarActionPerformed
        Facturar();
    }//GEN-LAST:event_jButtonFacturarActionPerformed

    private void Facturar() throws HeadlessException, NumberFormatException {
        // TODO add your handling code here:
        
        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Bogota" ) );
        String cedCli = jTextField_CedCli.getText();
        double total = Double.valueOf(jTextField_Total.getText());
        if (jTable_CarritoCompra.getRowCount() > 0) {
            try {
                cn.Conectar();
                String sql = "insert into ventas (CED_EMP_V,CED_CLI_V,FEC_VEN,TOTAL) values(?,?,?,?)";
                pst = cn.getConexion().prepareStatement(sql);
                pst.setString(1, "1802499275");
                pst.setString(2, cedCli);
                pst.setDate(3, java.sql.Date.valueOf(todayLocalDate));
                pst.setDouble(4, total);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Venta exitosa!...");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un problema "+ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen artículos a facturar");
        }
    }

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        confirmarCancelarVenta();
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        // TODO add your handling code here:
        try{
            modeloTabla.removeRow(jTable_CarritoCompra.getSelectedRow());
        }catch( java.lang.ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "No ha seleccionado una fila");
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void confirmarCancelarVenta() throws HeadlessException {
        // TODO add your handling code here:
        
        int confirmar = JOptionPane.showConfirmDialog(null, "Está seguro que desea cancelar la venta?...", "CANCELANDO VENTA", JOptionPane.YES_NO_OPTION);
        if (confirmar == 0) {
            
            limpiarValores();
            for (int i = jTable_CarritoCompra.getRowCount()-1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
            deshabilitarComponentes();
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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventas dialog = new Ventas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonFacturar;
    private javax.swing.JButton jButton_Añadir;
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Cargar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_Limpiar;
    private javax.swing.JComboBox<String> jComboBox_Marcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_CarritoCompra;
    private javax.swing.JTextField jTextField_ApeCli;
    private javax.swing.JTextField jTextField_Cantidad;
    private javax.swing.JTextField jTextField_CedCli;
    private javax.swing.JTextField jTextField_DirCli;
    private javax.swing.JTextField jTextField_NomCli;
    private javax.swing.JTextField jTextField_Precio;
    private javax.swing.JTextField jTextField_TelCli;
    private javax.swing.JTextField jTextField_Total;
    // End of variables declaration//GEN-END:variables
}
