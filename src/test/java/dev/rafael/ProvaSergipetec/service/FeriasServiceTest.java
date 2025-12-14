package dev.rafael.ProvaSergipetec.service;

import dev.rafael.ProvaSergipetec.dto.FeriasDetalheDTO;
import dev.rafael.ProvaSergipetec.dto.FeriasInputDTO;
import dev.rafael.ProvaSergipetec.mapper.FeriasMapper;
import dev.rafael.ProvaSergipetec.model.FeriasModel;
import dev.rafael.ProvaSergipetec.model.ServidorModel;
import dev.rafael.ProvaSergipetec.model.StatusFerias;
import dev.rafael.ProvaSergipetec.repository.FeriasRepository;
import dev.rafael.ProvaSergipetec.repository.ServidorRepository;
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
    private ServidorRepository servidorRepository;

    @Mock
    private FeriasMapper feriasMapper;

    @InjectMocks
    private FeriasServiceImpl feriasService;

    private FeriasModel mockFerias;
    private FeriasDetalheDTO mockDetalheDTO;
    private Long servidorId = 1L;
    private Long feriasId = 5L;
    private ServidorModel mockServidor;
    private FeriasInputDTO inputDTO;
    private FeriasModel mockFeriasSalva;

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
        mockServidor = new ServidorModel();
        mockServidor.setId(servidorId);
        inputDTO = new FeriasInputDTO(
                servidorId,
                LocalDate.of(2025, 7, 1),
                LocalDate.of(2025, 7, 30)
        );

        mockFeriasSalva = new FeriasModel();
        mockFeriasSalva.setId(feriasId + 1); // Novo ID
        mockFeriasSalva.setStatusFerias(StatusFerias.SOLICITADA);
    }

    @Test
    void buscarFeriasPorServidor_deveRetornarListaDeDTOs() {
        when(feriasRepository.findByServidorId(servidorId)).thenReturn(List.of(mockFerias));
        when(feriasMapper.toListDTO(anyList())).thenReturn(List.of(mockDetalheDTO));
        List<FeriasDetalheDTO> resultado = feriasService.listarPorServidor(servidorId);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(mockDetalheDTO.id(), resultado.get(0).id());
        verify(feriasRepository, times(1)).findByServidorId(servidorId);
        verify(feriasMapper, times(1)).toListDTO(anyList());
    }

    @Test
    void buscarFeriasPorServidor_deveRetornarListaVaziaQuandoNaoHaFerias() {
        when(feriasRepository.findByServidorId(servidorId)).thenReturn(List.of());
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

    @Test
    void criarNovaFerias_deveCriarEretornarDTO() {
        when(servidorRepository.findById(servidorId)).thenReturn(Optional.of(mockServidor));
        when(feriasMapper.toModel(eq(inputDTO), eq(mockServidor), eq(StatusFerias.SOLICITADA))).thenReturn(mockFeriasSalva);
        when(feriasRepository.save(mockFeriasSalva)).thenReturn(mockFeriasSalva);
        when(feriasMapper.toDetalheDTO(mockFeriasSalva)).thenReturn(mockDetalheDTO);

        FeriasDetalheDTO resultado = feriasService.criarNovaFerias(inputDTO);

        assertNotNull(resultado);
        verify(servidorRepository, times(1)).findById(servidorId);
        verify(feriasMapper, times(1)).toModel(eq(inputDTO), any(ServidorModel.class), eq(StatusFerias.SOLICITADA));
        verify(feriasRepository, times(1)).save(mockFeriasSalva);
        verify(feriasMapper, times(1)).toDetalheDTO(mockFeriasSalva);
    }

    @Test
    void criarNovaFerias_deveLancarExcecaoQuandoServidorNaoExiste() {
        when(servidorRepository.findById(servidorId)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> {
            feriasService.criarNovaFerias(inputDTO);
        });
        verify(servidorRepository, times(1)).findById(servidorId);
        verify(feriasRepository, never()).save(any());
        verify(feriasMapper, never()).toModel(any(), any(), any());
    }
}