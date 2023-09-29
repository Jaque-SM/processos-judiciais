package br.com.publicacoesonline.processosjudiciais.domain.repository;

import br.com.publicacoesonline.processosjudiciais.domain.model.Reu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReuRepository extends JpaRepository<Reu, String> {
    Optional<Reu> findById(String s);
}
