package br.com.publicacoesonline.processosjudiciais.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String logradouro;
}
