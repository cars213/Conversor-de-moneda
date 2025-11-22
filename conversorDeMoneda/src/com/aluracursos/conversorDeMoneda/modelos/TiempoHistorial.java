package com.aluracursos.conversorDeMoneda.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TiempoHistorial {
    /*Clase encargada de obtener la fecha y hora para unificarla con los datos para finalmente
    ser agregados a la lista.*/
    public static String TiempoHistorial (double resultado, String etiquetaConversion){
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        StringBuilder fechaString = new StringBuilder(fecha.format(formato));
        return String.format("%s Resultado: %.2f %s",fechaString,resultado,etiquetaConversion);
    }
}
