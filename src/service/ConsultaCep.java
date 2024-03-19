package service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.ManyNumbersCepException;
import model.EnderecoCep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public EnderecoCep buscarCep(String cep) {
        String json = "";
        HttpResponse<String> response;

        formatarCep(cep);
        URI url = URI.create("http://viacep.com.br/ws/" + cep + "/json/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return new Gson().fromJson(json, EnderecoCep.class);
    }

    private void formatarCep(String cep) {
        cep = cep.replaceAll("[^0-9]+", "");
        if (cep.length() > 8) {
            throw new ManyNumbersCepException("O cep deve ter apenas 8 números");
        }
    }
}
