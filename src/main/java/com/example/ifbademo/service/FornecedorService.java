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

    public void excluir(Fornecedor f){
        repository.delete(f);
    }

    public void excluirPorId(Long id){
        repository.deleteById(id);
    }

    public Fornecedor buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Fornecedor> buscarTodos(){
        return repository.findAll();
    }
}
