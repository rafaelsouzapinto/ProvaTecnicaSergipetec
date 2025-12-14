package dev.rafael.ProvaSergipetec.controller;

import dev.rafael.ProvaSergipetec.dto.LoginRequestDTO;
import dev.rafael.ProvaSergipetec.service.ServidorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServidorController {

    private final ServidorServiceImpl servidorService;

    public ServidorController(ServidorServiceImpl servidorService) {
        this.servidorService = servidorService;
    }

    @PostMapping("/login")
    public ResponseEntity<Long> loginSimulado(@RequestBody LoginRequestDTO loginRequest) {
        try {
            Long servidorId = servidorService.simularLogin(loginRequest);
            return ResponseEntity.ok(servidorId);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}