package com.example.ifbademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ifbademo.model.Fornecedor;
import com.example.ifbademo.repository.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public void salvar(Fornecedor f){
        repository.save(f);
    }

   
    public boolean excluirPorId(Long id){
        if (! fornecedorTemMovimentacao(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    private boolean fornecedorTemMovimentacao(Long id){
        return repository.existsByMovimentacoes_Id(id);
    } 

    public Fornecedor buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Fornecedor> buscarTodos(){
        return repository.findAll();
    }
}
