package br.com.publicacoesonline.processosjudiciais.domain.service;

import br.com.publicacoesonline.processosjudiciais.domain.model.Processo;
import br.com.publicacoesonline.processosjudiciais.domain.repository.ProcessoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AtivarProcessoService {

    private ProcessoService processoService;
    private ProcessoRepository processoRepository;

    @Transactional
    public void ativar(String numero) {
        Processo processo = this.processoService.buscarPorNumero(numero);
        processo.ativar();
        this.processoRepository.save(processo);
    }

}
