package br.com.publicacoesonline.processosjudiciais.domain.service;

import br.com.publicacoesonline.processosjudiciais.domain.exception.NegocioException;
import br.com.publicacoesonline.processosjudiciais.domain.model.Reu;
import br.com.publicacoesonline.processosjudiciais.domain.repository.ReuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ReuService {

    private ReuRepository reuRepository;

    @Transactional
    public Reu cadastrar(Reu reu) {
        if (this.reuRepository.findById(reu.getRg()).isPresent()) {
            throw new NegocioException("Já existe um Réu cadastrado com esse RG");
        }
        return this.reuRepository.save(reu);
    }

    public Reu buscar(String rg) {
        return this.reuRepository.findById(rg)
                .orElseThrow(() -> new NegocioException("Não existe um Réu cadastrado com esse RG"));
    }

}
