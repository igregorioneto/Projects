package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.models.Person;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/*Controlador dos cálculos matemáticos
 * @author Greg
 * @version 1.0
 * @since 2023-12-05
 * */
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	/*
	 * Buscar todos os persons
	 * @return List<Person>
	 * */
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return service.findAll();
	}

	/*
	 * Buscar um person por ID
	 * @return Person
	 * */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(
			@PathVariable(value = "id") String id
	) {
		return service.findById(id);
	}

	/*
	 * Criando um person
	 * @RequestBody Person
	 * @return Person
	 * */
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(
			@RequestBody Person person
	) {
		return service.createPerson(person);
	}

	/*
	 * Atualizando um person
	 * @RequestBody Person
	 * @return Person
	 * */
	@RequestMapping(method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(
			@RequestBody Person person
	) {
		return service.updatePerson(person);
	}

	/*
	 * Deleta um person
	 * @PathVariable ID do person
	 * */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void update(
			@PathVariable(value = "id") String id
	) {
		service.deletePerson(id);
	}

}
