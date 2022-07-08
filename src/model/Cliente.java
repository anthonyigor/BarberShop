/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author LegendarioP
 */
public class Cliente extends Pessoa {
    private String endereco;
    private String rg;

    public Cliente(String endereco, String rg, int id, String nome, String cpf, String telefone, String data_de_nascimento, String email) {
        super(id, nome, cpf, telefone, data_de_nascimento, email);
        this.endereco = endereco;
        this.rg = rg;
    }

    public Cliente(String endereco, String rg, int id, String nome, String cpf) {
        super(id, nome, cpf);
        this.endereco = endereco;
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
