package dev.rafael.ProvaSergipetec.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoDTO(
        Long id,
        BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataPagamento,
        String descricao
) {}
