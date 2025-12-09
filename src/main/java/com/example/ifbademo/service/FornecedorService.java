package com.example.ifbademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Fornecedor;
import com.example.ifbademo.repository.FornecedorRepository;

@Service
@Transactional(readOnly = true)
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    @Transactional(readOnly = false)
    public void salvar(Fornecedor f){
        repository.save(f);
    }

    @Transactional(readOnly = false)       
    public boolean excluirPorId(Long id){
        if (! fornecedorTemMovimentacao(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    private boolean fornecedorTemMovimentacao(Long id){
        return buscarPorId(id).getMovimentacoes().isEmpty();
        //return repository.existsByMovimentacoes_Id(id);
    } 

    public Fornecedor buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Fornecedor> buscarTodos(){
        return repository.findAll();
    }
}
