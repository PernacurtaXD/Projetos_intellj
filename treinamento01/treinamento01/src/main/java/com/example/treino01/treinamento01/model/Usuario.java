package com.example.treino01.treinamento01.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tab_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String idade;
    private String datNascimento;
    private double peso;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;


    public Usuario() {
    }

    public Usuario(Long id, String nome, String idade, String datNascimento, double peso, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.datNascimento = datNascimento;
        this.peso = peso;
        this.sexo = sexo;
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(String datNascimento) {
        this.datNascimento = datNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
