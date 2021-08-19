/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsECargoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author HUILLCA
 */
public class ClsNCargoEmpleado {

    public boolean mtdguardarcargo(ClsECargoEmpleado objEC) {
        try{
            String SQL="insert into tb_cargoempleado(tipo_cargoempleado,sueldo_cargo,fecha) values (?,?,?);";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getCargo());
            st.setDouble(2, objEC.getSueldo());
            st.setString(3, objEC.getFecha());
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

    public boolean mtdmodificargo(ClsECargoEmpleado objEC) {
        try{
            String SQL="update tb_cargoempleado set tipo_cargoempleado=?, sueldo_cargo=? where id_cargo=? ;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getCargo());
            st.setDouble(2, objEC.getSueldo());
            st.setInt(3, objEC.getId());
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

    public ArrayList<ClsECargoEmpleado> MtdListar() {
        try {
           String SQL="SELECT * FROM tb_cargoempleado";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsECargoEmpleado> lista=new ArrayList<>();
            ClsECargoEmpleado car;
            while(resultado.next())
            {
                car=new ClsECargoEmpleado();
                car.setId(resultado.getInt("id_cargo"));
                car.setCargo(resultado.getString("tipo_cargoempleado"));
                car.setSueldo(resultado.getDouble("sueldo_cargo"));
                car.setFecha(resultado.getString("fecha"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
}
