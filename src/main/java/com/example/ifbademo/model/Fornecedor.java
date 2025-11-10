package com.example.ifbademo.model;

import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fornecedor extends AbstractEntity<Long>{
    
    private String nome;
    private String email;
    private String cnpj;
    private String telefone;

    @OneToMany(mappedBy = "fornecedor")
    private List<Movimentacao> movimentacoes;
}
