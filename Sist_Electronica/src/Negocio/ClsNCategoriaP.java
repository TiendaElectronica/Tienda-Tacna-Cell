/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsECategoriaP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author HUILLCA
 */
public class ClsNCategoriaP {

    public boolean mtdguardarcategoria(ClsECategoriaP objEC) {
         try{
            String SQL="insert into tb_categoriap(nombre,fecha_inscripcion) values (?,?);";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getCategoria());
            st.setString(2, objEC.getFecha());
            if(st.executeUpdate()>0)
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

    public ArrayList<ClsECategoriaP> MtdListar() {
        try {
           String SQL="SELECT * FROM tb_categoriap";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsECategoriaP> lista=new ArrayList<>();
            ClsECategoriaP car;
            while(resultado.next())
            {
                car=new ClsECategoriaP();
                car.setId(resultado.getInt("id_categoria"));
                car.setCategoria(resultado.getString("nombre"));
                car.setFecha(resultado.getString("fecha_inscripcion"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean mtdmodificarcategoria(ClsECategoriaP objEC) {
        try{
            String SQL="update nombre=?  set tb_categoriap where id_categoria=? ;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getCategoria());
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
            return false;
        }
    }
    
}
