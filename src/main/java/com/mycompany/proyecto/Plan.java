/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Evan Munoz
 */

public class Plan {
    
    private int numero,total;
    private Date fecha;
    private Cliente cliente;
    private String descripcion="";
    public Plan() {
    }

    public Plan(int numero, int total, Date fecha, Cliente cliente) {
        this.numero = numero;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void verSolicitud()
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Plan Numero: " + this.numero);
        System.out.println("**********************");
        System.out.println("Cliente: " + this.cliente.getNombre());
        System.out.println("Fecha: " + formato.format(fecha));
        System.out.println("**********************");
        System.out.println("Total: " + this.total);
        System.out.println("");
    }
    
    public int descontar(int porcentaje)
    {
        int descuento = this.total * porcentaje/100;
        return descuento;
    }
    
    public int obtenerNumeroSolicitud()
    {
        this.numero = this.numero + 1; // return this.numero++
        return this.numero;
    }

    @Override
    public String toString() {
        return "Plan {" + "numero=" + numero + ", total=" + total + ", fecha=" + fecha + ", cliente=" + cliente + '}';
    }
    
    
}
