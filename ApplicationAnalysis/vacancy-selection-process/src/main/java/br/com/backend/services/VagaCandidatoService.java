package br.com.backend.services;

import br.com.backend.exception.ResourceNotFoundException;
import br.com.backend.mapper.VoMapper;
import br.com.backend.models.Vaga;
import br.com.backend.models.VagaCandidato;
import br.com.backend.repositories.VagaCandidatoRepository;
import br.com.backend.vo.VagaCandidatoVO;
import br.com.backend.vo.VagaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/*
* Serviço da VagaCandidato
* @author Greg
* @verion 1.0
* @since 2023-12-14
* */
@Service
public class VagaCandidatoService {

    private Logger logger = Logger.getLogger(VagaCandidatoService.class.getName());

    @Autowired
    private VagaCandidatoRepository repository;

    /*
    * Buscar todas as vagas cadastradas
    * @param
    * @return List<VagaVO>
    * */
    public List<VagaCandidatoVO> getAll() {
        return VoMapper.parseObjectList(repository.findAll(), VagaCandidatoVO.class);
    }

    /*
     * Cadastrar uma vaga
     * @param VagaVO
     * @return Vaga
     * */
    public VagaCandidatoVO create(VagaCandidatoVO vaga) {
        if (vaga == null) throw new ResourceNotFoundException();

        VagaCandidato entitie = VoMapper.parseObject(vaga, VagaCandidato.class);
        VagaCandidatoVO vo = VoMapper.parseObject(repository.save(entitie), VagaCandidatoVO.class);
        return vo;
    }
}
