package dev.rafael.ProvaSergipetec.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusFerias {
    SOLICITADA("Solicitada"),
    EM_ANALISE("Em_analise"),
    APROVADA("Aprovada"),
    REPROVADA("Reprovada"),
    AGENDADA("Agendada");

    private final String nomeFormatado;

    StatusFerias(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

    @JsonValue
    public String getNomeFormatado() {
        return nomeFormatado;
    }

    @JsonCreator
    public static StatusFerias fromString(String nome) {
        for (StatusFerias tipo : StatusFerias.values()) {
            if (tipo.getNomeFormatado().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de combustível inválido: " + nome);
    }
}
