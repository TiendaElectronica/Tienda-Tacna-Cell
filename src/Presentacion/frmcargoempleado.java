/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Negocio.ClsNCargoEmpleado;
import Entidad.ClsECargoEmpleado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HUILLCA
 */
public class frmcargoempleado extends javax.swing.JInternalFrame {
int codigo;
DefaultTableModel modelo;
    /**
     * Creates new form frmcargoempleado
     */
    public frmcargoempleado() {
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

        jPanel1 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcargo = new javax.swing.JTable();
        btnregistrar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        txtcargo = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtsueldo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        lbl.setForeground(new java.awt.Color(3, 3, 89));
        lbl.setText("CARGO:");
        jPanel1.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 190, 20));

        tbcargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbcargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbcargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbcargo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, 200));

        btnregistrar.setBackground(new java.awt.Color(204, 255, 255));
        btnregistrar.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnregistrar.setForeground(new java.awt.Color(3, 3, 89));
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.png"))); // NOI18N
        btnregistrar.setText("REGISTRAR");
        btnregistrar.setHideActionText(true);
        btnregistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnregistrar.setOpaque(false);
        btnregistrar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnregistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, 80));

        btneditar.setBackground(new java.awt.Color(204, 255, 255));
        btneditar.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btneditar.setForeground(new java.awt.Color(3, 3, 89));
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btneditar.setText("EDITAR");
        btneditar.setHideActionText(true);
        btneditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditar.setOpaque(false);
        btneditar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btneditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        jPanel1.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 120, 80));

        txtcargo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtcargo.setForeground(new java.awt.Color(8, 91, 184));
        txtcargo.setBorder(null);
        jPanel1.add(txtcargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 190, 20));

        lbl1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(3, 3, 89));
        lbl1.setText("SUELDO:");
        jPanel1.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 190, 20));

        txtsueldo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtsueldo.setForeground(new java.awt.Color(8, 91, 184));
        txtsueldo.setBorder(null);
        jPanel1.add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 190, 20));

        jPanel3.setBackground(new java.awt.Color(26, 68, 147));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CARGO EMPLEADO");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbcargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbcargoMouseClicked
        int seleccionar=tbcargo.rowAtPoint(evt.getPoint());
        String codigol=String.valueOf(tbcargo.getValueAt(seleccionar,0));
        codigo=Integer.parseInt(codigol);
        txtcargo.setText(String.valueOf(tbcargo.getValueAt(seleccionar,1)));
        txtsueldo.setText(String.valueOf(tbcargo.getValueAt(seleccionar,2)));
    }//GEN-LAST:event_tbcargoMouseClicked

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        ClsECargoEmpleado objEC=new ClsECargoEmpleado();
        ClsNCargoEmpleado objNC=new ClsNCargoEmpleado();
        Date date=new Date();
        DateFormat fechaHora=new SimpleDateFormat("yyyy-MM-dd");
        objEC.setCargo(txtcargo.getText());
        objEC.setSueldo(Double.parseDouble(txtsueldo.getText()));
        objEC.setFecha(fechaHora.format(date));
        if(objNC.mtdguardarcargo(objEC)==true)
        {
            JOptionPane.showMessageDialog(null, "Datos Guardatos correctamente");
            mtdlistar();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
        }

    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        ClsECargoEmpleado objEC=new ClsECargoEmpleado();
        ClsNCargoEmpleado objNC=new ClsNCargoEmpleado();
        objEC.setId(codigo);
        objEC.setCargo(txtcargo.getText());
        objEC.setSueldo(Double.parseDouble(txtsueldo.getText()));
        if(objNC.mtdmodificargo(objEC)==true)
        {
            JOptionPane.showMessageDialog(null, "Datos MOdificados correctamente");
            mtdlistar();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
        }
    }//GEN-LAST:event_btneditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JTable tbcargo;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables

    private void mtdlistar() {
        modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CARGO");
        modelo.addColumn("SUELDO");
        modelo.addColumn("FECHA");
        this.tbcargo.setModel(modelo);
        ClsNCargoEmpleado objNC=new ClsNCargoEmpleado();
        String[] datos=new String[4];
        for(ClsECargoEmpleado objE: objNC.MtdListar())
        {
            datos[0]=String.valueOf(objE.getId());
            datos[1]=objE.getCargo();
            datos[2]=String.valueOf(objE.getSueldo());
            datos[3]=objE.getFecha();
            modelo.addRow(datos);
        }
        this.tbcargo.setModel(modelo);
    }
}
