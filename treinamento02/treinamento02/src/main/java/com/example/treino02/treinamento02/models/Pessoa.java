package com.example.treino02.treinamento02.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String datNascimento;
    private String telefone;
    private String email;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;


    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String datNascimento, String telefone, String email, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.datNascimento = datNascimento;
        this.telefone = telefone;
        this.email = email;
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

    public String getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(String datNascimento) {
        this.datNascimento = datNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
