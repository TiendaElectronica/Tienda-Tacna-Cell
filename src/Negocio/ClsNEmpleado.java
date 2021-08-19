/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Entidad.ClsEEmpleado;
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
public class ClsNEmpleado {

    public boolean VerificarExiste(ClsEEmpleado objEC)
    {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_empleado WHERE dni=?;";
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
    
    public void MtdRegistrarEmpleado(ClsEEmpleado objEC) {
        try{
            String SQL="insert into tb_empleado(dni,id_cargo,nombre,direccion,email,telefono,sexo,imagen,estado_empleado,sueldo,fecha_inicio) values (?,?,?,?,?,?,?,?,?,?,?) ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getDni());
            st.setInt(2, objEC.getCargoempleado());
            st.setString(3, objEC.getNombre());
            st.setString(4, objEC.getDireccion());
            st.setString(5, objEC.getEmail());
            st.setString(6, objEC.getTelefono());
            st.setString(7, objEC.getSexo());
            st.setBytes(8, objEC.getImagen());
            st.setString(9, objEC.getEstado_empleado());
            st.setDouble(10, objEC.getSueldo());
            st.setString(11, objEC.getFecha());
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
    
    



    public static ArrayList<ClsEEmpleado> MtdListar() {
        try {
           String SQL="SELECT c.id_empleado,c.dni,b.tipo_cargoempleado,c.nombre,c.direccion,c.email,c.telefono,c.sexo,c.estado_empleado,c.sueldo,c.fecha_inicio "
                   + "FROM tb_empleado AS c "
                   + "INNER JOIN tb_cargoempleado AS b ON c.id_cargo=b.id_cargo ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEEmpleado> lista=new ArrayList<>();
            ClsEEmpleado car;
            while(resultado.next())
            {
                car=new ClsEEmpleado();
                car.setId(resultado.getInt("id_empleado"));
                car.setDni(resultado.getString("dni"));
                car.setCargo_empleadonombre(resultado.getString("tipo_cargoempleado"));
                car.setNombre(resultado.getString("nombre"));
                car.setDireccion(resultado.getString("direccion"));
                car.setEmail(resultado.getString("email"));
                car.setTelefono(resultado.getString("telefono"));
                car.setSexo(resultado.getString("sexo"));
                car.setEstado_empleado(resultado.getString("estado_empleado"));
                car.setSueldo(resultado.getDouble("sueldo"));
                car.setFecha(resultado.getString("fecha_inicio"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    /*public ArrayList<ClsEEmpleado> Listar_Producto() {
        ArrayList<ClsEEmpleado> list = new ArrayList<ClsEEmpleado>();
        Connection con=ClsConexion.Conectar();
        String sql = "SELECT * FROM producto;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoVO vo = new ProductoVO();
                vo.setIdproducto(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setPrecio(rs.getDouble(3));
                vo.setMarca(rs.getString(4));
                vo.setFoto(rs.getBytes(5));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }*/

    public boolean MtdModificarempleado(ClsEEmpleado objEC) {
        try {
            String SQL="UPDATE tb_empleado set dni=?,id_cargo=?,nombre=?,direccion=?,email=?,telefono=?,imagen=?,estado_empleado=?,sueldo=?  where id_empleado=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getDni());
            st.setInt(2, objEC.getCargoempleado());
            st.setString(3, objEC.getNombre());
            st.setString(4, objEC.getDireccion());
            st.setString(5, objEC.getEmail());
            st.setString(6, objEC.getTelefono());
            st.setBytes(7, objEC.getImagen());
            st.setString(8, objEC.getEstado_empleado());
            st.setDouble(9, objEC.getSueldo());
            st.setInt(10, objEC.getId());
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

    public void MtdRegistrarUsuario(ClsEEmpleado objEC) {
        try{
            String SQL="insert into tb_usuario(id_empleado,usuario,clave_usuario,estado_usuario) values (?,?,?,?)  ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEC.getId());
            st.setString(2, objEC.getUsu());
            st.setString(3, objEC.getClave());
            st.setString(4, objEC.getEstado_usuario());
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

    public boolean VerificarExisteUsuario(ClsEEmpleado objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_usuario WHERE id_empleado=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,objEC.getId());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getId()==rs.getInt(2))
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

    public boolean Suspender_Empleado(ClsEEmpleado objEC) {
        try {
            String SQL="UPDATE tb_empleado set estado_empleado=? where id_empleado=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getEstado_usuario());
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

    public boolean Activar_Empleado(ClsEEmpleado objEC) {
        try {
            String SQL="UPDATE tb_empleado set estado_empleado=? where id_empleado=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getEstado_usuario());
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

    public ArrayList<ClsEEmpleado> MtdListar(ClsEEmpleado objEC) {
        try {
           String SQL="SELECT c.dni,b.tipo_cargoempleado,c.nombre,c.direccion,c.email,c.telefono,c.sexo,c.estado_empleado,c.sueldo,c.fecha_inicio "
                   + "FROM tb_empleado AS c "
                   + "INNER JOIN tb_cargoempleado AS b ON c.id_cargo=b.id_cargo WHERE c.fecha_inicio BETWEEN ? AND ?; ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL); 
            st.setString(1, objEC.getFecha_inicio());
            st.setString(2, objEC.getFecha_final());
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEEmpleado> lista=new ArrayList<>();
            ClsEEmpleado car;
            while(resultado.next())
            {
                car=new ClsEEmpleado();
                car.setDni(resultado.getString("dni"));
                car.setCargo_empleadonombre(resultado.getString("tipo_cargoempleado"));
                car.setNombre(resultado.getString("nombre"));
                car.setDireccion(resultado.getString("direccion"));
                car.setEmail(resultado.getString("email"));
                car.setTelefono(resultado.getString("telefono"));
                car.setSexo(resultado.getString("sexo"));
                car.setEstado_empleado(resultado.getString("estado_empleado"));
                car.setSueldo(resultado.getDouble("sueldo"));
                car.setFecha(resultado.getString("fecha_inicio"));
                lista.add(car);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean BuscarSueldo(ClsEEmpleado objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_cargoempleado where  id_cargo=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setDouble(1,objEC.getCargoempleado());
            rs=ps.executeQuery();
            if(rs.next())
            {
                    objEC.setCargo_empleadonombre(rs.getString(3));
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

    public boolean Bloquear_Usuario(ClsEEmpleado objEC) {
        try {
            String SQL="UPDATE tb_usuario set estado_usuario=? where id_empleado=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getEstado_usuario());
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

    public boolean Desbloquear_Usuario(ClsEEmpleado objEC) {
        try {
            String SQL="UPDATE tb_usuario set estado_usuario=? where id_empleado=? ";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getEstado_usuario());
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
