package dev.rafael.ProvaSergipetec.dto;

import dev.rafael.ProvaSergipetec.model.FeriasModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoDTO(
        Long id,
        BigDecimal valor,
        LocalDate dataPagamento,
        String descricao
) {}
