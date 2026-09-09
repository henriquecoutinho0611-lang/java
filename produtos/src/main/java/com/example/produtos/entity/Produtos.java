package com.example.produtos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String largura;
    private String altura;
    private String comprimento;
    private String profundidade;
    private String categoria;
    private String observacao;
    private String descricao;

}
