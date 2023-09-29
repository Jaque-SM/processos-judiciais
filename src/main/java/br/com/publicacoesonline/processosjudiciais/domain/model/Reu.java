package br.com.publicacoesonline.processosjudiciais.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "rg")
@Entity
public class Reu {
    @Id
    private String rg;

    private String nome;

    private LocalDate dataNascimento;

    @Embedded
    private Endereco endereco;
}
