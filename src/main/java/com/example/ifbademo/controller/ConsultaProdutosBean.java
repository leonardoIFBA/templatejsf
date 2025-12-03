package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Produto;
import com.example.ifbademo.service.ProdutoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ConsultaProdutosBean {
    @Getter
    private List<Produto> produtos;
    @Getter @Setter
    private Produto produtoSelecionado;
    @Autowired
    private ProdutoService service;

    @PostConstruct
    public void init(){
        produtos = service.buscarTodos();
    }

    public void excluir(){
         FacesContext context = FacesContext.getCurrentInstance();
        //remove a categoria do banco de dados
        if (service.excluirPorId(produtoSelecionado.getId())){
            context.addMessage(null, new FacesMessage("Exclusão", "Produto excluído com sucesso."));
            //consultar();
            produtos = service.buscarTodos();
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão.",
                    "Existe Produto vinculado a uma movimentação."));
        }
    }

}
