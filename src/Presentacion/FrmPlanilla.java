/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import javax.swing.JOptionPane;
import Negocio.ClsNPlanilla;
import Entidad.ClsEPlanilla;
import Negocio.ClsConsulta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HUILLCA
 */
public class FrmPlanilla extends javax.swing.JInternalFrame {
double seguro;
double tasa;
String estado;
    /**
     * Creates new form FrmPlanilla
     */
    public FrmPlanilla() {
        initComponents();
        mtdfecha();
        mtdcodigo();
        mtdllenarcomboseguro();
        mtdllenarcombotasa();
        
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
        pbncliente = new javax.swing.JPanel();
        txtfechaingreso = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtnombre = new javax.swing.JTextField();
        tct = new javax.swing.JSeparator();
        txtdni = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txtpuesto = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        cbomes = new javax.swing.JComboBox<>();
        btnboleta = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JLabel();
        txtfecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        txtotros = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cbotasa = new javax.swing.JComboBox<>();
        cboseguro = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txtgraficacion = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtsueldobasico = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txttotal_pagar = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btncalcular = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pbncliente.setBackground(new java.awt.Color(255, 255, 255));
        pbncliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pbncliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfechaingreso.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtfechaingreso.setForeground(new java.awt.Color(8, 91, 184));
        txtfechaingreso.setBorder(null);
        txtfechaingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaingresoActionPerformed(evt);
            }
        });
        pbncliente.add(txtfechaingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 190, 20));

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(3, 3, 89));
        jLabel12.setText("NOMBRE C.:");
        pbncliente.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(3, 3, 89));
        jLabel14.setText("DIRECCION:");
        pbncliente.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, 30));

        txtdireccion.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtdireccion.setForeground(new java.awt.Color(8, 91, 184));
        txtdireccion.setBorder(null);
        pbncliente.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 190, 20));
        pbncliente.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 190, 20));

        jLabel15.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(3, 3, 89));
        jLabel15.setText("FECHA INGRESO:");
        pbncliente.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 170, 30));
        pbncliente.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 190, 20));

        txtnombre.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(8, 91, 184));
        txtnombre.setBorder(null);
        pbncliente.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 190, 20));
        pbncliente.add(tct, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 190, 20));

        txtdni.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtdni.setForeground(new java.awt.Color(8, 91, 184));
        txtdni.setBorder(null);
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });
        pbncliente.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 190, 20));
        pbncliente.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 190, 20));

        jLabel17.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(3, 3, 89));
        jLabel17.setText("MES :");
        pbncliente.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 60, 30));

        txtpuesto.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtpuesto.setForeground(new java.awt.Color(8, 91, 184));
        txtpuesto.setBorder(null);
        pbncliente.add(txtpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 190, 20));
        pbncliente.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 190, 20));

        jLabel19.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(3, 3, 89));
        jLabel19.setText("PUESTO :");
        pbncliente.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 100, 30));

        jLabel20.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(3, 3, 89));
        jLabel20.setText("DNI:");
        pbncliente.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 30));

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar_35px.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        pbncliente.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 50, -1));

        cbomes.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cbomes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        pbncliente.add(cbomes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 190, 30));

        jPanel1.add(pbncliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 930, 130));

        btnboleta.setBackground(new java.awt.Color(255, 255, 255));
        btnboleta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnboleta.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(3, 3, 89));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("CODIGO:");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnboleta.add(jLabel23);
        jLabel23.setBounds(0, 10, 100, 23);

        jLabel24.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(3, 3, 89));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("FECHA :");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnboleta.add(jLabel24);
        jLabel24.setBounds(0, 50, 100, 23);

        txtcodigo.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtcodigo.setForeground(new java.awt.Color(0, 0, 51));
        btnboleta.add(txtcodigo);
        txtcodigo.setBounds(110, 10, 100, 30);

        txtfecha.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtfecha.setForeground(new java.awt.Color(0, 0, 51));
        btnboleta.add(txtfecha);
        txtfecha.setBounds(100, 50, 140, 30);

        jPanel1.add(btnboleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 250, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 230, 120));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel1.setText("BOLETA DE PAGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel18.setText("DESCUENTOS");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 30));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 190, 20));

        jLabel27.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(3, 3, 89));
        jLabel27.setText("SEGURO:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 80, 30));

        txtotros.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtotros.setForeground(new java.awt.Color(8, 91, 184));
        txtotros.setText("0.00");
        txtotros.setBorder(null);
        jPanel2.add(txtotros, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 190, -1));

        jLabel28.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(3, 3, 89));
        jLabel28.setText("TASA DE APORTE:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 180, 30));

        jLabel30.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(3, 3, 89));
        jLabel30.setText("OTROS :");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 80, 30));

        cbotasa.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cbotasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cbotasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotasaActionPerformed(evt);
            }
        });
        jPanel2.add(cbotasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 180, 30));

        cboseguro.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cboseguro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cboseguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseguroActionPerformed(evt);
            }
        });
        jPanel2.add(cboseguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 180, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 450, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel21.setText("PERCIBOS");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 30));

        jLabel22.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(3, 3, 89));
        jLabel22.setText("SUELDO BASICO:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 160, 30));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 190, 20));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 190, 20));

        txtgraficacion.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtgraficacion.setForeground(new java.awt.Color(8, 91, 184));
        txtgraficacion.setText("0.00");
        txtgraficacion.setBorder(null);
        jPanel3.add(txtgraficacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 190, -1));

        jLabel26.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(3, 3, 89));
        jLabel26.setText("GRATIFICACION:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 30));

        txtsueldobasico.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtsueldobasico.setForeground(new java.awt.Color(8, 91, 184));
        jPanel3.add(txtsueldobasico, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 190, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 450, 170));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttotal_pagar.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txttotal_pagar.setForeground(new java.awt.Color(3, 3, 89));
        jPanel4.add(txttotal_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 220, 30));

        jLabel31.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(3, 3, 89));
        jLabel31.setText("TOTAL NETO A PAGAR S/ :");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 290, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 860, 60));

        btncalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_calculate_50px.png"))); // NOI18N
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });
        jPanel1.add(btncalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 60, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfechaingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaingresoActionPerformed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        char []p={'1','2','3','4','5','6','7','8','9','0','.'};
        int b=0;
        for(int i=0;i<=10;i++){
            if (p[i]==evt.getKeyChar()){b=1;}

        }
        if(b==0){evt.consume();  getToolkit().beep(); }
    }//GEN-LAST:event_txtdniKeyTyped
