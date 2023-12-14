package br.com.backend.controllers;

import br.com.backend.services.VagaCandidatoService;
import br.com.backend.services.VagaService;
import br.com.backend.util.MediaType;
import br.com.backend.vo.VagaCandidatoVO;
import br.com.backend.vo.VagaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller da VagaCandidato
 * @author Greg
 * @verion 1.0
 * @since 2023-12-14
 * */
@RestController
@RequestMapping("/api/candidaturas/v1")
public class VagaCandidatoController {

    @Autowired
    private VagaCandidatoService service;

    /*
     * Buscar todas as vagaCandidatoVO
     * @param
     * @return List<vagaCandidatoVO>
     * */
    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    public List<VagaCandidatoVO> findAll() {
        return service.getAll();
    }

    /*
     * Cadastrar uma vagaCandidatoVO
     * @param vagaCandidatoVO
     * @return vagaCandidatoVO
     * */
    @PostMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    public VagaCandidatoVO create(@RequestBody VagaCandidatoVO vagaCandidatoVO) {
        return service.create(vagaCandidatoVO);
    }
}
