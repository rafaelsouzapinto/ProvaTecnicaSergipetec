package dev.rafael.ProvaSergipetec.controller;

import dev.rafael.ProvaSergipetec.dto.FeriasDetalheDTO;
import dev.rafael.ProvaSergipetec.dto.FeriasInputDTO;
import dev.rafael.ProvaSergipetec.service.FeriasServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FeriasController {

    private final FeriasServiceImpl feriasService;

    public FeriasController(FeriasServiceImpl feriasService) {
        this.feriasService = feriasService;
    }

    @GetMapping("/servidores/{servidorId}/ferias")
    public ResponseEntity<List<FeriasDetalheDTO>> listarFeriasPorServidor(@PathVariable Long servidorId) {
        List<FeriasDetalheDTO> feriasList = feriasService.listarPorServidor(servidorId);
        return ResponseEntity.ok(feriasList);
    }

    @GetMapping("/ferias/{feriasId}")
    public ResponseEntity<FeriasDetalheDTO> obterDetalheFerias(@PathVariable Long feriasId) {
        try {
            FeriasDetalheDTO detalhe = feriasService.buscarPorId(feriasId);
            return ResponseEntity.ok(detalhe);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ferias")
    public ResponseEntity<FeriasDetalheDTO> criarFerias(@RequestBody FeriasInputDTO inputDTO) {
        try {
            FeriasDetalheDTO feriasCriada = feriasService.criarNovaFerias(inputDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(feriasCriada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
