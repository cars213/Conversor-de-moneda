package com.aluracursos.conversorDeMoneda.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    //Clase encargada de obtener los valores de la api
    public BuscaMoneda buscaMoneda (String moneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/600a613418b03ffb4576fcec/latest/"+moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            return new Gson().fromJson(conversionRates, BuscaMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
