package dev.rafael.ProvaSergipetec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento_tb")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "descricao")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "ferias_id", referencedColumnName = "id", nullable = false, unique = true)
    private FeriasModel ferias;

    public PagamentoModel(Long id, BigDecimal valor, LocalDate dataPagamento, String descricao) {
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
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
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
    public FeriasModel getFerias() {
        return ferias;
    }
    public void setFerias(FeriasModel ferias) {
        this.ferias = ferias;
    }

    @Override
    public String toString() {
        return "PagamentoModel{" +
                "id=" + id +
                ", valor=" + valor +
                ", dataPagamento=" + dataPagamento +
                ", descricao='" + descricao + '\'' +
                ", ferias=" + ferias +
                '}';
    }
}
