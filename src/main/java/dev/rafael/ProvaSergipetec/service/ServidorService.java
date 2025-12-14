package dev.rafael.ProvaSergipetec.service;

import dev.rafael.ProvaSergipetec.dto.LoginRequestDTO;

public interface ServidorService {

    Long simularLogin(LoginRequestDTO loginRequest);
}
