/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsECliente;
import Entidad.ClsEDetalleventa;
import Entidad.ClsEproducto;
import Entidad.ClsEventa;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HUILLCA
 */
public class Clsventa {

    public boolean Verificardni(ClsECliente objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_cliente WHERE dni=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getDni());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getDni().equals(rs.getString(2)))
                {
                    objEC.setId(rs.getInt(1));
                    objEC.setDni(rs.getString(2));
                    objEC.setNombre(rs.getString(4));
                    objEC.setDireccion(rs.getString(5));
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

    public boolean Verificarproducto(ClsEproducto objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_producto WHERE codigo=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getCodigo());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getCodigo().equals(rs.getString(7)))
                {
                    objEC.setId_producto(rs.getInt(1));
                    objEC.setNombre(rs.getString(8));
                    objEC.setDescripcion(rs.getString(10));
                    objEC.setStock(rs.getInt(4));
                    objEC.setPrecio_venta(rs.getDouble(6));
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
    ResultSet rs;
    public String idventas()
    {
        String idv="";
        try {
            String SQL="select max(id_venta) from tb_venta";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            rs=st.executeQuery();
            while(rs.next())
            {
                idv=rs.getString(1);
            }
            
        } catch (Exception e) {
        }
        return idv;
    }
    public String NroSerie()
    {
        String serie="";
        try {
            String SQL="select max(numero_serie) from tb_venta";
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
    
    
    public boolean MtdGuardarventas(ClsEventa objECV) {
    try {
            String SQL="insert into tb_venta(id_empleado,id_cliente,numero_serie,fecha_venta,monto,estado,tipo) values (?,?,?,?,?,?,?);";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objECV.getIdvendedor());
            st.setInt(2, objECV.getIdcliente());
            st.setString(3, objECV.getSerie());
            st.setString(4, objECV.getFecha());
            st.setDouble(5, objECV.getMonto());
            st.setString(6, objECV.getEstado());
            st.setString(7, objECV.getTipo());
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

    public boolean MtdGuardardetalle(ClsEDetalleventa objECVV) {
        try {
            String SQL="insert into tb_detalleventa(id_venta,id_producto,cantidad,subtotal) values (?,?,?,?);";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objECVV.getIdventas());
            st.setInt(2, objECVV.getIdproducto());
            st.setInt(3, objECVV.getCantidad());
            st.setDouble(4, objECVV.getPreventa());
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

    public boolean actualizarstock(ClsEproducto objEC) {
         try {
            String SQL="update tb_producto set cantidad=? where id_producto=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEC.getCantidad());
            st.setInt(2, objEC.getId_producto());
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

    public ArrayList<ClsEDetalleventa> Mtdbuscar(ClsEDetalleventa objEC) {
        try {
            String SQL="SELECT  a.nombrep,b.cantidad,a.precio_venta "
                    + "FROM tb_detalleventa AS b "
                    + "INNER JOIN tb_producto AS a ON a.id_producto=b.id_producto WHERE b.id_venta=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setInt(1, objEC.getId());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEDetalleventa> lista=new ArrayList<>();
            ClsEDetalleventa car;
            while(resultado.next())
            {
                car=new ClsEDetalleventa();
                car.setNombrep(resultado.getString("nombrep"));
                car.setCantidad(resultado.getInt("cantidad"));
                car.setPreventa(resultado.getDouble("precio_venta"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean Mtdmostartipo(ClsEventa objECV) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_empleado WHERE id_empleado=? AND id_cargo=1 ;";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,objECV.getIdvendedor());
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
    
}
