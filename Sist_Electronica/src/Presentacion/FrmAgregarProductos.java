/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Negocio.ClsConsulta;
import Entidad.ClsEproducto;
import Negocio.ClsNProducto;
import Negocio.ClsTabla;
import com.mysql.cj.xdevapi.JsonParser;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HUILLCA
 */
public class FrmAgregarProductos extends javax.swing.JInternalFrame {
DefaultTableModel modelo;
String id;
File ruta;
Image IMG;
    /**
     * Creates new form FrmAgregarProductos
     */
    public FrmAgregarProductos() {
        initComponents();
        cboproveedor.removeAllItems();
        cbotipo.removeAllItems();
        cbotipo.addItem("Seleccione ");
        cboproveedor.addItem("Seleccione ");
        mtdmostrarcombo();
        mtdllenarcombocategoria();
        mtdgenerarcodigo();
        mtdlistar();
        bloquear();
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
        jLabel1 = new javax.swing.JLabel();
        pbldatos = new javax.swing.JPanel();
        cboproveedor = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        txtnomrbe = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcompra = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtstock = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        sss = new javax.swing.JSeparator();
        txtventa = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnagregarimagen = new javax.swing.JButton();
        txtruta = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtcodigo = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbproducto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btneditar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 290, 30));

        pbldatos.setBackground(new java.awt.Color(255, 255, 255));
        pbldatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pbldatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboproveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pbldatos.add(cboproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 190, 30));
        pbldatos.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 190, 20));

        txtnomrbe.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtnomrbe.setForeground(new java.awt.Color(8, 91, 184));
        txtnomrbe.setBorder(null);
        pbldatos.add(txtnomrbe, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, 20));

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(3, 3, 89));
        jLabel11.setText("TIPO:");
        pbldatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 30));

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(3, 3, 89));
        jLabel12.setText("STOCK:");
        pbldatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 30));

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(3, 3, 89));
        jLabel13.setText("NOMBRE :");
        pbldatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, 30));

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(3, 3, 89));
        jLabel14.setText("DESCRIPCION:");
        pbldatos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 30));

        txtcompra.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtcompra.setForeground(new java.awt.Color(8, 91, 184));
        txtcompra.setBorder(null);
        txtcompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcompraKeyTyped(evt);
            }
        });
        pbldatos.add(txtcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 90, 20));
        pbldatos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 90, 20));

        txtstock.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtstock.setForeground(new java.awt.Color(8, 91, 184));
        txtstock.setBorder(null);
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });
        pbldatos.add(txtstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 190, 20));
        pbldatos.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, 20));

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(3, 3, 89));
        jLabel16.setText("VENTA :");
        pbldatos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, 30));

        jLabel18.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(3, 3, 89));
        jLabel18.setText("PROVEEDOR :");
        pbldatos.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 40));

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pbldatos.add(cbotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 190, 30));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        jScrollPane1.setViewportView(txtdescripcion);

        pbldatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 190, -1));

        jLabel17.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(3, 3, 89));
        jLabel17.setText("MARCA  :");
        pbldatos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 30));

        txtmarca.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtmarca.setForeground(new java.awt.Color(8, 91, 184));
        txtmarca.setBorder(null);
        pbldatos.add(txtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 190, 20));
        pbldatos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 340, 10));
        pbldatos.add(sss, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 90, 20));

        txtventa.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtventa.setForeground(new java.awt.Color(8, 91, 184));
        txtventa.setBorder(null);
        txtventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtventaKeyTyped(evt);
            }
        });
        pbldatos.add(txtventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 90, 20));

        jLabel19.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(3, 3, 89));
        jLabel19.setText("COMPRA:");
        pbldatos.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        jLabel15.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(3, 3, 89));
        jLabel15.setText("CODIGO :");
        pbldatos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, 30));
        pbldatos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 190, 20));

        btnagregarimagen.setBackground(new java.awt.Color(204, 255, 255));
        btnagregarimagen.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnagregarimagen.setForeground(new java.awt.Color(3, 3, 89));
        btnagregarimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar_50px.png"))); // NOI18N
        btnagregarimagen.setText("AGREGAR IMAGEN");
        btnagregarimagen.setHideActionText(true);
        btnagregarimagen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnagregarimagen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnagregarimagen.setOpaque(false);
        btnagregarimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarimagenActionPerformed(evt);
            }
        });
        pbldatos.add(btnagregarimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 220, 50));
        pbldatos.add(txtruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 340, 30));
        pbldatos.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 190, 20));

        txtcodigo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtcodigo.setForeground(new java.awt.Color(8, 91, 184));
        pbldatos.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 20));

        jPanel1.add(pbldatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 460));
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 370, 40));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar_35px.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 80, -1, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(3, 3, 89));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("AGREGAR DATOS :");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        tbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproductoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbproducto);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 840, 320));

        jPanel3.setBackground(new java.awt.Color(26, 68, 147));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 50));

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
        jPanel1.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, 180, 80));

        btnnuevo.setBackground(new java.awt.Color(204, 255, 255));
        btnnuevo.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(3, 3, 89));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
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
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 180, 80));

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
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 460, 180, 80));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 3, 89));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("FILTRAR PRODUCTOS POR CODIGO:");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 240, 40));

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
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 180, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        desbloquear();
        mtdlimpiarcajas();
        txtmarca.setText("");
        txtdescripcion.setText("");
        txtcompra.setText("");
        txtnomrbe.setText("");
        txtstock.setText("");
        txtventa.setText("");
        mtdlistar();
        mtdgenerarcodigo();
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    void bloquear(){
        for(Component a: pbldatos.getComponents())
        {
            a.setEnabled(false);
        }
    }
    void desbloquear(){
        for(Component a: pbldatos.getComponents())
        {
            a.setEnabled(true);
        }
    }
    
    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        ClsEproducto objEC=new ClsEproducto();
        ClsNProducto objNC=new ClsNProducto();
        Date date=new Date();
        DateFormat fechaHora=new SimpleDateFormat("yyyy-MM-dd");
        int tipoproducto =  cbotipo.getSelectedIndex();
        int tipoproveedor = cboproveedor.getSelectedIndex();
        if(!txtnomrbe.getText().equals("")&& !txtstock.equals("") && !txtcompra.getText().equals("")&& !txtdescripcion.equals("") && !txtmarca.getText().equals("") && !txtventa.getText().equals(""))
        {
            objEC.setId_categoria(tipoproducto);
            objEC.setId_proveedor(tipoproveedor);
            objEC.setCantidad(Integer.parseInt(txtstock.getText()));
            objEC.setPrecio_compra(Double.parseDouble(txtcompra.getText()));
            objEC.setPrecio_venta(Double.parseDouble(txtventa.getText()));
            objEC.setNombre(txtnomrbe.getText());
            objEC.setCodigo(txtcodigo.getText());
            objEC.setMarca(txtmarca.getText());
            objEC.setDescripcion(txtdescripcion.getText());
            File ruta = new File(txtruta.getText());
            try{
                byte[] icono = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(icono);
                objEC.setImagen(icono);
            }catch(Exception ex){
                objEC.setImagen(null);
            }
            objEC.setFecha(fechaHora.format(date));
            if(objNC.MtdRegistrarProducto(objEC)==true)
            {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                mtdgenerarcodigo();
                mtdlimpiarcajas();
                mtdlistar();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error de datos ");
            }
            mtdlistar();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        }
        

    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnagregarimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarimagenActionPerformed
        buscarimagen();
    }//GEN-LAST:event_btnagregarimagenActionPerformed

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
        char []p={'1','2','3','4','5','6','7','8','9','0','.'};
        int b=0;
        for(int i=0;i<=10;i++){
        if (p[i]==evt.getKeyChar()){b=1;}
 
        }
        if(b==0){evt.consume();  getToolkit().beep(); }
    }//GEN-LAST:event_txtstockKeyTyped

    private void txtcompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcompraKeyTyped
        char []p={'1','2','3','4','5','6','7','8','9','0','.'};
        int b=0;
        for(int i=0;i<=10;i++){
        if (p[i]==evt.getKeyChar()){b=1;}
 
        }
        if(b==0){evt.consume();  getToolkit().beep(); }
    }//GEN-LAST:event_txtcompraKeyTyped

    private void txtventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtventaKeyTyped
        char []p={'1','2','3','4','5','6','7','8','9','0','.'};
        int b=0;
        for(int i=0;i<=10;i++){
        if (p[i]==evt.getKeyChar()){b=1;}
 
        }
        if(b==0){evt.consume();  getToolkit().beep(); }
    }//GEN-LAST:event_txtventaKeyTyped

    private void tbproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproductoMouseClicked
        int seleccionar=tbproducto.rowAtPoint(evt.getPoint());
        id=String.valueOf(tbproducto.getValueAt(seleccionar,0));
        cbotipo.setSelectedItem(tbproducto.getValueAt(seleccionar,1));
        cboproveedor.setSelectedItem(tbproducto.getValueAt(seleccionar,2));
        txtstock.setText(String.valueOf(tbproducto.getValueAt(seleccionar,3)));
        txtcompra.setText(String.valueOf(tbproducto.getValueAt(seleccionar,4)));
        txtventa.setText(String.valueOf(tbproducto.getValueAt(seleccionar,5)));
        txtcodigo.setText(String.valueOf(tbproducto.getValueAt(seleccionar,6)));
        txtnomrbe.setText(String.valueOf(tbproducto.getValueAt(seleccionar,7)));
        txtmarca.setText(String.valueOf(tbproducto.getValueAt(seleccionar,8)));
        txtdescripcion.setText(String.valueOf(tbproducto.getValueAt(seleccionar,9)));
    }//GEN-LAST:event_tbproductoMouseClicked

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        ClsEproducto objEC=new ClsEproducto();
        ClsNProducto objNC=new ClsNProducto();
        int tipoproducto =  cbotipo.getSelectedIndex();
        int tipoproveedor = cboproveedor.getSelectedIndex();
        if(!txtnomrbe.getText().equals("")&& !txtstock.equals("") && !txtcompra.getText().equals("")&& !txtdescripcion.equals("") && !txtmarca.getText().equals("") && !txtventa.getText().equals(""))
        {
            objEC.setId_producto(Integer.parseInt(id));
            objEC.setId_categoria(tipoproducto);
            objEC.setId_proveedor(tipoproveedor);
            objEC.setCantidad(Integer.parseInt(txtstock.getText()));
            objEC.setPrecio_compra(Double.parseDouble(txtcompra.getText()));
            objEC.setPrecio_venta(Double.parseDouble(txtventa.getText()));
            objEC.setCodigo(txtcodigo.getText());
            objEC.setNombre(txtnomrbe.getText());
            objEC.setMarca(txtmarca.getText());
            objEC.setDescripcion(txtdescripcion.getText());
            File ruta = new File(txtruta.getText());
            if(ruta!=null){
                try{
                    byte[] icono = new byte[(int) ruta.length()];
                    InputStream input = new FileInputStream(ruta);
                    input.read(icono);
                    objEC.setImagen(icono);
                }catch(Exception ex){
                    objEC.setImagen(null);
                }
                if(objNC.MtdModificarProducto(objEC)==true)
                {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    mtdlimpiarcajas();
                    mtdgenerarcodigo();
                    mtdlistar();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error de datos ");
                }
                mtdlistar();
            }else{
                if(objNC.MtdModificarProducto2(objEC)==true)
                {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    mtdlimpiarcajas();
                    mtdgenerarcodigo();
                    mtdlistar();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error de datos ");
                }
                mtdlistar();
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        txtmarca.setText("");
        txtdescripcion.setText("");
        txtcompra.setText("");
        txtnomrbe.setText("");
        txtstock.setText("");
        txtventa.setText("");
        txtruta.setText("");
        mtdlistar();
        mtdgenerarcodigo();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        mtdbuscar();
    }//GEN-LAST:event_jButton6ActionPerformed
    private void buscarimagen()
    {
        JFileChooser carpeta=new JFileChooser();
        carpeta.setDialogTitle("Selecionar Foto de producto");
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        carpeta.setFileFilter(fil);
        File rutacarpeta= new File("");
        carpeta.setCurrentDirectory(rutacarpeta);
        int ventana=carpeta.showOpenDialog(carpeta);
        if(ventana==JFileChooser.APPROVE_OPTION)
        {
            ruta=carpeta.getSelectedFile();
            IMG=getToolkit().getImage(String.valueOf(String.valueOf(ruta)));
            txtruta.setText(String.valueOf(ruta));
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarimagen;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox<String> cboproveedor;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel pbldatos;
    private javax.swing.JSeparator sss;
    private javax.swing.JTable tbproducto;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JLabel txtcodigo;
    private javax.swing.JTextField txtcompra;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtnomrbe;
    private javax.swing.JLabel txtruta;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables

    private void mtdlistar() { 
        ClsTabla objNC=new ClsTabla();
        objNC.vizualizartabla(tbproducto);
        
    }

    private void mtdmostrarcombo() {
        ArrayList<String> lista=new ArrayList<String>();
        lista= ClsConsulta.llenarcomboproveedor();
        for(int i=0;i<lista.size();i++)
        {
            cboproveedor.addItem(lista.get(i));
        }
 
    }

    private void mtdllenarcombocategoria() {
        ArrayList<String> lista1=new ArrayList<String>();
        lista1= ClsConsulta.llenarcombocategoria();
        for(int i=0;i<lista1.size();i++)
        {
            cbotipo.addItem(lista1.get(i));
        }
    }

    private void mtdlimpiarcajas() {
        txtmarca.setText("");
        txtdescripcion.setText("");
        txtcompra.setText("");
        txtnomrbe.setText("");
        txtstock.setText("");
        txtventa.setText("");
        txtruta.setText("");
    }

    private void mtdbuscar() {
        ClsTabla.codigo=txtcodigo.getText();
        ClsTabla objNC=new ClsTabla();
        objNC.buscartabla(tbproducto);
    }

    private void mtdgenerarcodigo() {
        ClsEproducto objEC=new ClsEproducto();
        ClsNProducto objNC=new ClsNProducto();
        String serie=objNC.NroSerie();
        if(serie==null)
        {
            txtcodigo.setText("0000001");
        }
        else
        {
            int incremento=Integer.parseInt(serie);
            incremento=incremento+1;
            txtcodigo.setText("000000"+incremento);
        }
    }
}