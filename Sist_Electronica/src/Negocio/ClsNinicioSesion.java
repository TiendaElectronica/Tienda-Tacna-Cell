/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEIniciosesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author HUILLCA
 */
public class ClsNinicioSesion {

    public boolean MtdLogueoEmpleado(ClsEIniciosesion objEC) {
            PreparedStatement ps=null;
            ResultSet rs=null;
            Connection con=ClsConexion.Conectar();
        String sql="SELECT b.id_usuario,b.usuario,b.clave_usuario,b.estado_usuario,c.id_empleado,a.id_cargo FROM tb_empleado AS c "
                + " INNER JOIN tb_cargoempleado AS a ON c.id_cargo=a.id_cargo INNER JOIN tb_usuario AS b ON b.id_empleado=c.id_empleado "
                + " WHERE b.usuario=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getUsuario());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getEstado().equals(rs.getString(4)))
                {
                    if(objEC.getClave().equals(rs.getString(3))){
                        String sqlupdate="UPDATE tb_usuario SET fecha_sesion=? WHERE id_usuario=?;";
                        ps=con.prepareStatement(sqlupdate);
                        ps.setString(1, objEC.getFecha());
                        ps.setInt(2, rs.getInt(1));
                        ps.execute();
                    objEC.setUsuario(rs.getString(2));
                    objEC.setId(rs.getInt(5));
                    objEC.setCargo_empleado(rs.getInt(6));
                    return true;
                    }
                    else
                    {
                        return false;
                    }     
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Usted se encuentra suspendido del sistema \n comuniquese con el Administrador");
                }
                
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean MtdEditarContraseña(ClsEIniciosesion objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_usuario WHERE usuario=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getUsuario());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getClave().equals(rs.getString(4)))
                {
                    String sqlupdate="UPDATE tb_usuario SET clave_usuario=? WHERE id_usuario=?;";
                    ps=con.prepareStatement(sqlupdate);
                    ps.setString(1, objEC.getClave_nueva());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();
                    return true;
                }
                else
                {
                    return false;
                }
                
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
}
