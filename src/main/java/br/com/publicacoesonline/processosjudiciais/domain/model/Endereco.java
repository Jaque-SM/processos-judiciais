package br.com.publicacoesonline.processosjudiciais.domain.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String logradouro;
}
