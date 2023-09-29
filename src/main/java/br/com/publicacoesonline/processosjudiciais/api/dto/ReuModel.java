package br.com.publicacoesonline.processosjudiciais.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReuModel {
    private String rg;
    private String nome;
    private LocalDate dataNascimento;
    private EnderecoModel endereco;
}
