package dev.rafael.ProvaSergipetec.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servidor_tb")
public class ServidorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FeriasModel> ferias = new ArrayList<>();

    public ServidorModel(Long id, String nome, String email, String matricula, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.senha = senha;
    }
    public ServidorModel() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public List<FeriasModel> getFerias() {
        return ferias;
    }

    @Override
    public String toString() {
        return "ServidorModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", matricula='" + matricula + '\'' +
                ", senha='" + senha + '\'' +
                ", ferias=" + ferias +
                '}';
    }
}
