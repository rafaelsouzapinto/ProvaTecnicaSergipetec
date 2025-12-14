package dev.rafael.ProvaSergipetec.service;

import dev.rafael.ProvaSergipetec.dto.FeriasDetalheDTO;
import dev.rafael.ProvaSergipetec.dto.LoginRequestDTO;

import java.util.List;

public interface FeriasService {

    List<FeriasDetalheDTO> listarPorServidor(Long servidorId);

    FeriasDetalheDTO buscarPorId(Long id);
}
