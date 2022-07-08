/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import View.Login;
import model.Usuario;

/**
 *
 * @author igort
 */
public class LoginController {
    
    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarSistema(){
        //Pegar usuario da view
        Usuario usuario = helper.obterModelo();
        //Pesquisar usuario no banco
        //se usuario da view tiver mesmo usuario e senha do que o do banco, redirecionar para menu
        //senão, mostrar mensagem de erro
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
