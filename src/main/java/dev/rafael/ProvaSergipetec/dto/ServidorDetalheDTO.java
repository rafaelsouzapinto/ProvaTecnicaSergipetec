package dev.rafael.ProvaSergipetec.dto;

import java.util.List;

public record ServidorDetalheDTO(
        Long id,
        String name,
        String email,
        String matricula,
        List<Long> idsFerias
) {}
