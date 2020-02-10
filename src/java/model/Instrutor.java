package model;

public class Instrutor{
    private int id, valorhora;
    private String nome, email, login, senha, experiencia;

    public void Instrutor(){}

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorhora() {
        return valorhora;
    }

    public void setValorhora(int valorhora) {
        this.valorhora = valorhora;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getExperiencia(){
        return this.experiencia;
    }

    public void setExperiencia(String experiencia){
        this.experiencia = experiencia;
    }



}