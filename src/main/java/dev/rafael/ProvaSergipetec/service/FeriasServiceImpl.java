package dev.rafael.ProvaSergipetec.service;

import dev.rafael.ProvaSergipetec.dto.FeriasDetalheDTO;
import dev.rafael.ProvaSergipetec.dto.LoginRequestDTO;
import dev.rafael.ProvaSergipetec.mapper.FeriasMapper;
import dev.rafael.ProvaSergipetec.model.FeriasModel;
import dev.rafael.ProvaSergipetec.model.ServidorModel;
import dev.rafael.ProvaSergipetec.repository.FeriasRepository;
import dev.rafael.ProvaSergipetec.repository.ServidorRepository;
import dev.rafael.ProvaSergipetec.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeriasServiceImpl implements FeriasService {

    private final FeriasRepository feriasRepository;
    private final ServidorRepository servidorRepository;
    private final FeriasMapper feriasMapper;

    public FeriasServiceImpl(FeriasRepository feriasRepository, ServidorRepository servidorRepository, FeriasMapper feriasMapper) {
        this.feriasRepository = feriasRepository;
        this.servidorRepository = servidorRepository;
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
