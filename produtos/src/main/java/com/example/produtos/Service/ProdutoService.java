package com.example.produtos.Service;

import com.example.produtos.DTO.Response.ProdutoResponse;
import com.example.produtos.DTO.request.ProdutoRequest;
import com.example.produtos.Mapp.ProdutosMapp;
import com.example.produtos.Repository.ProdutoRepository;
import com.example.produtos.entity.Produtos;
import jakarta.persistence.EntityNotFoundException;
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

    public ProdutoResponse salvar(ProdutoRequest request) {
        Produtos produtos = produtosMapp.toEntity(request);
        return produtosMapp.toResponse(produtoRepository.save(produtos));
    }

    public List<ProdutoResponse> listarTodos() {
        return produtoRepository.findAll()
            .stream()
            .map(produtosMapp::toResponse)
            .toList();
    }

    public ProdutoResponse obterPorId(Long id) {
        return produtoRepository.findById(id)
            .map(produtosMapp::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
    }

    public void deletarPorId(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }

    public ProdutoResponse atualizar(Long id, ProdutoRequest request) {
        Produtos p = produtoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));

        p.setNome(request.nome());
        p.setDescricao(request.descricao());
        p.setLargura(request.largura());
        p.setAltura(request.altura());
        p.setComprimento(request.comprimento());
        p.setProfundidade(request.profundidade());
        p.setCategoria(request.categoria());
        p.setObservacao(request.observacao());

        return produtosMapp.toResponse(produtoRepository.save(p));
    }
}
