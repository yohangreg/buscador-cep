import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Endereco;
import model.EnderecoCep;
import service.ConsultaCep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu cep");
        String resp = input.nextLine();
        ConsultaCep consultaCep = new ConsultaCep();
        Endereco endereco = new Endereco(consultaCep.buscarCep(resp));
        System.out.println(endereco);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter("Endereco.txt");
        writer.write(gson.toJson(endereco));
        writer.close();
    }
}