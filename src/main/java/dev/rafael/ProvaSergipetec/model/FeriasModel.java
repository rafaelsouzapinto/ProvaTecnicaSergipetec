package dev.rafael.ProvaSergipetec.model;

import java.time.LocalDate;

public class FeriasModel {

    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private StatusFerias statusFerias;

    public FeriasModel(Long id, LocalDate dataInicio, LocalDate dataFim, StatusFerias statusFerias) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.statusFerias = statusFerias;
    }
    public FeriasModel() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public StatusFerias getStatusFerias() {
        return statusFerias;
    }
    public void setStatusFerias(StatusFerias statusFerias) {
        this.statusFerias = statusFerias;
    }

    @Override
    public String toString() {
        return "FeriasModel{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}
