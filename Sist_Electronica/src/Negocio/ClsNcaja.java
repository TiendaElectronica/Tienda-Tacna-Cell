/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

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
public class ClsNcaja {



    public ArrayList<ClsEproducto> Mtdlistarfecha(ClsEproducto objEC) {
        try {
            String SQL="SELECT c.id_producto,b.nombre,a.ruc,c.cantidad,c.precio_compra,c.precio_venta,c.nombrep,c.marca,c.descripcion,c.fecha_inscripcion "
                   + "FROM tb_producto AS c "
                   + "INNER JOIN tb_proveedor AS a ON c.id_proveedor=a.id_proveedor "
                   + "INNER JOIN tb_categoriap AS b ON c.id_categoria=b.id_categoria WHERE c.fecha_inscripcion=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getFecha());
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
                car.setNombre(resultado.getString("nombrep"));
                car.setMarca(resultado.getString("marca"));
                car.setDescripcion(resultado.getString("descripcion"));
                car.setFecha(resultado.getString("fecha_inscripcion"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
