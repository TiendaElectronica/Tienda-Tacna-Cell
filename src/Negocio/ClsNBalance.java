/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEBalance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HUILLCA
 */
public class ClsNBalance {

    public boolean buscarsueldo(ClsEBalance objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT sum(total_pago) FROM tb_planilla WHERE fecha_creacion BETWEEN ? AND ?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getFecha_inicio());
            ps.setString(2,objEC.getFecha_final());
            rs=ps.executeQuery();
            if(rs.next())
            {
                objEC.setSueldo_empleado(rs.getDouble(1));
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

    public boolean buscarcompras(ClsEBalance objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT sum(precio_compra) FROM tb_producto WHERE fecha_inscripcion BETWEEN ? AND ?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getFecha_inicio());
            ps.setString(2,objEC.getFecha_final());
            rs=ps.executeQuery();
            if(rs.next())
            {
                objEC.setCompras(rs.getDouble(1));
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

    public boolean buscarventas(ClsEBalance objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT sum(monto) FROM tb_venta WHERE fecha_venta BETWEEN ? AND ?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getFecha_inicio());
            ps.setString(2,objEC.getFecha_final());
            rs=ps.executeQuery();
            if(rs.next())
            {
                objEC.setVentas(rs.getDouble(1));
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
