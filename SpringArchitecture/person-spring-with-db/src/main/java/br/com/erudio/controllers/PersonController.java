package br.com.erudio.controllers;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.models.Person;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Controlador dos cálculos matemáticos
 * @author Greg
 * @version 1.0
 * @since 2023-12-05
 * */
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonService service;

	/*
	 * Buscar todos os persons e transformando em um PersonVO
	 * @return List<Person>
	 * */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	/*
	 * Buscar um person por ID e transformando em um PersonVO
	 * @return Person
	 * */
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	/*
	 * Criando um person e transformando em um PersonVO
	 * @RequestBody Person
	 * @return Person
	 * */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO personVO) {
		return service.createPerson(personVO);
	}

	/*	@version 2.0
	 * Criando um person e transformando em um PersonVO
	 * @RequestBody Person
	 * @return Person
	 * */
	@PostMapping(value = "/v2",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createV2(@RequestBody PersonVOV2 personVOV2) {
		return service.createPersonV2(personVOV2);
	}

	/*
	 * Atualizando um person e transformando em um PersonVO
	 * @RequestBody Person
	 * @return Person
	 * */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO personVO) {
		return service.updatePerson(personVO);
	}

	/*
	 * Deleta um person
	 * @PathVariable ID do person
	 * */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.deletePerson(id);
		return ResponseEntity.noContent().build();
	}

}
