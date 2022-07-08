/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.barbearia.dal;

import java.sql.*;
/**
 *
 * @author LegendarioP
 */
public class moduloConexao {
    //metodo responsavel por estabelecer a conexão com o banco de dados
    
    public static Connection conector(){
        Connection conexao = null;
        // a linha abaixo "chama" o DRIVER importado
        String driver = "com.mysql.cj.jdbc.Driver";
        // armazenando informações referentes ao banco
        String url = "jdbc:mysql://localhost:3306/dbbarbearia";
        String user = "root";
        String password = "admin";
        //estabelecendo a conexão com o banco
        try { 
            //caso dê certo, execute
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
