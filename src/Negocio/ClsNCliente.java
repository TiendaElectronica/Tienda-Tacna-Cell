/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Entidad.ClsECliente;

/**
 *
 * @author HUILLCA
 */
public class ClsNCliente {

    public boolean VerificarExiste(ClsECliente objEC) {
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

    public boolean MtdModificarcliente(ClsECliente objEC) {
        try {
            String SQL="UPDATE tb_cliente set dni=?,edad=?,nombrec=?,direccion=?,email=?,telefono=?,observacion=?  where id_cliente=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement ps=con.prepareStatement(SQL);
            ps.setString(1, objEC.getDni());
            ps.setInt(2, objEC.getEdad());
            ps.setString(3, objEC.getNombre());
            ps.setString(4, objEC.getDireccion());
            ps.setString(5, objEC.getEmail());
            ps.setString(6, objEC.getTelefono());
            ps.setString(7, objEC.getObservacion());
            ps.setInt(8, objEC.getId());
            if(ps.executeUpdate()>0)
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

    public void MtdRegistrarCliente(ClsECliente objEC) {
        try{
            String SQL="insert into tb_cliente(dni,edad,nombrec,direccion,email,telefono,observacion) values (?,?,?,?,?,?,?) ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getDni());
            st.setInt(2, objEC.getEdad());
            st.setString(3, objEC.getNombre());
            st.setString(4, objEC.getDireccion());
            st.setString(5, objEC.getEmail());
            st.setString(6, objEC.getTelefono());
            st.setString(7, objEC.getObservacion());
            
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

    public ArrayList<ClsECliente> Mtdlistar() {
        try {
           String SQL="Select * from tb_cliente;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsECliente> lista=new ArrayList<>();
            ClsECliente car;
            while(resultado.next())
            {
                car=new ClsECliente();
                car.setId(resultado.getInt("id_cliente"));
                car.setDni(resultado.getString("dni"));
                car.setEdad(resultado.getInt("edad"));
                car.setNombre(resultado.getString("nombrec"));
                car.setDireccion(resultado.getString("direccion"));
                car.setEmail(resultado.getString("email"));
                car.setTelefono(resultado.getString("telefono"));
                car.setObservacion(resultado.getString("observacion"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<ClsECliente> Mtdbuscar(ClsECliente objEC) {
        try {
            String SQL="SELECT * FROM tb_cliente WHERE dni=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getDni());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsECliente> lista=new ArrayList<>();
            ClsECliente car;
            while(resultado.next())
            {
                car=new ClsECliente();
                car.setId(resultado.getInt("id_cliente"));
                car.setDni(resultado.getString("dni"));
                car.setEdad(resultado.getInt("edad"));
                car.setNombre(resultado.getString("nombrec"));
                car.setDireccion(resultado.getString("direccion"));
                car.setEmail(resultado.getString("email"));
                car.setTelefono(resultado.getString("telefono"));
                car.setObservacion(resultado.getString("observacion"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<ClsECliente> Mtdbuscarfecha(ClsECliente objEC) {
        try {
            String SQL="SELECT * FROM tb_cliente WHERE fecha_inscripcion BETWEEN ? AND ?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getFecha_inicio());
            st.setString(2, objEC.getFecha_final());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsECliente> lista=new ArrayList<>();
            ClsECliente car;
            while(resultado.next())
            {
                car=new ClsECliente();
                car.setDni(resultado.getString("dni"));
                car.setEdad(resultado.getInt("edad"));
                car.setNombre(resultado.getString("nombrec"));
                car.setDireccion(resultado.getString("direccion"));
                car.setEmail(resultado.getString("email"));
                car.setTelefono(resultado.getString("telefono"));
                car.setObservacion(resultado.getString("observacion"));
                
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    
}