int empleadoid;
int cargoid;
    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        ClsEPlanilla objEC=new ClsEPlanilla();
        ClsNPlanilla objNC=new ClsNPlanilla();
        objEC.setDni(txtdni.getText());
        if(!txtdni.getText().equals(""))
        {
            if(objNC.Verificardni(objEC)==true)
            {
                txtnombre.setText(objEC.getNombre());
                txtdireccion.setText(objEC.getDireccion());
                txtfechaingreso.setText(objEC.getFecha_ingreso());  
                txtpuesto.setText(objEC.getPuesto());
                txtsueldobasico.setText(String.valueOf(objEC.getSueldo()));
                estado=objEC.getEstado();
                empleadoid=objEC.getEmpleadoid();
                cargoid=objEC.getCargoid();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El empleado no se encuentra registrado");
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "debe ingresar un usuario");
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void cboseguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseguroActionPerformed
        ClsEPlanilla objEC=new ClsEPlanilla();
        ClsNPlanilla objNC=new ClsNPlanilla();
        int numero=cboseguro.getSelectedIndex();
        objEC.setSegurocod(numero);
        if(objNC.Buscarporcentajepension(objEC)==true)
        {
            seguro=objEC.getSeguro();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al calcular porcentaje");
        } 
    }//GEN-LAST:event_cboseguroActionPerformed
