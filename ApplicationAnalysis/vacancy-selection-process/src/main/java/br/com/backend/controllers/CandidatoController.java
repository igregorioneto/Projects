package br.com.backend.controllers;

import br.com.backend.models.Candidato;
import br.com.backend.services.CandidatoService;
import br.com.backend.util.MediaType;
import br.com.backend.vo.CandidatoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller do Candidato
 * @author Greg
 * @verion 1.0
 * @since 2023-12-12
 * */
@RestController
@RequestMapping("/api/candidato/v1")
public class CandidatoController {

    @Autowired
    private CandidatoService service;

    /*
     * Buscar todas as vagas cadastradas
     * @param
     * @return List<Candidato>
     * */
    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    public List<CandidatoVO> findAll() {
        return service.getAll();
    }

    /*
     * Cadastrar um candidato
     * @param Candidato
     * @return Candidato
     * */
    @PostMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    public CandidatoVO create(@RequestBody CandidatoVO candidato) {
        return service.create(candidato);
    }

}
