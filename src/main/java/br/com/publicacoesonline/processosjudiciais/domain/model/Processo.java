package br.com.publicacoesonline.processosjudiciais.domain.model;

import br.com.publicacoesonline.processosjudiciais.domain.exception.NegocioException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "numero")
@Entity
public class Processo {

    @Id
    private String numero;

    private String orgao;

    private String tribunal;

    private String unidade;

    private LocalDate dataAbertura;

    @Enumerated(EnumType.STRING)
    private StatusProcesso status;

    private String descricao;

    @ManyToOne
    private Reu reu;

    public void ativar() {
        if (!status.equals(StatusProcesso.SUSPENSO)) {
            throw new NegocioException("Processo não pode ser ativado");
        }
        this.setStatus(StatusProcesso.ATIVO);
    }

    public void suspender() {
        if (!status.equals(StatusProcesso.ATIVO)) {
            throw new NegocioException("Processo não pode ser suspenso");
        }
        this.setStatus(StatusProcesso.SUSPENSO);
    }

    public void concluir() {
        if (!status.equals(StatusProcesso.ATIVO)) {
            throw new NegocioException("Processo não pode ser concluído");
        }
        this.setStatus(StatusProcesso.CONCLUIDO);
    }

}
