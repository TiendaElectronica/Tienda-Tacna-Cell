/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEproducto;
import java.util.ArrayList;
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
public class ClsConsulta {

    public static ArrayList<String> llenarcombo() {
        ArrayList<String> lista=new ArrayList<String>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_cargoempleado;";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                lista.add(rs.getString("tipo_cargoempleado"));
            }
        } catch (Exception e) {
            System.err.println("Error");
        }

        return lista;  
    }

    public static ArrayList<String> llenarcomboproveedor() {
        ArrayList<String> lista=new ArrayList<String>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_proveedor;";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                lista.add(rs.getString("ruc"));
            }
        } catch (Exception e) {
            System.err.println("Error");
        }

        return lista;  
    }

    public static ArrayList<String> llenarcombocategoria() {
        ArrayList<String> lista1=new ArrayList<String>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_categoriap;";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                lista1.add(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.err.println("Error");
        }

        return lista1;  
    }


    
}
