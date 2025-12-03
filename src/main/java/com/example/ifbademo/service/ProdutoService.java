package com.example.ifbademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ifbademo.model.Produto;
import com.example.ifbademo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public void salvar(Produto p){
        repository.save(p);
    }

    public boolean excluirPorId(Long id){
       if(!produtoTemMovimentacao(id)){
            repository.deleteById(id);
            return true;
       } else{
            return false;
       }
    }

    public boolean produtoTemMovimentacao(Long id){
        return repository.existsByMovimentacoes_Id(id);
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Produto> buscarTodos(){
        return repository.findAll();
    }
}
