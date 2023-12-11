package br.com.backend.repositories;

import br.com.backend.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Repositório da Vaga
 * @author Greg
 * @verion 1.0
 * @since 2023-12-11
 * */
@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
