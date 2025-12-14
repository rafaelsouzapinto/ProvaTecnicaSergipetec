package dev.rafael.ProvaSergipetec.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record FeriasDetalheDTO(
        Long id,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataInicio,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataFim,
        String statusFerias,
        Long idServidor,
        PagamentoDTO pagamento
) {}
