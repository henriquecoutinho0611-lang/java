package com.example.produtos.Mapp;

import com.example.produtos.DTO.Response.ProdutoResponse;
import com.example.produtos.DTO.request.ProdutoRequest;
import com.example.produtos.Repository.ProdutoRepository;
import com.example.produtos.entity.Produtos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutosMapp {
    
    public Produtos toEntity( ProdutoRequest Request) {
        Produtos produto = new Produtos();
        produto.setNome(Request.nome());
        produto.setDescricao(Request.descricao());
        produto.setAltura(Request.altura());
        produto.setComprimento(Request.comprimento());
        produto.setProfundidade(Request.profundidade());
        produto.setCategoria(Request.categoria());
        produto.setObservacao(Request.observacoes());
        produto.setLargura(Request.largura());
        
        return produto;
    }
    public ProdutoResponse toResponse(Produtos produtos){
        List<produtos> produtosList = ProdutoRepository.findAll();

        return  produtosList.stream().map(m -> new ProdutoResponse(produtos.getId(), produtos.getNome(), produtos.getLargura(), produtos.getAltura(), produtos.getObservacao(), produtos.getProfundidade(), produtos.getCategoria(), produtos.getComprimento(), produtos.getObservacao())).toList();
        
        
        
        
        
        
    }
    
    

}
