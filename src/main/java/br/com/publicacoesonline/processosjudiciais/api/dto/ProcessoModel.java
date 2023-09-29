package br.com.publicacoesonline.processosjudiciais.api.dto;

import br.com.publicacoesonline.processosjudiciais.domain.model.StatusProcesso;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProcessoModel {
    private String numero;
    private String orgao;
    private String tribunal;
    private String unidade;
    private String descricao;
    private LocalDate dataAbertura;
    private StatusProcesso status;
    private ReuResumoModel reu;
}
