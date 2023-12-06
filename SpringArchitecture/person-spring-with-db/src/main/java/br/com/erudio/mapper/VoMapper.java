package br.com.erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;
// import org.modelmapper.ModelMapper;

public class VoMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    // private static ModelMapper mapper = new ModelMapper();

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
