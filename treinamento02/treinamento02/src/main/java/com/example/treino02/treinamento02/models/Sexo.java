package com.example.treino02.treinamento02.models;

public enum Sexo {
    MASCULINO("Masculino", "M"),
    FEMININO("Feminino", "F");

    private String txt;
    private String caractere;

    Sexo(String txt, String caractere) {
        this.txt = txt;
        this.caractere = caractere;
    }

    public String getTxt() {
        return txt;
    }

    public String getCaractere() {
        return caractere;
    }
}
