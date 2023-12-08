package br.com.erudio.services;

import br.com.erudio.controllers.BookController;
import br.com.erudio.controllers.PersonController;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exception.RequireObjectsNullException;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.VoMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.models.Book;
import br.com.erudio.models.Person;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    private Logger logger = Logger.getLogger(BookService.class.getName());

    @Autowired
    private BookRepository repository;

    /*
     * Listagem de persons
     * @return List<Person>
     * */
    public List<BookVO> findAll() {
        logger.info("Finding all books!");
        List<BookVO> persons = VoMapper.parseListObjects(repository.findAll(), BookVO.class);
        persons
            .stream()
            .forEach(p ->
                    p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }

    /*
     * Buscar Person por ID
     * @param id
     * @return Person
     * */
    public BookVO findById(Long id) {
        logger.info("Finding one book!");

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        BookVO vo = VoMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    /*
     * Criando um person
     * @param Person
     * @return Person
     * */
    public BookVO create(BookVO bookVO) {
        if (bookVO == null) throw new RequireObjectsNullException();

        logger.info("Creating one book!");
        Book entity = VoMapper.parseObject(bookVO, Book.class);
        BookVO vo = VoMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    /*
     * Atualizando um person
     * @param Person
     * @return Person
     * */
    public BookVO update(BookVO bookVO) {
        if (bookVO == null) throw new RequireObjectsNullException();

        logger.info("Updating one book!");

        Book entity = repository.findById(bookVO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setTitle(bookVO.getTitle());
        entity.setPrice(bookVO.getPrice());
        entity.setAuthor(bookVO.getAuthor());
        entity.setLaunchDate(bookVO.getLaunchDate());

        BookVO vo = VoMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    /*
     * Deletando um person
     * */
    public void delete(Long id) {
        logger.info("Deleting one book!");

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
