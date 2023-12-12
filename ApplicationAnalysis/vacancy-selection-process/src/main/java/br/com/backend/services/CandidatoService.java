package br.com.backend.services;

import br.com.backend.models.Candidato;
import br.com.backend.models.Vaga;
import br.com.backend.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/*
* Serviço da Candidato
* @author Greg
* @verion 1.0
* @since 2023-12-12
* */
@Service
public class CandidatoService {

    private Logger logger = Logger.getLogger(CandidatoService.class.getName());

    @Autowired
    private CandidatoRepository repository;

    /*
    * Buscar todas os candidatos cadastradas
    * @param
    * @return List<Candidato>
    * */
    public List<Candidato> getAll() {
        return repository.findAll();
    }

    /*
     * Cadastrar um Candidato
     * @param Candidato
     * @return Candidato
     * */
    public Candidato create(Candidato candidato) {
        return repository.save(candidato);
    }
}
