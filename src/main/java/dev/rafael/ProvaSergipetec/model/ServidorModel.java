package dev.rafael.ProvaSergipetec.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servidor_tb")
public class ServidorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FeriasModel> ferias;

    public ServidorModel(Long id, String nome, String email, String matricula) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
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
    public List<FeriasModel> getFerias() {
        return ferias;
    }


    @Override
    public String toString() {
        return "ServidorModel{" +
                "id=" + id +
                ", name='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
