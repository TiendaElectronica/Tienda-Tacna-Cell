/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEProveedor;
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
public class ClsNProveedor {

    public boolean VerificarExiste(ClsEProveedor objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_proveedor WHERE ruc=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getRuc());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getRuc().equals(rs.getString(3)))
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

    public void MtdRegistrarProveedor(ClsEProveedor objEC) {
        try{
            String SQL="insert into tb_proveedor(tipo_proveedor,ruc,nombre,celular,direccion,email,estado,observacion,fecha_inscripcion) values (?,?,?,?,?,?,?,?,?) ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getTipo_proveedor());
            st.setString(2, objEC.getRuc());
            st.setString(3, objEC.getNombre());
            st.setString(4, objEC.getCelular());
            st.setString(5, objEC.getDireccion());
            st.setString(6, objEC.getEmail());
            st.setString(7, objEC.getEstado());
            st.setString(8, objEC.getObservacion());
            st.setString(9, objEC.getFecha());
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

    public boolean MtdModificarproveedor(ClsEProveedor objEC) {
        try {
            String SQL="UPDATE tb_proveedor set tipo_proveedor=?,ruc=?,nombre=?,celular=?,direccion=?,email=?,estado=?,observacion=?  where id_proveedor=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getTipo_proveedor());
            st.setString(2, objEC.getRuc());
            st.setString(3, objEC.getNombre());
            st.setString(4, objEC.getCelular());
            st.setString(5, objEC.getDireccion());
            st.setString(6, objEC.getEmail());
            st.setString(7, objEC.getEstado());
            st.setString(8, objEC.getObservacion());
            st.setInt(9, objEC.getId());
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

    public ArrayList<ClsEProveedor> Mtdlistar() {
        try {
           String SQL="Select * from tb_proveedor;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProveedor> lista=new ArrayList<>();
            ClsEProveedor car;
            while(resultado.next())
            {
                car=new ClsEProveedor();
                car.setId(resultado.getInt("id_proveedor"));
                car.setTipo_proveedor(resultado.getString("tipo_proveedor"));
                car.setRuc(resultado.getString("ruc"));
                car.setNombre(resultado.getString("nombre"));
                car.setCelular(resultado.getString("celular"));
                car.setDireccion(resultado.getString("direccion"));
                car.setEmail(resultado.getString("email"));
                car.setEstado(resultado.getString("estado"));
                car.setObservacion(resultado.getString("observacion"));
                car.setFecha(resultado.getString("fecha_inscripcion"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<ClsEProveedor> Mtdbuscar(ClsEProveedor objEC) {
        try {
           String SQL="SELECT * FROM tb_proveedor WHERE ruc=?;";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getRuc());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProveedor> lista=new ArrayList<>();
            ClsEProveedor car;
            while(resultado.next())
            {
                car=new ClsEProveedor();
                car.setId(resultado.getInt("id_proveedor"));
                car.setTipo_proveedor(resultado.getString("tipo_proveedor"));
                car.setRuc(resultado.getString("ruc"));
                car.setNombre(resultado.getString("nombre"));
                car.setCelular(resultado.getString("celular"));
                car.setDireccion(resultado.getString("direccion"));
                car.setEmail(resultado.getString("email"));
                car.setEstado(resultado.getString("estado"));
                car.setObservacion(resultado.getString("observacion"));
                car.setFecha(resultado.getString("fecha_inscripcion"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
}
