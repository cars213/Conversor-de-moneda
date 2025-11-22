package com.aluracursos.conversorDeMoneda.modelos;

public class Moneda {
    private final String etiquetaMoneda;
    private final String tipoMoneda;
    private final ConsultaMoneda consulta ;
    private final BuscaMoneda busca;
    private double valor;


    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public BuscaMoneda getBusca() {
        return busca;
    }

    public String getEtiquetaMoneda() {
        return etiquetaMoneda;
    }

    public Moneda(String tipoMoneda, String etiquetaMoneda) {
        this.tipoMoneda = tipoMoneda;
        this.etiquetaMoneda = etiquetaMoneda;
        this.consulta = new ConsultaMoneda();
        this.busca = consulta.buscaMoneda(tipoMoneda);
    }

    public double ConversorDeMoneda(double monedaOrigen) {
        return monedaOrigen / valor;
    }

    public void mostrarResultado(double monedaOrigen){
        System.out.println(String.format("El resultado es: %.2f %s",ConversorDeMoneda(monedaOrigen),etiquetaMoneda));
    }


}
