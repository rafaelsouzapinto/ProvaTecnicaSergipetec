package dev.rafael.ProvaSergipetec.service;

import dev.rafael.ProvaSergipetec.dto.LoginRequestDTO;
import dev.rafael.ProvaSergipetec.model.ServidorModel;
import dev.rafael.ProvaSergipetec.repository.ServidorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServidorServiceImpl implements ServidorService{

    private final ServidorRepository servidorRepository;

    public ServidorServiceImpl(ServidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    @Override
    public Long simularLogin(LoginRequestDTO loginRequest) {
        Optional<ServidorModel> servidor = servidorRepository.findByMatriculaAndSenha(
                loginRequest.matricula(),
                loginRequest.senha()
        );
        if (servidor.isEmpty()) {
            throw new RuntimeException("Matrícula ou senha inválida.");
        }
        return servidor.get().getId();
    }
}
