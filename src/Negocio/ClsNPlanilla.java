/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.ClsEPlanilla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author HUILLCA
 */
public class ClsNPlanilla {

    public boolean Verificardni(ClsEPlanilla objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT a.dni,a.nombre,a.direccion,a.fecha_inicio,b.tipo_cargoempleado,b.sueldo_cargo,a.estado_empleado,b.id_cargo,a.id_empleado "
                + "FROM tb_empleado AS a "
                + "INNER JOIN tb_cargoempleado AS b ON a.id_cargo=b.id_cargo WHERE a.dni=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getDni());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getDni().equals(rs.getString(1)))
                {
                    objEC.setNombre(rs.getString(2));
                    objEC.setDireccion(rs.getString(3));
                    objEC.setFecha_ingreso(rs.getString(4));
                    objEC.setPuesto(rs.getString(5));
                    objEC.setSueldo(rs.getDouble(6));
                    objEC.setEstado(rs.getString(7));
                    objEC.setCargoid(rs.getInt(8));
                    objEC.setEmpleadoid(rs.getInt(9));
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

    public String NroSerie() {
        ResultSet rs;
        String serie="";
        try {
            String SQL="select max(codigo_planilla) from tb_planilla";
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


    public boolean Buscarporcentajepension(ClsEPlanilla objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_pension where  id_pension=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setDouble(1,objEC.getSegurocod());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getSegurocod()==rs.getInt(1))
                {
                    objEC.setSeguro(rs.getDouble(3));
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

    public boolean Buscarporcentajetasa(ClsEPlanilla objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT * FROM tb_tasa where  id_tasa=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setDouble(1,objEC.getTasacod());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getTasacod()==rs.getInt(1))
                {
                    objEC.setTasa(rs.getDouble(3));
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

    public boolean VerificarExisteboleta(ClsEPlanilla objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT a.mes,b.dni "
                + "FROM tb_planilla AS a "
                + "INNER JOIN tb_empleado AS b ON a.id_empleado=b.id_empleado WHERE b.dni=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getDni());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getMes().equals(rs.getString(1)))
                {
                    return true;
                }
                else
                {
                    return false;
                }
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

    public boolean MtdRegistrarplanilla(ClsEPlanilla objEC) {
        try{
            String SQL="insert into tb_planilla(codigo_planilla,fecha_creacion,id_empleado,id_cargo,id_pension,id_tasa,descuento,gratificacion,total_pago,mes) values (?,?,?,?,?,?,?,?,?,?)";
            Connection con=ClsConexion.Conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getCodigo_planilla());
            st.setString(2, objEC.getFecha_dia());
            st.setInt(3, objEC.getEmpleadoid());
            st.setInt(4, objEC.getCargoid());
            st.setDouble(5, objEC.getSegurocod());
            st.setDouble(6, objEC.getTasacod());
            st.setDouble(7, objEC.getDescuento());
            st.setDouble(8, objEC.getGratificacion());
            st.setDouble(9, objEC.getTotal());
            st.setString(10, objEC.getMes());
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

    public boolean VerificarEstadoEmpleado(ClsEPlanilla objEC) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=ClsConexion.Conectar();
        String sql="SELECT dni,estado_empleado FROM tb_empleado WHERE dni=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,objEC.getDni());
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(objEC.getEstado().equals(rs.getString(2)))
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
    
}
