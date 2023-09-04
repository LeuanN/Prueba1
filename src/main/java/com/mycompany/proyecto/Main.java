/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Evan Munoz
 */
public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;
        boolean flag; //validaciones
        
        //cliente
        //Ingreso de Datos
        int rut, telefono;
        String nombre, mail, direccion;
        char dv;
        
        //Asignacion de plan
        int totalProductos, antiguo, montooriginal, numeroplan;
        String descripcion;
        
        //Plan
        int numero;
        String fecha;
        int porcentaje;
        int descuento;

        Valida valida = new Valida();
        Cliente cliente = new Cliente();
        Plan pla = new Plan();

        do {
            System.out.println("*****MENU*****");
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Asignar Plan");
            System.out.println("3. Aplicar descuento");
            System.out.println("4. Salir (Ver Plan Ingresado)");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese Rut:");
                    rut = leer.nextInt();
                    System.out.println("Ingrese DV: ");
                    dv = leer.next().charAt(0);

                    System.out.println("Ingrese nombre: ");
                    nombre = leer.next();
                    
                    if ("".equals(nombre))
                    {
                        System.out.println("El nombre no puede estar vacío.");
                    }

                    do {
                        System.out.println("Ingrese telefono: ");
                        telefono = leer.nextInt();
                        flag = valida.validarLargo8(telefono);
                        if (flag == false) {
                            System.out.println("Telefono debe contener 8 carácteres");
                        }
                    } while (flag == false);

                    System.out.println("Ingrese correo");
                    mail = leer.next();
                    System.out.println("Ingrese Direccion");
                    direccion = leer.next();

                    //guardar datos de cliente
                    cliente.setRun(rut);
                    cliente.setDv(dv);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    cliente.setMail(mail);

                    System.out.println("******CLIENTE CREADO******");
                    System.out.println(cliente);

                    break;
                case 2:
                    //asignamiento planes
                    pla.setCliente(cliente);
                    Date fechaDate = null;
                    do {

                        System.out.println("Ingrese fecha: (dd-mm-yyyy)");
                        fecha = leer.next();
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

                        //trycatch  + tab --> excepciones
                        try {
                            fechaDate = formato.parse(fecha);
                            flag = valida.validarFecha(fechaDate);

                        } catch (ParseException e) {
                            flag = false;
                            System.out.println("Fecha invalida (dd-mm-yyyy)");
                        }
                    } while (flag == false);
                    pla.setFecha(fechaDate);

                    //productos
                    System.out.println("¿Monto del Plan?");
                    totalProductos = leer.nextInt();
                    
                    do {
                        System.out.println("Numero del Plan?");
                        numero = leer.nextInt();
                        pla.setNumero(numero);
                        flag = valida.validarLargo8(numero);
                        if (flag == false) {
                            System.out.println("Numero de Plan debe contener 8 carácteres");
                        }
                    } while (flag == false);
                    
                    
                    do {
                        System.out.println("Favor ingresar un monto superior a 6990");
                        totalProductos = leer.nextInt();
                    } while (totalProductos < 6990);
                    
                    pla.setTotal(totalProductos);
                    
                    System.out.println("Ingrese descripcion: ");
                    descripcion = leer.next();
                    pla.setDescripcion(descripcion);
                   
                    System.out.println("****PLAN ASIGNADO****");
                    System.out.println(pla);
                    break;
                case 3:
                    System.out.println("Ingrese porcentaje 1-100%");
                    porcentaje = leer.nextInt();
                    System.out.println("Si el usuario es Nuevo, presione 1, si es ANtiguo presione 0");
                    antiguo = leer.nextInt();
                    
                    System.out.println("Monto Original del Plan?");
                    montooriginal = leer.nextInt();
                    
                    if (antiguo == 0 && montooriginal > 20000 || antiguo == 1)
                    {
                        descuento = pla.descontar(porcentaje);
                        System.out.println("Total: $" + pla.getTotal());
                        System.out.println("descuento: $" + descuento);
                        System.out.println("-----------------------");
                        System.out.println("A pagar: $ " + (pla.getTotal() - descuento));
                    }
                    else
                    {
                        System.out.println("Error, no es elegible para el descuento");
                    }
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Todo Listo.");
                    pla.verSolicitud();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        
    }
    while (opcion 
!= 4);

    }

}
