package br.com.publicacoesonline.processosjudiciais.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

    @NotBlank
    @Size(min = 2, max = 2)
    private String estado;

    @NotBlank
    @Size(min = 3, max = 50)
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 50)
    private String bairro;

    @NotBlank
    @Size(min = 1, max = 50)
    private String rua;

    @NotBlank
    @Size(min = 3, max = 200)
    private String logradouro;

}
