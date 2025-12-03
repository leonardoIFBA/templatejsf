package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ifbademo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    public boolean existsByMovimentacoes_Id(Long id);
    
}
