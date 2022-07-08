/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import View.Login;
import model.Usuario;

/**
 *
 * @author igort
 */
public class LoginHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String usuario = view.getTextUser().getText();
        String senha = view.getTextPassword().getText();
        Usuario modelo = new Usuario(usuario, senha, 0);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String usuario = modelo.getLogin();
        String senha = modelo.getSenha();
        
        view.getTextUser().setText(usuario);
        view.getTextPassword().setText(senha);
    }
    
    public void limparTela(){
        view.getTextUser().setText("");
        view.getTextPassword().setText("");
    }
}
