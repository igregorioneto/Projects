package br.com.erudio.controllers;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v1.UserVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.models.User;
import br.com.erudio.services.PersonService;
import br.com.erudio.services.UserService;
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
@RequestMapping("/api/user/v1")
@Tag(name = "User", description = "Endpoints for Managing User")
public class UserController {

	@Autowired
	private UserService service;

	/*
	 * Buscar todos os persons e transformando em um PersonVO
	 * @return List<Person>
	 * */
	@GetMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all User", description = "Finds all User",
			tags ={"User"},
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
	public List<User> findAll() {
		return service.findAll();
	}

	/*
	 * Buscar um person por ID e transformando em um PersonVO
	 * @return Person
	 * */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/{id}",
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Find all User", description = "Find all User",
			tags ={"User"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public User findById(@PathVariable(value = "id") Long id) {
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
	@Operation(summary = "Adds a new User",
			description = "Adds a new User by passing in a JSON, XML or YML representation of the person! ",
			tags ={"User"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public UserVO create(@RequestBody UserVO user) {
		return service.create(user);
	}

}
