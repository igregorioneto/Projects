package br.com.erudio.mapper;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v1.UserVO;
import br.com.erudio.models.Book;
import br.com.erudio.models.Person;
import br.com.erudio.models.User;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class VoMapper {
    // private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(
                Person.class,
                PersonVO.class)
                .addMapping(Person::getId, PersonVO::setKey);
        mapper.createTypeMap(
                PersonVO.class,
                Person.class)
                .addMapping(PersonVO::getKey, Person::setId);
        mapper.createTypeMap(
                Book.class,
                BookVO.class)
                .addMapping(Book::getId, BookVO::setKey);
        mapper.createTypeMap(
                BookVO.class,
                Book.class)
                .addMapping(BookVO::getKey, Book::setId);
        mapper.createTypeMap(
                User.class,
                UserVO.class)
                .addMapping(User::getId, UserVO::setKey);
        mapper.createTypeMap(
                UserVO.class,
                User.class)
                .addMapping(UserVO::getKey, User::setId);
    };

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origins, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();
        for (O origin:origins) {
          destinationObjects.add(mapper.map(origin, destination));
        }
        return destinationObjects;
    }
}
