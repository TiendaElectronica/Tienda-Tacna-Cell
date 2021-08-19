/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Entidad.ClsEIniciosesion;
import Negocio.ClsNinicioSesion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import rojeru_san.RSPanelsSlider;
import rojerusan.RSNotifyFade;

/**
 *
 * @author HUILLCA
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        //para quitar los botones del cerrar
        this.setUndecorated(true);
        initComponents();
        //centrar la ventana
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow2 = new rojeru_san.RSPanelShadow();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        btncerrar = new rojeru_san.RSButton();
        pnlsesion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new rojeru_san.RSMTextFull();
        txtcontraseña = new rojeru_san.RSMPassView();
        btningresar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 113, 52));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/logo.png"))); // NOI18N
        jLabel3.setText("LOGO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 229, 138));

        rSPanelShadow2.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 280, 330));

        jPanel1.setBackground(new java.awt.Color(26, 68, 147));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncerrar.setBackground(new java.awt.Color(119, 201, 0));
        btncerrar.setText("x");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 40, 40));

        pnlsesion.setBackground(new java.awt.Color(255, 255, 255));
        pnlsesion.setName("pnlsesion"); // NOI18N
        pnlsesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 112, 192));
        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 112, 192));
        jLabel1.setText("Iniciar Sesion");
        pnlsesion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txtusuario.setModoMaterial(true);
        txtusuario.setPlaceholder("Usuario");
        pnlsesion.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, -1));

        txtcontraseña.setModoMaterial(true);
        txtcontraseña.setPlaceholder("Constraseña");
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        pnlsesion.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, -1));

        btningresar.setBackground(new java.awt.Color(3, 3, 89));
        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        pnlsesion.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 200, -1));

        jPanel1.add(pnlsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 290, 250));

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        Date date=new Date();
        DateFormat fechaHora=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ClsEIniciosesion objEC=new ClsEIniciosesion();
        ClsNinicioSesion objNC=new ClsNinicioSesion();
        String pass=new String(txtcontraseña.getPassword());
        if(!txtusuario.getText().equals("")&& !pass.equals(""))
        {
            objEC.setUsuario(txtusuario.getText());
            objEC.setClave(pass);
            objEC.setEstado("ACTIVO");
            objEC.setFecha(fechaHora.format(date).toString());
            if(objNC.MtdLogueoEmpleado(objEC)==true)
            {
                this.dispose();
                FrmMenuPrincipal frm=new FrmMenuPrincipal(objEC);
                frm.show();
            }else
            {
                new rojerusan.RSNotifyFade("!ERROR¡", "Datos Incorrectos", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.ERROR).setVisible(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }
        

    }//GEN-LAST:event_btningresarActionPerformed

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btncerrar;
    private rojeru_san.RSButtonRiple btningresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlsesion;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private rojeru_san.RSPanelShadow rSPanelShadow2;
    private rojeru_san.RSMPassView txtcontraseña;
    private rojeru_san.RSMTextFull txtusuario;
    // End of variables declaration//GEN-END:variables
}
