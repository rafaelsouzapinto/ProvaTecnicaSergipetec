package dev.rafael.ProvaSergipetec.model;

import java.time.LocalDate;

public class PagamentoModel {

    private Long id;
    private Double valor;
    private LocalDate dataPagamento;
    private String descricao;

    public PagamentoModel(Long id, Double valor, LocalDate dataPagamento, String descricao) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.descricao = descricao;
    }
    public PagamentoModel() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
