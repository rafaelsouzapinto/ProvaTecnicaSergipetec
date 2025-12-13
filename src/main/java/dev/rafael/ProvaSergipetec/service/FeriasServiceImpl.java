package dev.rafael.ProvaSergipetec.service;

import dev.rafael.ProvaSergipetec.dto.FeriasDetalheDTO;
import dev.rafael.ProvaSergipetec.mapper.FeriasMapper;
import dev.rafael.ProvaSergipetec.model.FeriasModel;
import dev.rafael.ProvaSergipetec.repository.FeriasRepository;
import dev.rafael.ProvaSergipetec.service.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public class FeriasServiceImpl implements FeriasService {

    private final FeriasRepository feriasRepository;
    private final FeriasMapper feriasMapper;

    public FeriasServiceImpl(FeriasRepository feriasRepository, FeriasMapper feriasMapper) {
        this.feriasRepository = feriasRepository;
        this.feriasMapper = feriasMapper;
    }

    @Override
    public List<FeriasDetalheDTO> listarPorServidor(Long servidorId) {
        List<FeriasModel> feriasList = feriasRepository.findByServidorId(servidorId);
        return feriasMapper.toListDTO(feriasList);
    }

    @Override
    public FeriasDetalheDTO buscarPorId(Long feriasId) {
        Optional<FeriasModel> feriasOptional = feriasRepository.findById(feriasId);
        FeriasModel ferias = feriasOptional.orElseThrow(
                () -> new ResourceNotFoundException("Férias não encontrada com ID: " + feriasId)
        );
        return feriasMapper.toDetalheDTO(ferias);
    }
}
