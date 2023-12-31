package br.com.backend.services;

import br.com.backend.exception.ResourceNotFoundException;
import br.com.backend.mapper.VoMapper;
import br.com.backend.models.Vaga;
import br.com.backend.repositories.CandidatoRepository;
import br.com.backend.repositories.VagaRepository;
import br.com.backend.vo.VagaVO;
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

    @Autowired
    private CandidatoRepository candidatoRepository;

    /*
    * Buscar todas as vagas cadastradas
    * @param
    * @return List<VagaVO>
    * */
    public List<Vaga> getAll() {
        //List<VagaVO> vo = VoMapper.parseObjectList(repository.findAll(), VagaVO.class);
        return repository.findAll();
    }

    /*
     * Cadastrar uma vaga
     * @param VagaVO
     * @return Vaga
     * */
    public VagaVO create(VagaVO vaga) {
        if (vaga == null) throw new ResourceNotFoundException();

        Vaga entitie = VoMapper.parseObject(vaga, Vaga.class);
        VagaVO vo = VoMapper.parseObject(repository.save(entitie), VagaVO.class);
        return vo;
    }
}
