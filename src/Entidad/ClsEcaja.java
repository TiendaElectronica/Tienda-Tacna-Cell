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
public class ClsEcaja {
    //datos venta jtable tbventas
    int id;
    String codigo;
    String empleado;
    String cliente;
    String serie;
    String total;
    String fecha;
    String fechaf;

    public String getFechaf() {
        return fechaf;
    }

    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    //Apertura caja 
    String hora_acaja;
    String hora_ccaja;
    int empleadoid;
    double cantidad_inicio;
    double cantidad_salida;
    double cantidad_entrada;
    double total_caja;
    String estado_caja;


    public String getHora_acaja() {
        return hora_acaja;
    }

    public void setHora_acaja(String hora_acaja) {
        this.hora_acaja = hora_acaja;
    }

    public String getHora_ccaja() {
        return hora_ccaja;
    }

    public void setHora_ccaja(String hora_ccaja) {
        this.hora_ccaja = hora_ccaja;
    }

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public double getCantidad_inicio() {
        return cantidad_inicio;
    }

    public void setCantidad_inicio(double cantidad_inicio) {
        this.cantidad_inicio = cantidad_inicio;
    }

    public double getCantidad_salida() {
        return cantidad_salida;
    }

    public void setCantidad_salida(double cantidad_salida) {
        this.cantidad_salida = cantidad_salida;
    }

    public double getCantidad_entrada() {
        return cantidad_entrada;
    }

    public void setCantidad_entrada(double cantidad_entrada) {
        this.cantidad_entrada = cantidad_entrada;
    }

    public double getTotal_caja() {
        return total_caja;
    }

    public void setTotal_caja(double total_caja) {
        this.total_caja = total_caja;
    }

    public String getEstado_caja() {
        return estado_caja;
    }

    public void setEstado_caja(String estado_caja) {
        this.estado_caja = estado_caja;
    }
    
    
    
    
    
    
}
