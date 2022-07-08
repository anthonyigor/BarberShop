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
public class Usuario extends Pessoa{
    private String login;
    private String senha;

    public Usuario(String login, String senha, int id, String nome, String cpf, String telefone, String data_de_nascimento, String email) {
        super(id, nome, cpf, telefone, data_de_nascimento, email);
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha, int id) {
        super(id);
        this.login = login;
        this.senha = senha;
    }
    
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    

    
    
}
