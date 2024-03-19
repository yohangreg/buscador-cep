package model;

import exception.ManyNumbersCepException;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco(EnderecoCep cep) {
        this.cep = cep.cep();
        this.logradouro = cep.logradouro();
        this.complemento = cep.complemento();
        this.bairro = cep.bairro();
        this.localidade = cep.localidade();
        this.uf = cep.uf();
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

    public static String formataDados(String cep){
        cep = cep.replaceAll("[^0-9]+","");

        if (cep.length() > 8) {
            throw new ManyNumbersCepException("O cep deve ter apenas 8 números");
        }
        return cep;
    }
}
