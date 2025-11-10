package com.example.ifbademo.model;

import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categoria extends AbstractEntity<Long>{

    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produtos;

}
