package br.com.publicacoesonline.processosjudiciais.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessoUpdateInput {

    @NotBlank
    @Size(max = 30)
    private String orgao;

    @NotBlank
    @Size(max = 40)
    private String tribunal;

    @NotBlank
    @Size(max = 50)
    private String unidade;

    @NotBlank
    @Size(max = 255)
    private String descricao;

    private String rgReu;

}
