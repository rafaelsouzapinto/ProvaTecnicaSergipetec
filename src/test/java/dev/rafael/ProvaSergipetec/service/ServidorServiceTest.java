package dev.rafael.ProvaSergipetec.service;

import dev.rafael.ProvaSergipetec.dto.LoginRequestDTO;
import dev.rafael.ProvaSergipetec.model.ServidorModel;
import dev.rafael.ProvaSergipetec.repository.ServidorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServidorServiceTest {

    @Mock
    private ServidorRepository servidorRepository;

    @InjectMocks
    private ServidorServiceImpl servidorService;

    private LoginRequestDTO loginRequest;
    private ServidorModel mockServidor;

    @BeforeEach
    void setUp() {
        loginRequest = new LoginRequestDTO("123456", "senha123");
        mockServidor = new ServidorModel();
        mockServidor.setId(10L);
        mockServidor.setMatricula("123456");
        mockServidor.setSenha("senha123");
    }

    @Test
    void simularLogin_deveRetornarIdServidorEmCasoDeSucesso() {
        when(servidorRepository.findByMatriculaAndSenha("123456", "senha123"))
                .thenReturn(Optional.of(mockServidor));
        Long servidorId = servidorService.simularLogin(loginRequest);
        assertEquals(10L, servidorId);
        verify(servidorRepository, times(1)).findByMatriculaAndSenha("123456", "senha123");
    }

    @Test
    void simularLogin_deveLancarExcecaoEmCasoDeCredenciaisInvalidas() {
        when(servidorRepository.findByMatriculaAndSenha("123456", "senha123"))
                .thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> {
            servidorService.simularLogin(loginRequest);
        });
        verify(servidorRepository, times(1)).findByMatriculaAndSenha("123456", "senha123");
    }
}
