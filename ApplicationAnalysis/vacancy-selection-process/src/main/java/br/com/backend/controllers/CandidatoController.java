package br.com.backend.controllers;

import br.com.backend.models.Candidato;
import br.com.backend.models.Vaga;
import br.com.backend.services.CandidatoService;
import br.com.backend.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidato/v1")
public class CandidatoController {

    @Autowired
    private CandidatoService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    public List<Candidato> findAll() {
        return service.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    public Candidato create(@RequestBody Candidato candidato) {
        return service.create(candidato);
    }

}
