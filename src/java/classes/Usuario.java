package classes;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laboratorio
 */
public class Usuario implements Serializable {
    String nome;
    String login;
    String senha;
    Integer id;

    public Usuario(String name, String login, String password) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id,String nome, String login, String senha) {
        this.id = id;
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
