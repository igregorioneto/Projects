package br.com.erudio.services;

import br.com.erudio.exception.ResourceNotFoundException;
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

    /*
     * Listagem de persons
     * @return List<Person>
     * */
    public List<Person> findAll() {
        logger.info("Finding all people!");

        return repository.findAll();
    }

    /*
     * Buscar Person por ID
     * @param id
     * @return Person
     * */
    public Person findById(Long id) {
        logger.info("Finding one people!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    /*
     * Criando um person
     * @param Person
     * @return Person
     * */
    public Person createPerson(Person person) {
        logger.info("Creating one people!");

        return repository.save(person);
    }

    /*
     * Atualizando um person
     * @param Person
     * @return Person
     * */
    public Person updatePerson(Person person) {
        logger.info("Updating one people!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
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


}
