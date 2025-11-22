package com.aluracursos.conversorDeMoneda.principal;
import com.aluracursos.conversorDeMoneda.modelos.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        boolean interfazUsuario = true;
        double monedaOrigen;
        //Lista para almacenar historial.
        ArrayList<String> historial = new ArrayList<>();
        String mensaje = "Escriba el valor a convertir";
        Scanner teclado = new Scanner(System.in);
        //Objeto dolar
        Moneda dolar = new Moneda("USD", "Dolares");
        //Objeto realBrasil
        Moneda realBrasil = new Moneda("BRL", "Reales");
        realBrasil.setValor(realBrasil.getBusca().USD());
        //Objeto peso Argentino
        Moneda pesoArgentino = new Moneda("ARS", "Pesos Argentinos");
        pesoArgentino.setValor(pesoArgentino.getBusca().USD());
        //Objeto pesoColombiano
        Moneda pesoColombiano = new Moneda("COP", "Pesos Colombianos");
        pesoColombiano.setValor(pesoColombiano.getBusca().USD());
        //Objeto condicional, para verificar que si se ingresa un numero
        ValidadorNumero condicional = new ValidadorNumero();

        System.out.println("""
                ***********************************************************************
                Sea bienvenido/a al conversor de Moneda =)
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasileño
                4) Real Brasileño =>> Dolar
                5) Dolar =>> Peso Colombiano
                6) Peso Colombiano =>> Dolar
                7) Historial de conversion
                8) Salir
                Elija una opcion valida
                ***********************************************************************
                """);
        while (interfazUsuario) {
            if (teclado.hasNextInt()) {
                switch (teclado.nextInt()) {
                    //Dolar =>> Peso Argentino
                    case 1:
                        monedaOrigen = condicional.ValidadorNumero(teclado, mensaje);
                        pesoArgentino.mostrarResultado(monedaOrigen);
                        historial.add(TiempoHistorial.TiempoHistorial(pesoArgentino.ConversorDeMoneda(monedaOrigen),
                                String.format("%s [Dolar =>> Peso Argentino]",pesoArgentino.getEtiquetaMoneda())));
                        break;
                    //Peso Argentino =>> Dolar
                    case 2:
                        monedaOrigen = condicional.ValidadorNumero(teclado, mensaje);
                        dolar.setValor(dolar.getBusca().ARS());
                        dolar.mostrarResultado(monedaOrigen);
                        historial.add(TiempoHistorial.TiempoHistorial(dolar.ConversorDeMoneda(monedaOrigen),
                                String.format("%s [Peso Argentino =>> Dolar]",dolar.getEtiquetaMoneda())));
                        break;
                    //Dolar =>> Real Brasileño
                    case 3:
                        monedaOrigen = condicional.ValidadorNumero(teclado, mensaje);
                        realBrasil.mostrarResultado(monedaOrigen);
                        historial.add(TiempoHistorial.TiempoHistorial(realBrasil.ConversorDeMoneda(monedaOrigen),
                                String.format("%s [Dolar =>> Real Brasileño]",realBrasil.getEtiquetaMoneda())));
                        break;
                    //Real Brasileño =>> Dolar
                    case 4:
                        monedaOrigen = condicional.ValidadorNumero(teclado, mensaje);
                        dolar.setValor(dolar.getBusca().BRL());
                        dolar.mostrarResultado(monedaOrigen);
                        historial.add(TiempoHistorial.TiempoHistorial(dolar.ConversorDeMoneda(monedaOrigen),
                                String.format("%s [Real Brasileño =>> Dolar]",dolar.getEtiquetaMoneda())));
                        break;
                    //Dolar =>> Peso Colombiano
                    case 5:
                        monedaOrigen = condicional.ValidadorNumero(teclado, mensaje);
                        pesoColombiano.mostrarResultado(monedaOrigen);
                        historial.add(TiempoHistorial.TiempoHistorial(pesoColombiano.ConversorDeMoneda(monedaOrigen),
                                String.format("%s [Dolar =>> Peso Colombiano]",pesoColombiano.getEtiquetaMoneda())));
                        break;
                    //Peso Colombiano =>> Dolar
                    case 6:
                        monedaOrigen = condicional.ValidadorNumero(teclado, mensaje);
                        dolar.setValor(dolar.getBusca().COP());
                        dolar.mostrarResultado(monedaOrigen);
                        historial.add(TiempoHistorial.TiempoHistorial(dolar.ConversorDeMoneda(monedaOrigen),
                                String.format("%s [Peso Colombiano =>> Dolar]",dolar.getEtiquetaMoneda())));
                        break;
                    case 7:
                        if (historial.isEmpty()){
                            System.out.println("Aun no se han realizado operaciones");
                        }else{
                            System.out.println(historial);
                        }
                        break;
                    case 8:
                        System.out.println("Finalizando programa, hasta pronto");
                        teclado.close();
                        interfazUsuario = false;
                        break;
                    default:
                        System.out.println("Introduzca un valor valido");
                }
                System.out.println("""
                        ***********************************************************************
                        1) Dolar =>> Peso Argentino
                        2) Peso Argentino =>> Dolar
                        3) Dolar =>> Real Brasileño
                        4) Real Brasileño =>> Dolar
                        5) Dolar =>> Peso Colombiano
                        6) Peso Colombiano =>> Dolar
                        7) Historial de conversion
                        8) Salir
                        Elija una opcion valida
                        ***********************************************************************
                        """);
            } else {
                System.out.println("Error, valor ingresado no es valido, por favor digite un numero valido.");
                teclado.next();
            }
        }
    }
}
