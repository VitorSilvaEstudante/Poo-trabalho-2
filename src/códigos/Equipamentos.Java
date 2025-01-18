package com.mycompany.trabalhopoo2;

import java.util.UUID; //biblioteca de id

public class Equipamento {
    private String id;
    private String nome;
    private String descricao;
    private double valorDiario;
    private boolean stautus;    
}
    public Equipamento(String nome, String descricao, double valorDiario) {
        this.id = UUID.randomUUID().toString(); // Gerar um ID único
        this.nome = nome;
        this.descricao = descricao;
        this.valorDiario = valorDiario;
        this.disponivel = true; 
    }
 public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

