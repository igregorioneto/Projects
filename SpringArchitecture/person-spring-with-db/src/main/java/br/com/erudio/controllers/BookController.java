package br.com.erudio.controllers;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.BookService;
import br.com.erudio.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Controlador dos Books
 * @author Greg
 * @version 1.0
 * @since 2023-12-08
 * */
@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	private BookService service;

	/*
	 * Buscar todos os books e transformando em um PersonVO
	 * @return List<Person>
	 * */
	@GetMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all Book", description = "Finds all Book",
			tags ={"Book"},
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
	public List<BookVO> findAll() {
		return service.findAll();
	}

	/*
	 * Buscar um book por ID e transformando em um PersonVO
	 * @return Person
	 * */
	@GetMapping(value = "/{id}",
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Find all Book", description = "Find all Book",
			tags ={"Book"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public BookVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	/*
	 * Criando um book e transformando em um BookVO
	 * @RequestBody BookVO
	 * @return Book
	 * */
	@PostMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Adds a new Book",
			description = "Adds a new Book by passing in a JSON, XML or YML representation of the person! ",
			tags ={"Book"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public BookVO create(@RequestBody BookVO bookVO) {
		return service.create(bookVO);
	}

	/*
	 * Atualizando um book e transformando em um BookVO
	 * @RequestBody BookVO
	 * @return Book
	 * */
	@PutMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a Book",
			description = "Updates a Book by passing in a JSON, XML or YML representation of the person! ",
			tags ={"Book"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = {@Content(schema = @Schema(implementation = PersonVO.class))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public BookVO update(@RequestBody BookVO bookVO) {
		return service.update(bookVO);
	}

	/*
	 * Deleta um person
	 * @PathVariable ID do person
	 * */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletes a Book",
			description = "Deletes a Book by passing in a JSON, XML or YML representation of the person! ",
			tags ={"Book"},
			responses = {
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			}
	)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
