package com.example.ifbademo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component(value = "bean")
@Scope("view") //Ao mudar de página o bean é reiniciado
//@Scope("singleton") //padrao um bean por container
//@Scope("session")  // cada sessao aberta tem um bean (abrir duas paginas distintas)
@SessionScope
//@Scope("request")  //  tempo de vida do bean uma requisição
@RequestScope
//@Scope("application")  // tempo de vida da aplicação do servidor
//@ApplicationScope
@Data
public class OlaBean {
    private String nome;
    private String sobrenome;
    private String nomeCompleto;
    private List<String> nomes = new ArrayList<>();

    public void dizerOla(){
        this.nomeCompleto = this.nome.toUpperCase()+" "+this.sobrenome.toUpperCase();
        this.nomes.add(nomeCompleto);
    }
}
