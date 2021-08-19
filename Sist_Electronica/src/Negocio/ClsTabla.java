/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import javax.swing.JTable;
import Negocio.ClsNEmpleado;
import Entidad.ClsEproducto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author HUILLCA
 */
public class ClsTabla {
public static String codigo;
public static String codigo1;

    public void vizualizartabla(JTable tbproducto) {
        tbproducto.setDefaultRenderer(Object.class, new Render());
        tbproducto.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CATEGORIA");
        modelo.addColumn("PROVEEDOR");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO VENTA");
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("MARCA");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("FECHA ");
        modelo.addColumn("IMAGEN ");
        ClsNProducto ObjN = new ClsNProducto();
        ClsEproducto ObjE = new ClsEproducto();
        ArrayList<ClsEproducto> list = ObjN.MtdListar();
        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object datos[] = new Object[14];
                ObjE = list.get(i);
                datos[0]=String.valueOf(ObjE.getId_producto());
                datos[1]=ObjE.getCategoria();
                datos[2]=ObjE.getRuc();
                datos[3]=String.valueOf(ObjE.getCantidad());
                datos[4]=String.valueOf(ObjE.getPrecio_compra());
                datos[5]=String.valueOf(ObjE.getPrecio_venta());
                datos[6]=ObjE.getCodigo();
                datos[7]=ObjE.getNombre();
                datos[8]=ObjE.getMarca();
                datos[9]=ObjE.getDescripcion();
                datos[10]=ObjE.getFecha();
                try{
                    byte[] bi = ObjE.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    datos[11] = new JLabel(imgi);

                }catch(Exception ex){
                    datos[11] = new JLabel("No imagen");
                }
                modelo.addRow(datos);
            }
            tbproducto.setModel(modelo);
            tbproducto.setRowHeight(60);
        }
    }

    public void buscartabla(JTable tbproducto) {
        tbproducto.setDefaultRenderer(Object.class, new Render());
        tbproducto.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CATEGORIA");
        modelo.addColumn("PROVEEDOR");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO VENTA");
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("MARCA");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("FECHA ");
        modelo.addColumn("IMAGEN ");
        ClsNProducto ObjN = new ClsNProducto();
        ClsEproducto ObjE = new ClsEproducto();
        ObjE.setCodigo(String.valueOf(codigo));
        ArrayList<ClsEproducto> list = ObjN.Mtdbuscar(ObjE);
        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object datos[] = new Object[14];
                ObjE = list.get(i);
                datos[0]=String.valueOf(ObjE.getId_producto());
                datos[1]=ObjE.getCategoria();
                datos[2]=ObjE.getRuc();
                datos[3]=String.valueOf(ObjE.getCantidad());
                datos[4]=String.valueOf(ObjE.getPrecio_compra());
                datos[5]=String.valueOf(ObjE.getPrecio_venta());
                datos[6]=ObjE.getCodigo();
                datos[7]=ObjE.getNombre();
                datos[8]=ObjE.getMarca();
                datos[9]=ObjE.getDescripcion();
                datos[10]=ObjE.getFecha();
                try{
                    byte[] bi = ObjE.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    datos[11] = new JLabel(imgi);

                }catch(Exception ex){
                    datos[11] = new JLabel("No imagen");
                }
                modelo.addRow(datos);
            }
            tbproducto.setModel(modelo);
            tbproducto.setRowHeight(60);
        }
    }




    
}
