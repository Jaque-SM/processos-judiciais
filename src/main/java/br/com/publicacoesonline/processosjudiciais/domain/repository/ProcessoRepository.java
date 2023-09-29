package br.com.publicacoesonline.processosjudiciais.domain.repository;

import br.com.publicacoesonline.processosjudiciais.domain.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, String> {
    Optional<Processo> findById(String numero);
}
