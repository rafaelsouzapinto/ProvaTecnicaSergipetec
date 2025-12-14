package dev.rafael.ProvaSergipetec.mapper;

import dev.rafael.ProvaSergipetec.dto.PagamentoDTO;
import dev.rafael.ProvaSergipetec.model.PagamentoModel;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PagamentoMapper {

    public PagamentoDTO toDTO(PagamentoModel model) {
        if (model == null) {
            return null;
        }
        return new PagamentoDTO(
                model.getId(),
                model.getValor(),
                model.getDataPagamento(),
                model.getDescricao()
        );
    }

    public List<PagamentoDTO> toListDTO(List<PagamentoModel> models) {
        if (models == null) {
            return Collections.emptyList();
        }
        return models.stream().map(this::toDTO).collect(Collectors.toList());
    }
}