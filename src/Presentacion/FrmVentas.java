/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidad.ClsEcaja;
import Negocio.ClsNcaja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HUILLCA
 */
public class FrmVentas extends javax.swing.JInternalFrame {
DefaultTableModel modelo;
int id;
String empleado;
String cliente;
String serie;

    /**
     * Creates new form FrmVentas
     */
    public FrmVentas() {
        initComponents();
        mtdlistar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btndetalle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dffinal = new datechooser.beans.DateChooserCombo();
        dfinicio = new datechooser.beans.DateChooserCombo();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbventas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(3, 3, 89));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("FECHA FINAL:");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, 30));

        btndetalle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        btndetalle.setForeground(new java.awt.Color(3, 3, 89));
        btndetalle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btndetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/vender_50px.png"))); // NOI18N
        btndetalle.setText("DETALLE");
        btndetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndetalle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndetalle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btndetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndetalleMouseClicked(evt);
            }
        });
        jPanel1.add(btndetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, 130, 70));

        jPanel3.setBackground(new java.awt.Color(26, 68, 147));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Control de Ventas");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 280, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 50));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 3, 89));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("FECHA INICIAL:");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

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
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 130, -1));

        jLabel11.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(3, 3, 89));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir_50px_1.png"))); // NOI18N
        jLabel11.setText("IMPRIMIR");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 130, 70));

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
        jPanel1.add(dffinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 230, 30));

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
        jPanel1.add(dfinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 230, 30));

        tbventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbventasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbventas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 1220, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dffinalOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dffinalOnCommit
        
    }//GEN-LAST:event_dffinalOnCommit

    private void dfinicioOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dfinicioOnCommit
        // TODO add your handling code here:
    }//GEN-LAST:event_dfinicioOnCommit
String fechainicio;
String fechafinal;
    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        String fecha=dfinicio.getText();
        String[] fechaDividida = fecha.split("/");
        fechainicio=fechaDividida[2]+"-"+fechaDividida[1]+"-"+fechaDividida[0];
        String fecha1=dffinal.getText();
        String[] fechaDividida1 = fecha1.split("/");
        fechafinal=fechaDividida1[2]+"-"+fechaDividida1[1]+"-"+fechaDividida1[0];
        modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("EMPLEADO");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("SERIE");
        modelo.addColumn("TOTAL");
        modelo.addColumn("FECHA ");
        this.tbventas.setModel(modelo);
        ClsNcaja objNC=new ClsNcaja();
        ClsEcaja objEC=new ClsEcaja();
        objEC.setFecha(fechainicio);
        objEC.setFechaf(fechafinal);
        String[] datos=new String[7];
        for(ClsEcaja objE: objNC.MtdlistarVenta(objEC))
        {
            datos[0]=String.valueOf(objE.getId());
            datos[1]=objE.getEmpleado();
            datos[2]=objE.getCliente();
            datos[3]=objE.getSerie();
            datos[4]=objE.getTotal();
            datos[5]=objE.getFecha();
            modelo.addRow(datos);
        }
        this.tbventas.setModel(modelo);
        
    }//GEN-LAST:event_btnbuscarMouseClicked

    private void btndetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndetalleMouseClicked
        if(id==0)
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
        else
        {
            Frmdetalleboleta.nombre_empleado=empleado;
            Frmdetalleboleta.nombre_cliente=cliente;
            Frmdetalleboleta.serie_comprobante=serie;
            Frmdetalleboleta.codigo=id;
            Frmdetalleboleta frm=new Frmdetalleboleta();
            FrmMenuPrincipal.DpanEscritorio.add(frm);
            frm.setVisible(true);
        }
        
    }//GEN-LAST:event_btndetalleMouseClicked

    private void tbventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbventasMouseClicked
        int seleccionar=tbventas.rowAtPoint(evt.getPoint());
        id=Integer.parseInt(String.valueOf(tbventas.getValueAt(seleccionar,0)));
        empleado=String.valueOf(tbventas.getValueAt(seleccionar,1));
        cliente=String.valueOf(tbventas.getValueAt(seleccionar,2));
        serie=String.valueOf(tbventas.getValueAt(seleccionar,3));
    }//GEN-LAST:event_tbventasMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        JasperReport repo;
            Connection con;
            try {
                Map parametro=new HashMap();
                parametro.put("fechainicio", fechainicio);
                parametro.put("fechafinal", fechafinal);
                  Class.forName("com.mysql.jdbc.Driver");
                  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_electronica","root","");
                  repo=JasperCompileManager.compileReport("src/Reportes/rpt_ventas.jrxml");
                  JasperPrint jp=JasperFillManager.fillReport(repo,parametro,con);
                  JasperViewer visor = new JasperViewer(jp,false) ;
                  visor.setVisible(true) ;
                  visor.setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE ); 
                    //ClassNotFoundException
            }
            catch (ClassNotFoundException| SQLException |JRException  ex) {
                    JOptionPane.showMessageDialog(null,"ocurrio este error"+ ex);
            }
    }//GEN-LAST:event_jLabel11MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnbuscar;
    private javax.swing.JLabel btndetalle;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserCombo dffinal;
    private datechooser.beans.DateChooserCombo dfinicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbventas;
    // End of variables declaration//GEN-END:variables

    private void mtdlistar() {
        
    }
}
