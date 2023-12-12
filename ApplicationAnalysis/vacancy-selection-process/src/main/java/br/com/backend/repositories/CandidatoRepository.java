package br.com.backend.repositories;

import br.com.backend.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Repositório da Candidato
 * @author Greg
 * @verion 1.0
 * @since 2023-12-12
 * */
@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
