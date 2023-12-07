package br.com.erudio.services;

import br.com.erudio.controllers.PersonController;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exception.RequireObjectsNullException;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.VoMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.models.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper personMapper;

    /*
     * Listagem de persons
     * @return List<Person>
     * */
    public List<PersonVO> findAll() {
        logger.info("Finding all people!");
        List<PersonVO> persons = VoMapper.parseListObjects(repository.findAll(), PersonVO.class);
        persons
            .stream()
            .forEach(p ->
                    p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }

    /*
     * Buscar Person por ID
     * @param id
     * @return Person
     * */
    public PersonVO findById(Long id) {
        logger.info("Finding one people!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        PersonVO vo = VoMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    /*
     * Criando um person
     * @param Person
     * @return Person
     * */
    public PersonVO createPerson(PersonVO personVO) {
        if (personVO == null) throw new RequireObjectsNullException();

        logger.info("Creating one people!");
        Person entity = VoMapper.parseObject(personVO, Person.class);
        PersonVO vo = VoMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    /*
     * Atualizando um person
     * @param Person
     * @return Person
     * */
    public PersonVO updatePerson(PersonVO personVO) {
        if (personVO == null) throw new RequireObjectsNullException();

        logger.info("Updating one people!");

        Person entity = repository.findById(personVO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());

        PersonVO vo = VoMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    /*
     * Deletando um person
     * */
    public void deletePerson(Long id) {
        logger.info("Deleting one people!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }

    /* @version 2.0
     * Criando um person
     * @param Person
     * @return Person
     * */
    public PersonVOV2 createPersonV2(PersonVOV2 personVOV2) {
        logger.info("Creating one people version 2.0!");
        Person entity = personMapper.convertVoToEntity(personVOV2);
        return personMapper.convertEntityToVo(repository.save(entity));
    }
}
