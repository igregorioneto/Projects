package br.com.erudio.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.VoMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.models.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

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

        return VoMapper.parseListObjects(repository.findAll(), PersonVO.class);
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

        return VoMapper.parseObject(entity, PersonVO.class);
    }

    /*
     * Criando um person
     * @param Person
     * @return Person
     * */
    public PersonVO createPerson(PersonVO personVO) {
        logger.info("Creating one people!");
        Person entity = VoMapper.parseObject(personVO, Person.class);
        return VoMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    /*
     * Atualizando um person
     * @param Person
     * @return Person
     * */
    public PersonVO updatePerson(PersonVO person) {
        logger.info("Updating one people!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return VoMapper.parseObject(repository.save(entity), PersonVO.class);
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
