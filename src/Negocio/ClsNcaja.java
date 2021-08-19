/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEcaja;
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

    public ArrayList<ClsEcaja> MtdlistarVentafecha(ClsEcaja objEC) {
        try {
            String SQL="SELECT a.id_venta,b.nombre,c.nombrec,a.numero_serie,a.monto,a.fecha_venta "
                    + "FROM tb_venta AS a "
                    + "INNER JOIN tb_empleado AS b ON a.id_empleado=b.id_empleado "
                    + "INNER JOIN tb_cliente AS c ON a.id_cliente=c.id_cliente WHERE a.fecha_venta=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getFecha());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEcaja> lista=new ArrayList<>();
            ClsEcaja car;
            while(resultado.next())
            {
                car=new ClsEcaja();
                car.setId(resultado.getInt("id_venta"));
                car.setEmpleado(resultado.getString("nombre"));
                car.setCliente(resultado.getString("nombrec"));
                car.setSerie(resultado.getString("numero_serie"));
                car.setTotal(resultado.getString("monto"));
                car.setFecha(resultado.getString("fecha_venta"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean Verificarexistecaja(ClsEcaja objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_caja WHERE fecha=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getFecha());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getFecha().equals(rs.getString(1)))
                {
                    return true;
                }
                else
                {
                return false;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void Agregarcaja(ClsEcaja objEC) {
        try{
            String SQL="insert into tb_caja(fecha,hora_apertura,id_empleado,inicio,estado) values (?,?,?,?,?) ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getFecha());
            st.setString(2, objEC.getHora_acaja());
            st.setInt(3, objEC.getEmpleadoid());
            st.setDouble(4, objEC.getCantidad_inicio());
            st.setString(5, objEC.getEstado_caja());
            st.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"A "+ex.getMessage() );
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"B "+ex.getMessage() );
        }finally{
            try{
            }catch(Exception ex){}
        }
    }

    public boolean Cerrarcaja(ClsEcaja objEC) {
        try {
            String SQL="update tb_caja set hora_cierre=?, salida=?, entrada=?, total=?, estado=?  where fecha=? AND id_empleado=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getHora_ccaja());
            st.setDouble(2, objEC.getCantidad_entrada());
            st.setDouble(3, objEC.getCantidad_entrada());
            st.setDouble(4, objEC.getTotal_caja());
            st.setString(5, objEC.getEstado_caja());
            st.setString(6, objEC.getFecha());
            st.setInt(7, objEC.getEmpleadoid());
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

    public boolean Verificarexistecaja_empleado(ClsEcaja objEC) {
       PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_caja WHERE fecha=? OR id_empleado=? ;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getFecha());
            ps.setInt(2,objEC.getEmpleadoid());
            rs=ps.executeQuery();
            if(rs.next())
            {  
                return true;
            }
            else
            {
            return false;
            }
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean VerificarEstadocaja(ClsEcaja objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_caja Where estado=? AND fecha=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getEstado_caja());
            ps.setString(2,objEC.getFecha());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getEstado_caja().equals(rs.getString(9)))  
                {
                    return true;
                }
                else
                {
                return false;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        } 
    }

    public ArrayList<ClsEcaja> MtdlistarVenta(ClsEcaja objEC) {
        try {
            String SQL="SELECT a.id_venta,b.nombre,c.nombrec,a.numero_serie,a.monto,a.fecha_venta "
                    + "FROM tb_venta AS a "
                    + "INNER JOIN tb_empleado AS b ON a.id_empleado=b.id_empleado "
                    + "INNER JOIN tb_cliente AS c ON a.id_cliente=c.id_cliente WHERE a.fecha_venta BETWEEN ? AND ?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getFecha());
            st.setString(2, objEC.getFechaf());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEcaja> lista=new ArrayList<>();
            ClsEcaja car;
            while(resultado.next())
            {
                car=new ClsEcaja();
                car.setId(resultado.getInt("id_venta"));
                car.setEmpleado(resultado.getString("nombre"));
                car.setCliente(resultado.getString("nombrec"));
                car.setSerie(resultado.getString("numero_serie"));
                car.setTotal(resultado.getString("monto"));
                car.setFecha(resultado.getString("fecha_venta"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean cargarimporte(ClsEcaja objEC) {
        PreparedStatement ps=null;
            ResultSet rs=null;
            Connection con=ClsConexion.Conectar();
        String sql="SELECT inicio FROM tb_caja WHERE fecha=? AND id_empleado=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getFecha());
            ps.setInt(2,objEC.getEmpleadoid());
            rs=ps.executeQuery();
            if(rs.next())
            {
                objEC.setCantidad_entrada(rs.getInt(1));
                 return true;
            }
            else
            {
                return false;
            }
                   
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
    
}
