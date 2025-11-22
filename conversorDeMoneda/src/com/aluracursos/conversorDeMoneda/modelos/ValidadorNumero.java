package com.aluracursos.conversorDeMoneda.modelos;

import java.util.Scanner;

public class ValidadorNumero {
    /*Clase encargada de comprobar si el usuario ingresa solo numeros*/
    public double ValidadorNumero(Scanner teclado, String mensaje){
        boolean pruebaNumero = true;
        while (pruebaNumero){
            System.out.println(mensaje);
            if(teclado.hasNextDouble()){
                pruebaNumero = false;
            }else{
                System.out.println("Error, valor ingresado no es valido, por favor digite un numero valido.");
                teclado.next();
            }
        }
        return teclado.nextDouble();
    }
}
