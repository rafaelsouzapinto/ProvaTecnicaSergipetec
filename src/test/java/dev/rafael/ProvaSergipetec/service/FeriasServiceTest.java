package com.exemplo.ferias.service;

import dev.rafael.ProvaSergipetec.dto.FeriasDetalheDTO;
import dev.rafael.ProvaSergipetec.mapper.FeriasMapper;
import dev.rafael.ProvaSergipetec.model.FeriasModel;
import dev.rafael.ProvaSergipetec.repository.FeriasRepository;
import dev.rafael.ProvaSergipetec.service.FeriasService;
import dev.rafael.ProvaSergipetec.service.FeriasServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeriasServiceTest {

    @Mock
    private FeriasRepository feriasRepository;

    @Mock
    private FeriasMapper feriasMapper;

    @InjectMocks
    private FeriasServiceImpl feriasService;

    private FeriasModel mockFerias;
    private FeriasDetalheDTO mockDetalheDTO;
    private Long servidorId = 1L;
    private Long feriasId = 5L;

    @BeforeEach
    void setUp() {
        mockFerias = new FeriasModel();
        mockFerias.setId(feriasId);
        mockFerias.setDataInicio(LocalDate.of(2025, 1, 1));
        mockDetalheDTO = new FeriasDetalheDTO(
                feriasId,
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 30),
                "APROVADA",
                servidorId,
                null
        );
    }

    @Test
    void buscarFeriasPorServidor_deveRetornarListaDeDTOs() {
        when(feriasRepository.findByServidorId(servidorId))
                .thenReturn(List.of(mockFerias));
        when(feriasMapper.toListDTO(anyList()))
                .thenReturn(List.of(mockDetalheDTO));
        List<FeriasDetalheDTO> resultado = feriasService.listarPorServidor(servidorId);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(mockDetalheDTO.id(), resultado.get(0).id());
        verify(feriasRepository, times(1)).findByServidorId(servidorId);
        verify(feriasMapper, times(1)).toListDTO(anyList());
    }

    @Test
    void buscarFeriasPorServidor_deveRetornarListaVaziaQuandoNaoHaFerias() {
        when(feriasRepository.findByServidorId(servidorId))
                .thenReturn(List.of());
        List<FeriasDetalheDTO> resultado = feriasService.listarPorServidor(servidorId);
        assertTrue(resultado.isEmpty());
        verify(feriasRepository, times(1)).findByServidorId(servidorId);
        verify(feriasMapper, times(1)).toListDTO(anyList());
    }

    @Test
    void buscarDetalheFerias_deveRetornarDTO() {
        when(feriasRepository.findById(feriasId)).thenReturn(Optional.of(mockFerias));
        when(feriasMapper.toDetalheDTO(mockFerias)).thenReturn(mockDetalheDTO);
        FeriasDetalheDTO resultado = feriasService.buscarPorId(feriasId);
        assertNotNull(resultado);
        assertEquals(mockDetalheDTO.id(), resultado.id());
        verify(feriasRepository, times(1)).findById(feriasId);
        verify(feriasMapper, times(1)).toDetalheDTO(mockFerias);
    }

    @Test
    void buscarDetalheFerias_deveLancarExcecaoQuandoNaoEncontrado() {
        when(feriasRepository.findById(feriasId)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> {
            feriasService.buscarPorId(feriasId);
        });
        verify(feriasRepository, times(1)).findById(feriasId);
        verify(feriasMapper, never()).toDetalheDTO(any());
    }
}