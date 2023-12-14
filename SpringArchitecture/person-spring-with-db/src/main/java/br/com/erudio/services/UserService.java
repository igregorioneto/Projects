package br.com.erudio.services;

import br.com.erudio.data.vo.v1.UserVO;
import br.com.erudio.exception.RequireObjectsNullException;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.VoMapper;
import br.com.erudio.models.Permission;
import br.com.erudio.models.User;
import br.com.erudio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService implements UserDetailsService {
    private Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /*
     * Listagem de persons
     * @return List<Person>
     * */
    public List<User> findAll() {
        logger.info("Finding all people!");
        return repository.findAll();
    }

    /*
     * Buscar Person por ID
     * @param id
     * @return Person
     * */
    public User findById(Long id) {
        logger.info("Finding one people!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    /*
     * Criando um person
     * @param Person
     * @return Person
     * */
    public UserVO create(UserVO user) {
        if (user == null) throw new RequireObjectsNullException();

        logger.info("Creating one people!");
        User entity = VoMapper.parseObject(user, User.class);
        entity.encodePassword();
        UserVO vo = VoMapper.parseObject(repository.save(entity), UserVO.class);

        return vo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name " + username + "!");
        User user = repository.findByUsername(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
    }
}
