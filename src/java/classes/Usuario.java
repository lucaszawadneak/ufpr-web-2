package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laboratorio
 */
public class Usuario {
    String nome;
    String login;
    String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getNome(){
        return nome;
    }
    
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
