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
public class ClsEBalance {
    int id_balance;
    int id_empleado;
    String fecha_inicio;
    String fecha_final;
    double sueldo_empleado;
    double alquiler;
    double luz;
    double agua;
    double otros;
    double compras;
    double ventas;
    double tota;

    public int getId_balance() {
        return id_balance;
    }

    public void setId_balance(int id_balance) {
        this.id_balance = id_balance;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public double getSueldo_empleado() {
        return sueldo_empleado;
    }

    public void setSueldo_empleado(double sueldo_empleado) {
        this.sueldo_empleado = sueldo_empleado;
    }

    public double getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(double alquiler) {
        this.alquiler = alquiler;
    }

    public double getLuz() {
        return luz;
    }

    public void setLuz(double luz) {
        this.luz = luz;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getOtros() {
        return otros;
    }

    public void setOtros(double otros) {
        this.otros = otros;
    }

    public double getCompras() {
        return compras;
    }

    public void setCompras(double compras) {
        this.compras = compras;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getTota() {
        return tota;
    }

    public void setTota(double tota) {
        this.tota = tota;
    }
    
    
}
