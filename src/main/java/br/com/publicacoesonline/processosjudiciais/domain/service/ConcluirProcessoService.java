package br.com.publicacoesonline.processosjudiciais.domain.service;

import br.com.publicacoesonline.processosjudiciais.domain.model.Processo;
import br.com.publicacoesonline.processosjudiciais.domain.repository.ProcessoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ConcluirProcessoService {

    private ProcessoService processoService;
    private ProcessoRepository processoRepository;

    @Transactional
    public void concluir(String numero) {
        Processo processo = this.processoService.buscarPorNumero(numero);
        processo.concluir();
        this.processoRepository.save(processo);
    }

}
