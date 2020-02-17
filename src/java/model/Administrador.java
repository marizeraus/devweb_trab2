/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marco
 */
public class Administrador {
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    
    public Administrador(){}
    
    public Administrador(int id){
        this.id = id;
    }
    
    public Administrador(int id,String nome, String login, String senha){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public Administrador(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
}
