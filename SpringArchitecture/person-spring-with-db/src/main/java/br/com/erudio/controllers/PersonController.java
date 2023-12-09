package br.com.erudio.controllers;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonService;
import br.com.erudio.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Controlador dos Persons
 * @author Greg
 * @version 1.0
 * @since 2023-12-05
 * */
@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PersonController {

	@Autowired
	private PersonService service;

	/*
	 * Buscar todos os persons e transformando em um PersonVO
	 * @return List<Person>
	 * */
	@GetMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all People", description = "Finds all People",
			tags ={"People"},
			responses = {
				@ApiResponse(description = "Success", responseCode = "200",
					content = {
						@Content(
								mediaType = MediaType.APPLICATION_JSON,
								array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
						)
					}),
				@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	/*
	 * Buscar um person por ID e transformando em um PersonVO
	 * @return Person
	 * */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/{id}",
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Find all People", description = "Find all People",
			tags ={"People"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	/*
	 * Criando um person e transformando em um PersonVO
	 * @RequestBody Person
	 * @return Person
	 * */
	@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Adds a new People",
			description = "Adds a new People by passing in a JSON, XML or YML representation of the person! ",
			tags ={"People"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public PersonVO create(@RequestBody PersonVO personVO) {
		return service.createPerson(personVO);
	}

	/*
	 * Atualizando um person e transformando em um PersonVO
	 * @RequestBody Person
	 * @return Person
	 * */
	@PutMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a People",
			description = "Updates a People by passing in a JSON, XML or YML representation of the person! ",
			tags ={"People"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public PersonVO update(@RequestBody PersonVO personVO) {
		return service.updatePerson(personVO);
	}

	/*
	 * Deleta um person
	 * @PathVariable ID do person
	 * */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletes a People",
			description = "Deletes a People by passing in a JSON, XML or YML representation of the person! ",
			tags ={"People"},
			responses = {
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.deletePerson(id);
		return ResponseEntity.noContent().build();
	}



	/*	@version 2.0
	 * Criando um person e transformando em um PersonVO
	 * @RequestBody Person
	 * @return Person
	 * */
	@PostMapping(value = "/v2",
			consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public PersonVOV2 createV2(@RequestBody PersonVOV2 personVOV2) {
		return service.createPersonV2(personVOV2);
	}

}
