package br.com.backend.services;

import br.com.backend.exception.ResourceNotFoundException;
import br.com.backend.mapper.VoMapper;
import br.com.backend.models.Candidato;
import br.com.backend.models.Vaga;
import br.com.backend.repositories.CandidatoRepository;
import br.com.backend.vo.CandidatoVO;
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
    public List<CandidatoVO> getAll() {
        List<CandidatoVO> vo = VoMapper.parseObjectList(repository.findAll(), CandidatoVO.class);
        return vo;
    }

    /*
     * Cadastrar um Candidato
     * @param Candidato
     * @return Candidato
     * */
    public CandidatoVO create(CandidatoVO candidato) {
        if (candidato.getNome() == null) throw new ResourceNotFoundException();

        Candidato entitie = VoMapper.parseObject(candidato, Candidato.class);
        CandidatoVO vo = VoMapper.parseObject(repository.save(entitie), CandidatoVO.class);
        return vo;
    }
}
