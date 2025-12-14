package dev.rafael.ProvaSergipetec.mapper;

import dev.rafael.ProvaSergipetec.dto.ServidorDetalheDTO;
import dev.rafael.ProvaSergipetec.model.FeriasModel;
import dev.rafael.ProvaSergipetec.model.ServidorModel;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServidorMapper {

    public ServidorDetalheDTO toDetalheDTO(ServidorModel model) {
        if (model == null) {
            return null;
        }
        List<Long> idsFerias = Collections.emptyList();
        if (model.getFerias() != null) {
            idsFerias = model.getFerias().stream().map(FeriasModel::getId).collect(Collectors.toList());
        }
        return new ServidorDetalheDTO(
                model.getId(),
                model.getNome(),
                model.getEmail(),
                model.getMatricula(),
                idsFerias
        );
    }

    public List<ServidorDetalheDTO> toListDTO(List<ServidorModel> models) {
        return models.stream().map(this::toDetalheDTO).collect(Collectors.toList());
    }
}