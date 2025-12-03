package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ifbademo.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

    public boolean existsByMovimentacoes_Id(Long id);
    
}
