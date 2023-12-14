package br.com.backend.mapper;

import br.com.backend.models.Candidato;
import br.com.backend.models.Vaga;
import br.com.backend.models.VagaCandidato;
import br.com.backend.vo.CandidatoVO;
import br.com.backend.vo.VagaCandidatoVO;
import br.com.backend.vo.VagaVO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class VoMapper {

    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(Vaga.class,VagaVO.class)
                .addMapping(Vaga::getId, VagaVO::setKey);
        mapper.createTypeMap(VagaVO.class,Vaga.class)
                .addMapping(VagaVO::getKey, Vaga::setId);
        mapper.createTypeMap(Candidato.class, CandidatoVO.class)
                .addMapping(Candidato::getId, CandidatoVO::setKey);
        mapper.createTypeMap(CandidatoVO.class, Candidato.class)
                .addMapping(CandidatoVO::getKey, Candidato::setId);
        mapper.createTypeMap(VagaCandidatoVO.class, VagaCandidato.class)
                .addMapping(VagaCandidatoVO::getKey, VagaCandidato::setId);
        mapper.createTypeMap(VagaCandidato.class, VagaCandidatoVO.class)
                .addMapping(VagaCandidato::getId, VagaCandidatoVO::setKey);
    };

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseObjectList(List<O> origins, Class<D> destination) {
        List<D> destinationsObjects = new ArrayList<>();
        for (O origin:origins) {
            destinationsObjects.add(mapper.map(origin, destination));
        }
        return destinationsObjects;
    }

}
