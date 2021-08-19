/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEIgv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author HUILLCA
 */
public class ClsNigv {

    public boolean mtdmodificarigv(ClsEIgv objEC) {
        try{
            String SQL="update tb_igv set cantidad=?  where id_igv=? ;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setDouble(1, objEC.getCantidad());
            st.setInt(2, objEC.getId());
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean Cargarpocentaje(ClsEIgv objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_igv WHERE id_igv=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,objEC.getId());
            rs=ps.executeQuery();
            if(rs.next())
            {
                    objEC.setCantidad(rs.getInt(2));
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
