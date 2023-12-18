package br.com.backend.services;

import br.com.backend.enums.Localidade;
import br.com.backend.exception.ResourceNotFoundException;
import br.com.backend.mapper.VoMapper;
import br.com.backend.models.Candidato;
import br.com.backend.models.Vaga;
import br.com.backend.models.VagaCandidato;
import br.com.backend.repositories.CandidatoRepository;
import br.com.backend.repositories.VagaCandidatoRepository;
import br.com.backend.repositories.VagaRepository;
import br.com.backend.util.GenerateGraphLocalidade;
import br.com.backend.util.GraphLocalidade;
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

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    /*
    * Buscar todas as vagas cadastradas
    * @param
    * @return List<VagaVO>
    * */
    public List<VagaCandidato> getAll() {
        //return VoMapper.parseObjectList(repository.findAll(), VagaCandidatoVO.class);
        return repository.findAll();
    }

    /*
     * Cadastrar uma vaga
     * @param VagaVO
     * @return Vaga
     * */
    public VagaCandidato create(VagaCandidatoVO vagaCandidatoVO) {
        if (vagaCandidatoVO == null) throw new ResourceNotFoundException();

        Vaga vaga = vagaRepository.findById(vagaCandidatoVO.getVagaId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        Candidato candidato = candidatoRepository.findById(vagaCandidatoVO.getCandidatoId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        //VagaCandidato entitie = VoMapper.parseObject(vaga, VagaCandidato.class);
        //VagaCandidatoVO vo = VoMapper.parseObject(repository.save(entitie), VagaCandidatoVO.class);
        //return vo;
        VagaCandidato vagaCandidato = new VagaCandidato();
        vagaCandidato.setCandidato(candidato);
        vagaCandidato.setVaga(vaga);
        vagaCandidato.setScore(vagaCandidato.getScore());

        return repository.save(vagaCandidato);
    }

    /*
    * Será calculado o SCORE com base na localidade do Candidato e da Vaga.
    * @param VagaCandidato
    * @return
    * */
    public void calculandoOScoreDoCandidatoBaseadoNaLocalidadeDaVaga(VagaCandidato vagaCandidato) {
        GenerateGraphLocalidade g = new GenerateGraphLocalidade();
        for (GraphLocalidade e:g.getNodes()) {
            System.out.println(e.getLocal() + " ");
        }
    }
}
