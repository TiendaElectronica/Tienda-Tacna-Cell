/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Entidad.ClsEProveedor;
import Negocio.ClsNProveedor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author HUILLCA
 */
public class FrmAgregarProveedores extends javax.swing.JInternalFrame {
DefaultTableModel modelo;
    /**
     * Creates new form FrmAgregarProveedores
     */
    public FrmAgregarProveedores() {
        initComponents();
        mtdlistar();
        //txtid.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoestado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnregistrar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbregistro = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cbotipo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        txtemail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtruc = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        rbtninactivo = new javax.swing.JRadioButton();
        rbtnactivo = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtobservacion = new javax.swing.JTextArea();
        txtid = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(26, 68, 147));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregistrar.setBackground(new java.awt.Color(204, 255, 255));
        btnregistrar.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnregistrar.setForeground(new java.awt.Color(3, 3, 89));
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar_proveedor_50px.png"))); // NOI18N
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
        jPanel2.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 160, 80));

        btnnuevo.setBackground(new java.awt.Color(204, 255, 255));
        btnnuevo.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(3, 3, 89));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar_50px.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.setHideActionText(true);
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setOpaque(false);
        btnnuevo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 80));

        btncancelar.setBackground(new java.awt.Color(204, 255, 255));
        btncancelar.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(3, 3, 89));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar_50px.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.setHideActionText(true);
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelar.setOpaque(false);
        btncancelar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 170, 80));

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
        jPanel2.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 160, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 880, 130));

        tbregistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbregistroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbregistro);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 880, 260));

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar_35px.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, 40));
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 370, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(3, 3, 89));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("FILTRAR PROVEEDORES:");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 190, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTABLE", "ASOCIADO" }));
        jPanel4.add(cbotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 190, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 190, 20));

        txtemail.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtemail.setForeground(new java.awt.Color(8, 91, 184));
        txtemail.setBorder(null);
        jPanel4.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 190, 20));

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(3, 3, 89));
        jLabel11.setText("TIPO PROVEEDOR:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(3, 3, 89));
        jLabel12.setText("SOCIEDAD:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, 30));

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(3, 3, 89));
        jLabel13.setText("CELULAR:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(3, 3, 89));
        jLabel14.setText("DIRECCION:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, 30));

        txtdireccion.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtdireccion.setForeground(new java.awt.Color(8, 91, 184));
        txtdireccion.setBorder(null);
        jPanel4.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 190, 20));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 190, 20));

        jLabel15.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(3, 3, 89));
        jLabel15.setText("EMAIL:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 70, 30));

        txtcelular.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtcelular.setForeground(new java.awt.Color(8, 91, 184));
        txtcelular.setBorder(null);
        txtcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelularKeyTyped(evt);
            }
        });
        jPanel4.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 190, 20));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 190, 20));

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(3, 3, 89));
        jLabel16.setText("ESTADO:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 80, 30));

        txtnombre.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(8, 91, 184));
        txtnombre.setBorder(null);
        jPanel4.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 190, 20));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 190, 20));

        txtruc.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtruc.setForeground(new java.awt.Color(8, 91, 184));
        txtruc.setBorder(null);
        jPanel4.add(txtruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 190, 20));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 190, 20));

        jLabel18.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(3, 3, 89));
        jLabel18.setText("RUC:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, 30));

        grupoestado.add(rbtninactivo);
        rbtninactivo.setText("INACTIVO");
        jPanel4.add(rbtninactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 130, -1));

        grupoestado.add(rbtnactivo);
        rbtnactivo.setText("ACTIVO");
        jPanel4.add(rbtnactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 130, -1));

        jLabel17.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(3, 3, 89));
        jLabel17.setText("OBSERVACION:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 140, 30));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 200, 20));

        txtobservacion.setColumns(20);
        txtobservacion.setRows(5);
        txtobservacion.setBorder(null);
        txtobservacion.setOpaque(false);
        jScrollPane2.setViewportView(txtobservacion);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 200, 80));

        txtid.setBorder(null);
        jPanel4.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 90, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 400, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        mtdlimpiarcajas();
        mtdlistar();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        
        Date date=new Date();
        DateFormat fechaHora=new SimpleDateFormat("yyyy-MM-dd");
        ClsEProveedor objEC=new ClsEProveedor();
        ClsNProveedor objNC=new ClsNProveedor();
        if(!txtruc.getText().equals("")&& !txtnombre.equals("") && !txtcelular.getText().equals("")&& !txtdireccion.equals("") && !txtemail.getText().equals(""))
        {
            String tipo=String.valueOf(cbotipo.getSelectedItem());
        
        objEC.setTipo_proveedor(tipo); 
        objEC.setRuc(txtruc.getText());
        objEC.setNombre(txtnombre.getText());
        objEC.setCelular(txtcelular.getText());
        objEC.setDireccion(txtdireccion.getText());
        objEC.setEmail(txtemail.getText());
        if(rbtnactivo.isSelected()==true)
        {
            objEC.setEstado("ACTIVO");
        }
        else if(rbtninactivo.isSelected()==true)
        {
            objEC.setEstado("INACTIVO");
        }
        objEC.setObservacion(txtobservacion.getText());
        objEC.setFecha(fechaHora.format(date).toString());
        if(objNC.VerificarExiste(objEC)==true)
        {
                JOptionPane.showMessageDialog(null, "El Nro de RUC ya existe");
        }
        else
        {
            try {
                objNC.MtdRegistrarProveedor(objEC);
                JOptionPane.showMessageDialog(null, "Datos Guardatos Correctamente");
                mtdlimpiarcajas();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        mtdlistar();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Existen datos vacios");
        }
        
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void txtcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyTyped
        char []p={'1','2','3','4','5','6','7','8','9','0','.'};
        int b=0;
        for(int i=0;i<=10;i++){
        if (p[i]==evt.getKeyChar()){b=1;}
 
        }
        if(b==0){evt.consume();  getToolkit().beep(); }
    }//GEN-LAST:event_txtcelularKeyTyped

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        try {
            ClsEProveedor objEC=new ClsEProveedor();
            ClsNProveedor objNC=new ClsNProveedor();
            if(!txtruc.getText().equals("")&& !txtnombre.equals("") && !txtcelular.getText().equals("")&& !txtdireccion.equals("") && !txtemail.getText().equals(""))
            {
            objEC.setId(Integer.parseInt(txtid.getText()));
            String tipo=String.valueOf(cbotipo.getSelectedItem());
            objEC.setTipo_proveedor(tipo); 
            objEC.setRuc(txtruc.getText());
            objEC.setNombre(txtnombre.getText());
            objEC.setCelular(txtcelular.getText());
            objEC.setDireccion(txtdireccion.getText());
            objEC.setEmail(txtemail.getText());
            if(rbtnactivo.isSelected()==true)
            {
                objEC.setEstado("ACTIVO");
            }
            else if(rbtninactivo.isSelected()==true)
            {
                objEC.setEstado("INACTIVO");
            }
            objEC.setObservacion(txtobservacion.getText());
            try {
                int respuesta = JOptionPane.showConfirmDialog(this, "Desea modificar?","Confirmacion"
                ,JOptionPane.YES_NO_OPTION);
                if (respuesta==0) 
                {
                     if(objNC.MtdModificarproveedor(objEC)==true)
                        {
                            JOptionPane.showMessageDialog(null, "Datos Modificados Correctamente");
                            mtdlimpiarcajas();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Error datos erroneos");
                        }
                }
                else
                {
                        mtdlimpiarcajas();
                }
                    mtdlimpiarcajas();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Existen datos vacios");
            }
            mtdlistar();
        } catch (Exception e) {
        }
            

    }//GEN-LAST:event_btneditarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        mtdbuscar();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void tbregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbregistroMouseClicked
        int seleccionar=tbregistro.rowAtPoint(evt.getPoint());
        txtid.setText(String.valueOf(tbregistro.getValueAt(seleccionar,0)));
        cbotipo.setSelectedItem(tbregistro.getValueAt(seleccionar,1));
        txtruc.setText(String.valueOf(tbregistro.getValueAt(seleccionar,2)));
        txtnombre.setText(String.valueOf(tbregistro.getValueAt(seleccionar,3)));
        txtcelular.setText(String.valueOf(tbregistro.getValueAt(seleccionar,4)));
        txtdireccion.setText(String.valueOf(tbregistro.getValueAt(seleccionar,5)));
        txtemail.setText(String.valueOf(tbregistro.getValueAt(seleccionar,6)));
        txtobservacion.setText(String.valueOf(tbregistro.getValueAt(seleccionar,8)));
    }//GEN-LAST:event_tbregistroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.ButtonGroup grupoestado;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JRadioButton rbtnactivo;
    private javax.swing.JRadioButton rbtninactivo;
    private javax.swing.JTable tbregistro;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextArea txtobservacion;
    private javax.swing.JTextField txtruc;
    // End of variables declaration//GEN-END:variables

    private void mtdlimpiarcajas() {
        txtbuscar.setText("");
        txtcelular.setText("");
        txtdireccion.setText("");
        txtemail.setText("");
        txtnombre.setText("");
        txtobservacion.setText("");
        txtruc.setText("");
    }

    private void mtdlistar() {
        modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("TIPO");
        modelo.addColumn("RUC");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CELULAR");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("EMAIL");
        modelo.addColumn("ESTADO");
        modelo.addColumn("OBSERVACION");
        modelo.addColumn("FECHA INSCRIPCION");
        this.tbregistro.setModel(modelo);
        ClsNProveedor objNC=new ClsNProveedor();
        String[] datos=new String[10];
        for(ClsEProveedor objE: objNC.Mtdlistar())
        {
            datos[0]=String.valueOf(objE.getId());
            datos[1]=objE.getTipo_proveedor();
            datos[2]=objE.getRuc();
            datos[3]=objE.getNombre();
            datos[4]=objE.getCelular();
            datos[5]=objE.getDireccion();
            datos[6]=objE.getEmail();
            datos[7]=objE.getEstado();
            datos[8]=objE.getObservacion();
            datos[9]=objE.getFecha();
            modelo.addRow(datos);
        }
        this.tbregistro.setModel(modelo);
    }

    private void mtdbuscar() {
        modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("TIPO");
        modelo.addColumn("RUC");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CELULAR");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("EMAIL");
        modelo.addColumn("ESTADO");
        modelo.addColumn("OBSERVACION");
        modelo.addColumn("FECHA INSCRIPCION");
        this.tbregistro.setModel(modelo);
        ClsNProveedor objNC=new ClsNProveedor();
        ClsEProveedor objEC=new ClsEProveedor();
        objEC.setRuc(txtbuscar.getText());
        String[] datos=new String[10];
        for(ClsEProveedor objE: objNC.Mtdbuscar(objEC))
        {
            datos[0]=String.valueOf(objE.getId());
            datos[1]=objE.getTipo_proveedor();
            datos[2]=objE.getRuc();
            datos[3]=objE.getNombre();
            datos[4]=objE.getCelular();
            datos[5]=objE.getDireccion();
            datos[6]=objE.getEmail();
            datos[7]=objE.getEstado();
            datos[8]=objE.getObservacion();
            datos[9]=objE.getFecha();
            modelo.addRow(datos);
        }
        this.tbregistro.setModel(modelo);
        
    }
}
