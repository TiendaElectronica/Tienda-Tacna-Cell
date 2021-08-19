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
public class ClsEPlanilla {
    String codigo_planilla;
    String fecha_dia;
    String Dni;
    String nombre;
    String mes;
    String Direccion;
    String Fecha_ingreso;
    String puesto;
    double sueldo;
    double gratificacion;
    double seguro;
    double tasa;
    double descuento;
    double total;
    int segurocod;
    int tasacod;
    int empleadoid;
    int cargoid;
    String Estado;

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }


    public int getCargoid() {
        return cargoid;
    }

    public void setCargoid(int cargoid) {
        this.cargoid = cargoid;
    }


    
    
    
    
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    

    public int getSegurocod() {
        return segurocod;
    }

    public void setSegurocod(int segurocod) {
        this.segurocod = segurocod;
    }

    public int getTasacod() {
        return tasacod;
    }

    public void setTasacod(int tasacod) {
        this.tasacod = tasacod;
    }
    
    

    public String getCodigo_planilla() {
        return codigo_planilla;
    }

    public void setCodigo_planilla(String codigo_planilla) {
        this.codigo_planilla = codigo_planilla;
    }

    public String getFecha_dia() {
        return fecha_dia;
    }

    public void setFecha_dia(String fecha_dia) {
        this.fecha_dia = fecha_dia;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(String Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getGratificacion() {
        return gratificacion;
    }

    public void setGratificacion(double gratificacion) {
        this.gratificacion = gratificacion;
    }

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
}
