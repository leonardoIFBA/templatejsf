package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.ifbademo.model.Fornecedor;
import com.example.ifbademo.service.FornecedorService;

import lombok.Getter;
import lombok.Setter;

@Service
@Scope("view")
public class ConsultaFornecedoresBean {
    @Getter
    private List<Fornecedor> fornecedores;
    @Getter @Setter
    private Fornecedor fornecedorSelecionado;

    @Autowired
    private FornecedorService service;

    @PostConstruct
    public void init(){
        fornecedores = service.buscarTodos();
    }

    public void excluir(){
         FacesContext context = FacesContext.getCurrentInstance();
        //remove a categoria do banco de dados
        if (service.excluirPorId(fornecedorSelecionado.getId())){
            context.addMessage(null, new FacesMessage("Exclusão", "Fornecedor excluída com sucesso."));
            //consultar();
            fornecedores = service.buscarTodos();
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão.",
                    "Existe Movimentação vinculado a este Fornecedor."));
        }
    }
    
}
