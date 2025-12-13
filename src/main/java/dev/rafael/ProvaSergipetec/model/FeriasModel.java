package dev.rafael.ProvaSergipetec.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ferias_tb")
public class FeriasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusFerias statusFerias;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servidor_id", nullable = false)
    private ServidorModel servidor;

    @OneToOne(mappedBy = "ferias", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PagamentoModel pagamento;

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
    public ServidorModel getServidor() {
        return servidor;
    }
    public void setServidor(ServidorModel servidor) {
        this.servidor = servidor;
    }
    public PagamentoModel getPagamento() {
        return pagamento;
    }
    public void setPagamento(PagamentoModel pagamento) {
        this.pagamento = pagamento;
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
