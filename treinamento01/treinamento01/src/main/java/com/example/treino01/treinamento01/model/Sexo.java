package com.example.treino01.treinamento01.model;

public enum Sexo {
    MASCULINO ("Masculino"),
    FEMININO ("Feminino");

    private String txt;

    Sexo(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }
}
