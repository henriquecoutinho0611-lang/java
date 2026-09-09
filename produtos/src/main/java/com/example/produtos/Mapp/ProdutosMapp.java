package com.example.produtos.Mapp;

import com.example.produtos.DTO.Response.ProdutoResponse;
import com.example.produtos.DTO.request.ProdutoRequest;
import com.example.produtos.entity.Produtos;
import org.springframework.stereotype.Component;

@Component
public class ProdutosMapp {
    
    public Produtos toEntity(ProdutoRequest request) {
        Produtos produto = new Produtos();
        produto.setNome(request.nome());
        produto.setDescricao(request.descricao());
        produto.setAltura(request.altura());
        produto.setComprimento(request.comprimento());
        produto.setProfundidade(request.profundidade());
        produto.setCategoria(request.categoria());
        produto.setObservacao(request.observacao());
        produto.setLargura(request.largura());
        return produto;
    }
    
    public ProdutoResponse toResponse(Produtos produto) {
        return new ProdutoResponse(
            produto.getId(),
            produto.getNome(),
            produto.getLargura(),
            produto.getAltura(),
            produto.getComprimento(),
            produto.getProfundidade(),
            produto.getCategoria(),
            produto.getDescricao(),
            produto.getObservacao()
        );
    }
}
