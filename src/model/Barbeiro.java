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
public class Barbeiro extends Pessoa{
    private int registro_carteira;

    public Barbeiro(int registro_carteira, int id, String nome, String cpf, String telefone, String data_de_nascimento, String email) {
        super(id, nome, cpf, telefone, data_de_nascimento, email);
        this.registro_carteira = registro_carteira;
    }

    public Barbeiro(int registro_carteira, int id, String nome, String cpf) {
        super(id, nome, cpf);
        this.registro_carteira = registro_carteira;
    }

   
    public int getRegistro_carteira() {
        return registro_carteira;
    }

    public void setRegistro_carteira(int registro_carteira) {
        this.registro_carteira = registro_carteira;
    }

}
