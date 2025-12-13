package dev.rafael.ProvaSergipetec.mapper;

import dev.rafael.ProvaSergipetec.dto.FeriasDetalheDTO;
import dev.rafael.ProvaSergipetec.dto.PagamentoDTO;
import dev.rafael.ProvaSergipetec.model.FeriasModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeriasMapper {

    public FeriasDetalheDTO toDetalheDTO(FeriasModel model) {
        PagamentoDTO pagamentoDTO = null;
        if (model.getPagamento() != null) {
            pagamentoDTO = new PagamentoDTO(
                    model.getPagamento().getId(),
                    model.getPagamento().getValor(),
                    model.getPagamento().getDataPagamento(),
                    model.getPagamento().getDescricao()
            );
        }

        return new FeriasDetalheDTO(
                model.getId(),
                model.getDataInicio(),
                model.getDataFim(),
                model.getStatusFerias().name(),
                model.getServidor().getId(),
                pagamentoDTO
        );
    }

    public List<FeriasDetalheDTO> toListDTO(List<FeriasModel> models) {
        return models.stream()
                .map(this::toDetalheDTO)
                .collect(Collectors.toList());
    }
}
