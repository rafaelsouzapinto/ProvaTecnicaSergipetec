package dev.rafael.ProvaSergipetec.model;

public class ServidorModel {

    private Long id;
    private String name;
    private String email;
    private String matricula;

    public ServidorModel(Long id, String name, String email, String matricula) {
        this.id = id;
        this.name = name;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "ServidorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
