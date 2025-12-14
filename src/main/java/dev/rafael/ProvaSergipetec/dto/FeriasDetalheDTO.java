package dev.rafael.ProvaSergipetec.dto;

import java.time.LocalDate;

public record FeriasDetalheDTO(
        Long id,
        LocalDate dataInicio,
        LocalDate dataFim,
        String statusFerias,
        Long idServidor,
        PagamentoDTO pagamento
) {}
