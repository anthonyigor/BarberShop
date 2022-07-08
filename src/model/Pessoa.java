/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LegendarioP
 */
 abstract public class Pessoa {
    protected int id;
    protected String cpf;
    protected String telefone;
    protected Date data_de_nascimento;
    protected String email;
    protected String nome;

    public Pessoa(int id, String nome, String cpf, String telefone, String data_de_nascimento, String email) {
        this.id = id;
        this.cpf = cpf;
        this.telefone = telefone;
        try {
            this.data_de_nascimento = new SimpleDateFormat("dd//MM/yyyy").parse(data_de_nascimento);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.email = email;
        this.nome = nome;
    }

    public Pessoa(int id,String nome, String cpf) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Pessoa(int id) {
        this.id = id;
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
