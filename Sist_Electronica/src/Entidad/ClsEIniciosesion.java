/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author HUILLCA
 */
public class ClsEIniciosesion {
    int id;
    int cargo_empleado;
    String usuario;
    String clave;
    String estado;
    String fecha;
    String tipo_empleado;
    String clave_nueva;

    public String getClave_nueva() {
        return clave_nueva;
    }

    public void setClave_nueva(String clave_nueva) {
        this.clave_nueva = clave_nueva;
    }
    
    

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCargo_empleado() {
        return cargo_empleado;
    }

    public void setCargo_empleado(int cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    

    
    
    
}
