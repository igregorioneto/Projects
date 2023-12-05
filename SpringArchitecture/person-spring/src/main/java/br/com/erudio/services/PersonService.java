package br.com.erudio.services;

import br.com.erudio.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    /*
     * Listagem de persons
     * @return List<Person>
     * */
    public List<Person> findAll() {
        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    /*
     * Buscar Person por ID
     * @param id
     * @return Person
     * */
    public Person findById(String id) {
        logger.info("Finding one people!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name ");
        person.setLastName("Last name ");
        person.setAddress("In Brazil ");
        person.setGender("Male");
        return person;
    }

    /*
     * Criando um person
     * @param Person
     * @return Person
     * */
    public Person createPerson(Person person) {
        logger.info("Creating one people!");
        person.setId(counter.incrementAndGet());
        return person;
    }

    /*
     * Atualizando um person
     * @param Person
     * @return Person
     * */
    public Person updatePerson(Person person) {
        logger.info("Updating one people!");
        person.setId(counter.incrementAndGet());
        return person;
    }

    /*
     * Deletando um person
     * */
    public void deletePerson(String id) {
        logger.info("Deleting one people!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("In Brazil " + i);
        person.setGender("Male");
        return person;
    }

}
