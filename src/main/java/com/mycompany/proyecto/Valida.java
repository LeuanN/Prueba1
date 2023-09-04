/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.util.Date;

/**
 *
 * @author Evan Munoz
 */
public class Valida {

    public Valida() {
    }
    
    public boolean validarLargo8(int valor)
    {
        if (valor >= 10000000 && valor <= 99999999) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validarFecha(Date fechaSolicitud)
    {
        Date fecha = new Date(); //fecha de hoy
        if (fechaSolicitud.compareTo(fecha) <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
