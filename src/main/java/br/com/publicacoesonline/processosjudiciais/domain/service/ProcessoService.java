package br.com.publicacoesonline.processosjudiciais.domain.service;

import br.com.publicacoesonline.processosjudiciais.domain.exception.NegocioException;
import br.com.publicacoesonline.processosjudiciais.domain.model.Processo;
import br.com.publicacoesonline.processosjudiciais.domain.model.StatusProcesso;
import br.com.publicacoesonline.processosjudiciais.domain.repository.ProcessoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class ProcessoService {

    private ProcessoRepository processoRepository;
    private ReuService reuService;

    @Transactional
    public Processo salvar(Processo processo) {

        String pattern = "\\d{7}-\\d{2}\\.\\d{4}\\.\\d{1}\\.\\d{2}\\.\\d{4}";

        if (!Pattern.matches(pattern, processo.getNumero())) {
            throw new NegocioException("O número não está no padrão 'NNNNNNN-DD.AAAA.J.TR.OOOO'");
        }

        if (existePorNumero(processo.getNumero())) {
            throw new NegocioException("Já existe um processo cadastrado com esse número");
        }

        if (processo.getReu() != null) {
            this.reuService.buscar(processo.getReu().getRg());
        }

        processo.setDataAbertura(LocalDate.now());
        processo.setStatus(StatusProcesso.ATIVO);
        return this.processoRepository.save(processo);
    }

    public Processo buscarPorNumero(String numero) {
        return this.processoRepository.findById(numero)
                .orElseThrow(() -> new NegocioException("Não existe um processo com esse número"));
    }

    public boolean existePorNumero(String numero) {
        return this.processoRepository.existsById(numero);
    }

    @Transactional
    public Processo atualizar(Processo processo) {
        Processo dadosInalterados = this.buscarPorNumero(processo.getNumero());
        processo.setStatus(dadosInalterados.getStatus());
        processo.setDataAbertura(dadosInalterados.getDataAbertura());
        if (processo.getReu() != null) {
            this.reuService.buscar(processo.getReu().getRg());
        }
        return this.processoRepository.save(processo);
    }

    public List<Processo> listar() {
        return this.processoRepository.findAll();
    }

    @Transactional
    public void excluir(String numero) {
        this.processoRepository.deleteById(numero);
    }

}
