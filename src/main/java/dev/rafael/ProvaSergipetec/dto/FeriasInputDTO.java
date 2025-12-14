package dev.rafael.ProvaSergipetec.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record FeriasInputDTO(
        Long idServidor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataInicio,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataFim
) {
}
