package br.com.backend.services;

import br.com.backend.models.Vaga;
import br.com.backend.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/*
* Serviço da Vaga
* @author Greg
* @verion 1.0
* @since 2023-12-11
* */
@Service
public class VagaService {

    private Logger logger = Logger.getLogger(VagaService.class.getName());

    @Autowired
    private VagaRepository repository;

    /*
    * Buscar todas as vagas cadastradas
    * @param
    * @return List<Vaga>
    * */
    public List<Vaga> getAll() {
        return repository.findAll();
    }

    /*
     * Cadastrar uma vaga
     * @param Vaga
     * @return Vaga
     * */
    public Vaga create(Vaga vaga) {
        return repository.save(vaga);
    }
}
