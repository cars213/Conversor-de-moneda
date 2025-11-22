package com.aluracursos.conversorDeMoneda.modelos;
/*Record encargado de recibir los datos de dolar,real brasileño, peso colombiano y peso argentino*/
public record BuscaMoneda(double USD,
                          double COP,
                          double ARS,
                          double BRL) {
}
