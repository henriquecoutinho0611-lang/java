package com.example.produtos.Service;

import com.example.produtos.DTO.Response.ProdutoResponse;
import com.example.produtos.DTO.request.ProdutoRequest;
import com.example.produtos.Mapp.ProdutosMapp;
import com.example.produtos.Repository.ProdutoRepository;
import com.example.produtos.entity.Produtos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutosMapp produtosMapp;


    public ProdutoService(ProdutoRepository produtoRepository, ProdutosMapp produtosMapp) {
        this.produtoRepository = produtoRepository;
        this.produtosMapp = produtosMapp;

    }
    public ProdutoResponse saver(ProdutoRequest Request) {
        Produtos produtos = produtosMapp.toEntity(Request);
        produtoRepository.save(produtos);
        return produtosMapp.toResponse(produtos);
    }
    public List<Produtos> listTodos(){
        return produtoRepository.findAll().stream().map(Produtos :: toResponse).toList();
    }
    public void deleteById(Long id){
        produtoRepository.deleteById(id);

    }
    public ProdutoResponse atualizar(Long id,ProdutoRequest Request) {
        Produtos p = produtoRepository.findById(id).orElseThrow();
        p.setNome(Request.nome());
        p.setDescricao(Request.descricao());
        p.setLargura(Request.largura());
        p.setObservacao(Request.observacoes());
        p.setAltura(Request.altura());
        p.setCategoria(Request.categoria());
        p.setComprimento(Request.comprimento());
        p.setProfundidade(Request.profundidade());
        return produtosMapp.toResponse(ProdutoRepository.seve(p));

    }



    }





