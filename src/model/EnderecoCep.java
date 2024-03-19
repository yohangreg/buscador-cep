package model;

public record EnderecoCep(String cep, String logradouro,
                          String complemento, String bairro,
                          String localidade, String uf) {
}
