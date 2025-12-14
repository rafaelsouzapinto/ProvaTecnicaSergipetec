package dev.rafael.ProvaSergipetec.dto;

import java.util.List;

public record ServidorDetalheDTO(
        Long id,
        String nome,
        String email,
        String matricula,
        List<Long> idsFerias
) {}
