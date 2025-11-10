package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.ifbademo.model.Categoria;
import com.example.ifbademo.service.CategoriaService;

import lombok.Getter;
import lombok.Setter;

@Service
@Scope("view")
public class ConsultaCategoriasBean {
    @Getter
    private List<Categoria> categorias;
    @Getter @Setter
    private Categoria categoriaSelecionada;

    @Autowired
    private CategoriaService service;

    @PostConstruct
    public void init(){
        categorias = service.buscarTodos();
    }

    public void excluir(){
         FacesContext context = FacesContext.getCurrentInstance();
        //remove a categoria do banco de dados
        if (service.excluirPorId(categoriaSelecionada.getId())){
            context.addMessage(null, new FacesMessage("Exclusão", "Categoria excluída com sucesso."));
            //consultar();
            categorias = service.buscarTodos();
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão.",
                    "Existe Produto vinculado a este Categoria."));
        }
    }
    
}
