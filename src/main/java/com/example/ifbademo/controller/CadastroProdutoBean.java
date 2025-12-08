package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.example.ifbademo.model.Categoria;
import com.example.ifbademo.model.Fornecedor;
import com.example.ifbademo.model.Produto;
import com.example.ifbademo.service.CategoriaService;
import com.example.ifbademo.service.ProdutoService;

import lombok.*;

@Controller
@Scope("view")
public class CadastroProdutoBean {
    @Getter @Setter
    private Produto produto;
    // carega uma lista de categorias
    @Getter
    private List<Categoria> listaCategorias;
    @Autowired
    private ProdutoService service;
    @Autowired
    private CategoriaService categService;
    
    @PostConstruct
    public void init(){
        produto = new Produto();
        listaCategorias = categService.buscarTodos();
    }

    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        service.salvar(produto);
        // Prepara para cadastrar uma nova produto
        produto = new Produto();
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, 
            "Cadastro efetuado.", "Produto cadastrada com sucesso.");
        context.addMessage(null, mensagem);

    }

    public void prepararCadastro(){
        produto = service.buscarPorId(produto.getId());
    }
}
