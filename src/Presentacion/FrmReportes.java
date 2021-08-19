/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidad.ClsECliente;
import Entidad.ClsEEmpleado;
import Negocio.ClsNEmpleado;
import Entidad.ClsEProveedor;
import Negocio.ClsNProveedor;
import Entidad.ClsEproducto;
import Negocio.ClsNCliente;
import Negocio.ClsNProducto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HUILLCA
 */
public class FrmReportes extends javax.swing.JInternalFrame {
String fechainicio;
String fechafinal;
DefaultTableModel modelo;
    /**
     * Creates new form FrmReportes
     */
    public FrmReportes() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dffinal = new datechooser.beans.DateChooserCombo();
        dfinicio = new datechooser.beans.DateChooserCombo();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbreporte = new javax.swing.JTable();
        btnimprimir = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(26, 68, 147));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BOLETA DE REPORTES");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 260, 30));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1330, 60);

        dffinal.setCalendarBackground(new java.awt.Color(204, 255, 255));
        dffinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        dffinal.setCalendarPreferredSize(new java.awt.Dimension(441, 270));
        dffinal.setNothingAllowed(false);
        dffinal.setLocale(new java.util.Locale("pt", "BR", ""));
        dffinal.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dffinalOnCommit(evt);
            }
        });
        jPanel1.add(dffinal);
        dffinal.setBounds(560, 80, 160, 30);

        dfinicio.setCalendarBackground(new java.awt.Color(204, 255, 255));
        dfinicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        dfinicio.setCalendarPreferredSize(new java.awt.Dimension(441, 270));
        dfinicio.setNothingAllowed(false);
        dfinicio.setLocale(new java.util.Locale("pt", "BR", ""));
        dfinicio.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dfinicioOnCommit(evt);
            }
        });
        jPanel1.add(dfinicio);
        dfinicio.setBounds(190, 80, 160, 30);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 3, 89));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("FECHA INICIAL:");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 80, 160, 30);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(3, 3, 89));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("TIPO :");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(750, 80, 80, 30);

        btnbuscar.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(3, 3, 89));
        btnbuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar_35px.png"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnbuscar);
        btnbuscar.setBounds(1090, 70, 110, 80);

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLEADOS", "PRODUCTOS", "PROVEEDORES", "CLIENTES" }));
        cbotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbotipo);
        cbotipo.setBounds(840, 80, 210, 30);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(3, 3, 89));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("FECHA FINAL:");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(400, 80, 140, 30);

        tbreporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbreporte);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 160, 1230, 360);

        btnimprimir.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btnimprimir.setForeground(new java.awt.Color(3, 3, 89));
        btnimprimir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir_50px_1.png"))); // NOI18N
        btnimprimir.setText("IMPRIMIR");
        btnimprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnimprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnimprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnimprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnimprimirMouseClicked(evt);
            }
        });
        jPanel1.add(btnimprimir);
        btnimprimir.setBounds(1200, 60, 110, 90);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1330, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dffinalOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dffinalOnCommit

    }//GEN-LAST:event_dffinalOnCommit

    private void dfinicioOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dfinicioOnCommit
        // TODO add your handling code here:
    }//GEN-LAST:event_dfinicioOnCommit

    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        mtdcalcularfecha();
        if(cbotipo.getSelectedItem().equals("EMPLEADOS"))
        {
            mtdlistarempleados();
        }
        else if(cbotipo.getSelectedItem().equals("PRODUCTOS")) 
        {
            mtdlistarproductos();
        }
        else if(cbotipo.getSelectedItem().equals("PROVEEDORES")) 
        {
            mtdlistarproveedores();
        }
        else if(cbotipo.getSelectedItem().equals("CLIENTES")) 
        {
            mtdlistarclientes();
        }

    }//GEN-LAST:event_btnbuscarMouseClicked

    private void btnimprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnimprimirMouseClicked
        if(cbotipo.getSelectedItem().equals("EMPLEADOS"))
        {
            //empleado
            JasperReport repo;
            Connection con;
            try {
                Map parametro=new HashMap();
                parametro.put("fechainicio", fechainicio);
                parametro.put("fechafinal", fechafinal);
                  Class.forName("com.mysql.jdbc.Driver");
                  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_electronica","root","");
                  repo=JasperCompileManager.compileReport("src/Reportes/rpt_empleados.jrxml");
                  JasperPrint jp=JasperFillManager.fillReport(repo,parametro,con);
                  JasperViewer visor = new JasperViewer(jp,false) ;
                  visor.setVisible(true) ;
                  visor.setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE ); 
                    //ClassNotFoundException
            }
            catch (ClassNotFoundException| SQLException |JRException  ex) {
                    JOptionPane.showMessageDialog(null,"ocurrio este error"+ ex);
            }
        }
        else if(cbotipo.getSelectedItem().equals("PRODUCTOS"))
        {
            //
           //empleado
            JasperReport repo;
            Connection con;
            try {
                Map parametro=new HashMap();
                parametro.put("fechainicio", fechainicio);
                parametro.put("fechafinal", fechafinal);
                  Class.forName("com.mysql.jdbc.Driver");
                  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_electronica","root","");
                  repo=JasperCompileManager.compileReport("src/Reportes/rpt_producto.jrxml");
                  JasperPrint jp=JasperFillManager.fillReport(repo,parametro,con);
                  JasperViewer visor = new JasperViewer(jp,false) ;
                  visor.setVisible(true) ;
                  visor.setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE ); 
                    //ClassNotFoundException
            }
            catch (ClassNotFoundException| SQLException |JRException  ex) {
                    JOptionPane.showMessageDialog(null,"ocurrio este error"+ ex);
            }
        
        }
        else if(cbotipo.getSelectedItem().equals("PROVEEDORES"))
        {
            JasperReport repo;
            Connection con;
            try {
                Map parametro=new HashMap();
                parametro.put("fechainicio", fechainicio);
                parametro.put("fechafinal", fechafinal);
                  Class.forName("com.mysql.jdbc.Driver");
                  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_electronica","root","");
                  repo=JasperCompileManager.compileReport("src/Reportes/rpt_proveedores.jrxml");
                  JasperPrint jp=JasperFillManager.fillReport(repo,parametro,con);
                  JasperViewer visor = new JasperViewer(jp,false) ;
                  visor.setVisible(true) ;
                  visor.setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE ); 
                    //ClassNotFoundException
            }
            catch (ClassNotFoundException| SQLException |JRException  ex) {
                    JOptionPane.showMessageDialog(null,"ocurrio este error"+ ex);
            }
        }
        else if(cbotipo.getSelectedItem().equals("CLIENTES"))
        {
            int OP=cbotipo.getSelectedIndex();
            JOptionPane.showMessageDialog(null, String.valueOf(OP));
            //clientes  
        }
    }//GEN-LAST:event_btnimprimirMouseClicked

    private void cbotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoActionPerformed
        
    }//GEN-LAST:event_cbotipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnbuscar;
    private javax.swing.JLabel btnimprimir;
    private javax.swing.JComboBox<String> cbotipo;
    private datechooser.beans.DateChooserCombo dffinal;
    private datechooser.beans.DateChooserCombo dfinicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbreporte;
    // End of variables declaration//GEN-END:variables
    void mtdcalcularfecha()
        {
        String fecha=dfinicio.getText();
        String[] fechaDividida = fecha.split("/");
        fechainicio=fechaDividida[2]+"-"+fechaDividida[1]+"-"+fechaDividida[0];
        String fecha1=dffinal.getText();
        String[] fechaDividida1 = fecha1.split("/");
        fechafinal=fechaDividida1[2]+"-"+fechaDividida1[1]+"-"+fechaDividida1[0]; 
        }
    
    private void mtdlistarempleados() {
        mtdindicestabla();
        ClsNEmpleado objNC=new ClsNEmpleado();
        ClsEEmpleado objEC=new ClsEEmpleado();
        objEC.setFecha_inicio(fechainicio);
        objEC.setFecha_final(fechafinal);
        String[] datos=new String[11];
        for(ClsEEmpleado objE: objNC.MtdListar(objEC))
        {
            datos[0]=objE.getDni();
            datos[1]=objE.getCargo_empleadonombre();
            datos[2]=objE.getNombre();
            datos[3]=objE.getDireccion();
            datos[4]=objE.getEmail();
            datos[5]=objE.getTelefono();
            datos[6]=objE.getSexo();
            datos[7]=objE.getEstado_empleado();
            datos[8]=String.valueOf(objE.getSueldo());
            datos[9]=objE.getFecha();
            modelo.addRow(datos);

        }
        this.tbreporte.setModel(modelo);
    }
    private void mtdindicestabla()
    {
        modelo=new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("CARGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("EMAIL");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("SEXO");
        modelo.addColumn("ESTADO");
        modelo.addColumn("SUELDO");
        modelo.addColumn("FECHA INICIO");
        this.tbreporte.setModel(modelo);
        tbreporte.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = tbreporte.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(110);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(250);
        columnModel.getColumn(3).setPreferredWidth(250);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(80);
        columnModel.getColumn(9).setPreferredWidth(150);
    }
    private void mtdlistarproductos() {
        modelo=new DefaultTableModel();
        modelo.addColumn("CATEGORIA");
        modelo.addColumn("PROVEEDOR");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO C");
        modelo.addColumn("PRECIO V");
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("MARCA");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("FECHA");
        this.tbreporte.setModel(modelo);
        tbreporte.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = tbreporte.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(110);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(250);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(300);
        columnModel.getColumn(9).setPreferredWidth(100);
        ClsNProducto objNC=new ClsNProducto();
        ClsEproducto objEC=new ClsEproducto();
        objEC.setFecha_inicio(fechainicio);
        objEC.setFecha_final(fechafinal);
        String[] datos=new String[11];
        for(ClsEproducto objE: objNC.MtdListarproduct(objEC))
        {
            datos[0]=objE.getCategoria();
            datos[1]=objE.getRuc();
            datos[2]=String.valueOf(objE.getCantidad());
            datos[3]=String.valueOf(objE.getPrecio_compra());
            datos[4]=String.valueOf(objE.getPrecio_venta());
            datos[5]=objE.getCodigo();
            datos[6]=objE.getNombre();
            datos[7]=objE.getMarca();
            datos[8]=objE.getDescripcion();
            datos[9]=objE.getFecha();
            modelo.addRow(datos);

        }
        this.tbreporte.setModel(modelo);
        
        
    }

    private void mtdlistarproveedores() {
        modelo=new DefaultTableModel();
        modelo.addColumn("TIPO");
        modelo.addColumn("RUC");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CELULAR");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("EMAIL");
        modelo.addColumn("ESTADO");
        modelo.addColumn("OBSERVACION");
        modelo.addColumn("FECHA INSCRIPCION");
        this.tbreporte.setModel(modelo);
        ClsNProveedor objNC=new ClsNProveedor();
        ClsEProveedor objEC=new ClsEProveedor();
        objEC.setFecha_inicio(fechainicio);
        objEC.setFecha_final(fechafinal);
        String[] datos=new String[10];
        for(ClsEProveedor objE: objNC.Mtdbuscarproveedor(objEC))
        {
            datos[0]=objE.getTipo_proveedor();
            datos[1]=objE.getRuc();
            datos[2]=objE.getNombre();
            datos[3]=objE.getCelular();
            datos[4]=objE.getDireccion();
            datos[5]=objE.getEmail();
            datos[6]=objE.getEstado();
            datos[7]=objE.getObservacion();
            datos[8]=objE.getFecha();
            modelo.addRow(datos);
        }
        this.tbreporte.setModel(modelo);
    }

    private void mtdlistarclientes() {
        modelo=new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("EDAD");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("EMAIL");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("OBSERVACION");
        this.tbreporte.setModel(modelo);
        ClsNCliente objNC=new ClsNCliente();
        ClsECliente objEC=new ClsECliente();
        objEC.setFecha_inicio(fechainicio);
        objEC.setFecha_final(fechafinal);
        String[] datos=new String[8];
        for(ClsECliente objE: objNC.Mtdbuscarfecha(objEC))
        {
            datos[1]=objE.getDni();
            datos[2]=String.valueOf(objE.getEdad());
            datos[3]=objE.getNombre();
            datos[4]=objE.getDireccion();
            datos[5]=objE.getEmail();
            datos[6]=objE.getTelefono();
            datos[7]=objE.getObservacion();
            modelo.addRow(datos);
        }
        this.tbreporte.setModel(modelo);
    }

    private void Mtdreporteempleado() {
        
    }

    private void mtdreporteproducto() {
        JasperReport repo;
            Connection con;
        
        try {
            Map parametro=new HashMap();
            parametro.put("fechainicio", fechainicio);
            parametro.put("fechafinal", fechafinal);
              Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_electronica","root","");
              repo=JasperCompileManager.compileReport("src/Reportes/rpt_producto.jrxml");
              JasperPrint jp=JasperFillManager.fillReport(repo,parametro,con);
              JasperViewer visor = new JasperViewer(jp,false) ;
              visor.setVisible(true) ;
              visor.setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE ); 
                //ClassNotFoundException
        }
        catch (ClassNotFoundException| SQLException |JRException  ex) {
                JOptionPane.showMessageDialog(null,"ocurrio este error"+ ex);
        }
    }
}
