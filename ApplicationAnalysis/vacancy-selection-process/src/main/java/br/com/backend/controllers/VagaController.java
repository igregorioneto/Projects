package br.com.backend.controllers;

import br.com.backend.models.Vaga;
import br.com.backend.services.VagaService;
import br.com.backend.util.MediaType;
import br.com.backend.vo.VagaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller da Vaga
 * @author Greg
 * @verion 1.0
 * @since 2023-12-11
 * */
@RestController
@RequestMapping("/api/vagas/v1")
public class VagaController {

    @Autowired
    private VagaService service;

    /*
     * Buscar todas as vagas cadastradas
     * @param
     * @return List<VagaVO>
     * */
    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    public List<Vaga> findAll() {
        return service.getAll();
    }

    /*
     * Cadastrar uma vaga
     * @param VagaVO
     * @return VagaVO
     * */
    @PostMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    public VagaVO create(@RequestBody VagaVO vaga) {
        return service.create(vaga);
    }
}