double totalseguro;
double totaltasa;
double totalsueldo;
double sueldob;
    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        ClsEPlanilla objEC=new ClsEPlanilla();
        ClsNPlanilla objNC=new ClsNPlanilla();
        objEC.setCodigo_planilla(txtcodigo.getText());
        objEC.setFecha_dia(txtfecha.getText());
        objEC.setEmpleadoid(empleadoid);
        objEC.setCargoid(cargoid);
        objEC.setDni(txtdni.getText());
        objEC.setEstado(estado);
        objEC.setSegurocod(cboseguro.getSelectedIndex());
        objEC.setTasacod(cbotasa.getSelectedIndex());
        sueldob=Double.parseDouble(txtsueldobasico.getText());
        totalseguro=(seguro/100)*sueldob;
        totaltasa=(tasa/100)*sueldob;
        
        if(txtgraficacion.getText().equals(""))
        {
            objEC.setGratificacion(Double.parseDouble("0.00"));
        }
        else
        {
            objEC.setGratificacion(Double.parseDouble(txtgraficacion.getText()));
        }
        if(txtotros.getText().equals(""))
        {
            objEC.setDescuento(Double.parseDouble("0.00"));
        }
        else
        {
            objEC.setDescuento(Double.parseDouble(txtotros.getText()));
        }
        objEC.setMes(cbomes.getSelectedItem().toString());
        totalsueldo=Double.parseDouble(txtgraficacion.getText())+Double.parseDouble(txtsueldobasico.getText());
        double totaldeudas=Double.parseDouble(txtotros.getText())+seguro+tasa;
        totalsueldo=totalsueldo-totaldeudas;
        objEC.setTotal(totalsueldo);
        objEC.setEstado("INACTIVO");
        if(objNC.VerificarExisteboleta(objEC)==true)
        {
            JOptionPane.showMessageDialog(null, "El usuario ya tiene una planilla ");
        }
        else 
        {
            if(objNC.VerificarEstadoEmpleado(objEC)==true)
            {
                JOptionPane.showMessageDialog(null, "El empleado se encuentra inactivo ");
            }
            else
            {
                    objNC.MtdRegistrarplanilla(objEC);
                    JOptionPane.showMessageDialog(null, "Datos Guardatos Correctamente");
                    mtlimpiarcajas();
                    mtdcodigo();
            }   
            txttotal_pagar.setText(totalsueldo+"");
        }
    }//GEN-LAST:event_btncalcularActionPerformed

    private void cbotasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotasaActionPerformed
        ClsEPlanilla objEC=new ClsEPlanilla();
        ClsNPlanilla objNC=new ClsNPlanilla();
        int numero=cbotasa.getSelectedIndex();
        objEC.setTasacod(numero);
        if(objNC.Buscarporcentajetasa(objEC)==true)
        {
            tasa=objEC.getTasa();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al calcular porcentaje");
        } 
    }//GEN-LAST:event_cbotasaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnboleta;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncalcular;
    private javax.swing.JComboBox<String> cbomes;
    private javax.swing.JComboBox<String> cboseguro;
    private javax.swing.JComboBox<String> cbotasa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel pbncliente;
    private javax.swing.JSeparator tct;
    private javax.swing.JLabel txtcodigo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdni;
    private javax.swing.JLabel txtfecha;
    private javax.swing.JTextField txtfechaingreso;
    private javax.swing.JTextField txtgraficacion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtotros;
    private javax.swing.JTextField txtpuesto;
    private javax.swing.JLabel txtsueldobasico;
    private javax.swing.JLabel txttotal_pagar;
    // End of variables declaration//GEN-END:variables

    private void mtdfecha() {
        Date date=new Date();
        DateFormat fechaHora=new SimpleDateFormat("yyyy-MM-dd ");
        txtfecha.setText(fechaHora.format(date).toString());
    }

    private void mtdcodigo() {
        int nuevoCodigo;
        int codigoAnterior = 0;
        ClsEPlanilla objEC=new ClsEPlanilla();
        ClsNPlanilla objNC=new ClsNPlanilla();
        String serie=objNC.NroSerie();
        if(serie==null)
        {
            txtcodigo.setText("100001");
        }
        else
        {
            codigoAnterior=Integer.parseInt(serie);
            nuevoCodigo=codigoAnterior + 1;
            txtcodigo.setText(String.valueOf(nuevoCodigo));
        }
    }

    private void mtdllenarcombotasa() {
        ArrayList<String> lista=new ArrayList<String>();
        lista= ClsConsulta.llenarcombotasa();
        for(int i=0;i<lista.size();i++)
        {
            cbotasa.addItem(lista.get(i));
        }
    }

    private void mtdllenarcomboseguro() {
        ArrayList<String> lista1=new ArrayList<String>();
        lista1= ClsConsulta.llenarcomboseguro();
        for(int i=0;i<lista1.size();i++)
        {
            cboseguro.addItem(lista1.get(i));
        }
    }

    private void mtlimpiarcajas() {
        txtdireccion.setText("");
        txtdni.setText("");
        txtfechaingreso.setText("");
        txtgraficacion.setText("0.00");
        txtnombre.setText("");
        txtotros.setText("0.00");
        txtpuesto.setText("");
        txtsueldobasico.setText("");
        txttotal_pagar.setText("");
    }
}