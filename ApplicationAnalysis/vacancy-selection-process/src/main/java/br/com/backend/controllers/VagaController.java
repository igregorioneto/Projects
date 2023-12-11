package br.com.backend.controllers;

import br.com.backend.models.Vaga;
import br.com.backend.services.VagaService;
import br.com.backend.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaga/v1")
public class VagaController {

    @Autowired
    private VagaService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    public List<Vaga> findAll() {
        return service.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    public Vaga create(@RequestBody Vaga vaga) {
        return service.create(vaga);
    }

}
