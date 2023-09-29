package br.com.publicacoesonline.processosjudiciais.api.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReuInput {

    @NotBlank
    private String rg;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @Valid
    @NotNull
    private EnderecoInput endereco;

}
