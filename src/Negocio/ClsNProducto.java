/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEEmpleado;
import Entidad.ClsEproducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HUILLCA
 */
public class ClsNProducto {

    public boolean MtdRegistrarProducto(ClsEproducto objEC) {
       try{
            String SQL="insert into tb_producto(id_categoria,id_proveedor,cantidad,precio_compra,precio_venta,codigo,nombrep,marca,descripcion,imagen,fecha_inscripcion) values (?,?,?,?,?,?,?,?,?,?,?)";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEC.getId_categoria());
            st.setInt(2, objEC.getId_proveedor());
            st.setInt(3, objEC.getCantidad());
            st.setDouble(4, objEC.getPrecio_compra());
            st.setDouble(5, objEC.getPrecio_venta());
            st.setString(6, objEC.getCodigo());
            st.setString(7, objEC.getNombre());
            st.setString(8, objEC.getMarca());
            st.setString(9, objEC.getDescripcion());
            st.setBytes(10, objEC.getImagen());
            st.setString(11, objEC.getFecha());
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean MtdModificarProducto(ClsEproducto objEC) {
    try{
            String SQL="Update tb_producto set id_categoria=?,id_proveedor=?,cantidad=?,precio_compra=?,precio_venta=?,codigo=?,nombrep=?,marca=?,descripcion=?,imagen=? WHERE id_producto=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEC.getId_categoria());
            st.setInt(2, objEC.getId_proveedor());
            st.setInt(3, objEC.getCantidad());
            st.setDouble(4, objEC.getPrecio_compra());
            st.setDouble(5, objEC.getPrecio_venta());
            st.setString(6, objEC.getCodigo());
            st.setString(7, objEC.getNombre());
            st.setString(8, objEC.getMarca());
            st.setString(9, objEC.getDescripcion());
            st.setBytes(10, objEC.getImagen());
            st.setInt(11, objEC.getId_producto());
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public ArrayList<ClsEproducto> MtdListar() {
        try {
           String SQL="SELECT c.id_producto,b.nombre,a.ruc,c.cantidad,c.precio_compra,c.precio_venta,c.codigo,c.nombrep,c.marca,c.descripcion,c.fecha_inscripcion,c.imagen "
                   + "FROM tb_producto AS c "
                   + "INNER JOIN tb_proveedor AS a ON c.id_proveedor=a.id_proveedor "
                   + "INNER JOIN tb_categoriap AS b ON c.id_categoria=b.id_categoria";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEproducto> lista=new ArrayList<>();
            ClsEproducto car;
            while(resultado.next())
            {
                car=new ClsEproducto();
                car.setId_producto(resultado.getInt("id_producto"));
                car.setCategoria(resultado.getString("nombre"));
                car.setRuc(resultado.getString("ruc"));
                car.setCantidad(resultado.getInt("cantidad"));
                car.setPrecio_compra(resultado.getDouble("precio_compra"));
                car.setPrecio_venta(resultado.getDouble("precio_venta"));
                car.setCodigo(resultado.getString("codigo"));
                car.setNombre(resultado.getString("nombrep"));
                car.setMarca(resultado.getString("marca"));
                car.setDescripcion(resultado.getString("descripcion"));
                car.setFecha(resultado.getString("fecha_inscripcion"));
                car.setImagen(resultado.getBytes("imagen"));
                
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<ClsEproducto> Mtdbuscar(ClsEproducto objEC) {
        try {
            String SQL="SELECT c.id_producto,b.nombre,a.ruc,c.cantidad,c.precio_compra,c.precio_venta,c.codigo,c.nombrep,c.marca,c.descripcion,c.fecha_inscripcion,c.imagen "
                   + "FROM tb_producto AS c "
                   + "INNER JOIN tb_proveedor AS a ON c.id_proveedor=a.id_proveedor "
                   + "INNER JOIN tb_categoriap AS b ON c.id_categoria=b.id_categoria WHERE c.codigo=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getCodigo());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEproducto> lista=new ArrayList<>();
            ClsEproducto car;
            while(resultado.next())
            {
                car=new ClsEproducto();
                car.setId_producto(resultado.getInt("id_producto"));
                car.setCategoria(resultado.getString("nombre"));
                car.setRuc(resultado.getString("ruc"));
                car.setCantidad(resultado.getInt("cantidad"));
                car.setPrecio_compra(resultado.getDouble("precio_compra"));
                car.setPrecio_venta(resultado.getDouble("precio_venta"));
                car.setCodigo(resultado.getString("codigo"));
                car.setNombre(resultado.getString("nombrep"));
                car.setMarca(resultado.getString("marca"));
                car.setDescripcion(resultado.getString("descripcion"));
                car.setFecha(resultado.getString("fecha_inscripcion"));
                car.setImagen(resultado.getBytes("imagen"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    ResultSet rs;
    public String NroSerie()
    {
        String serie="";
        try {
            String SQL="select max(codigo) from tb_producto";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            rs=st.executeQuery();
            while(rs.next())
            {
                serie=rs.getString(1);
            }
            
        } catch (Exception e) {
        }
        return serie;
        
    }

    public boolean MtdModificarProducto2(ClsEproducto objEC) {
        try{
            String SQL="Update tb_producto set id_categoria=?,id_proveedor=?,cantidad=?,precio_compra=?,precio_venta=?,codigo=?,nombrep=?,marca=?,descripcion=? WHERE id_producto=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEC.getId_categoria());
            st.setInt(2, objEC.getId_proveedor());
            st.setInt(3, objEC.getCantidad());
            st.setDouble(4, objEC.getPrecio_compra());
            st.setDouble(5, objEC.getPrecio_venta());
            st.setString(6, objEC.getCodigo());
            st.setString(7, objEC.getNombre());
            st.setString(8, objEC.getMarca());
            st.setString(9, objEC.getDescripcion());
            st.setInt(10, objEC.getId_producto());
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    } 


    public ArrayList<ClsEproducto> MtdListarproduct(ClsEproducto objEC) {
        try {
           String SQL="SELECT b.nombre,a.ruc,c.cantidad,c.precio_compra,c.precio_venta,c.codigo,c.nombrep,c.marca,c.descripcion,c.fecha_inscripcion,c.imagen "
                   + "FROM tb_producto AS c "
                   + "INNER JOIN tb_proveedor AS a ON c.id_proveedor=a.id_proveedor "
                   + "INNER JOIN tb_categoriap AS b ON c.id_categoria=b.id_categoria WHERE c.fecha_inscripcion BETWEEN ? AND ?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getFecha_inicio());
            st.setString(2, objEC.getFecha_final());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEproducto> lista=new ArrayList<>();
            ClsEproducto car;
            while(resultado.next())
            {
                car=new ClsEproducto();
                car.setCategoria(resultado.getString("nombre"));
                car.setRuc(resultado.getString("ruc"));
                car.setCantidad(resultado.getInt("cantidad"));
                car.setPrecio_compra(resultado.getDouble("precio_compra"));
                car.setPrecio_venta(resultado.getDouble("precio_venta"));
                car.setCodigo(resultado.getString("codigo"));
                car.setNombre(resultado.getString("nombrep"));
                car.setMarca(resultado.getString("marca"));
                car.setDescripcion(resultado.getString("descripcion"));
                car.setFecha(resultado.getString("fecha_inscripcion"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
