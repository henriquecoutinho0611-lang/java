package com.example.produtos.Controller;

import com.example.produtos.DTO.Response.ProdutoResponse;
import com.example.produtos.DTO.request.ProdutoRequest;
import com.example.produtos.Service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoContoller {

    private  final ProdutoService produtoService;

    public ProdutoContoller(ProdutoService produtoService) {
        this.produtoService = produtoService;

    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar (@RequestBody ProdutoRequest request){
       return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(request));

    }
    @GetMapping()
    public List<ProdutoResponse> ListarTodos(){
        return produtoService.listarTodos();
    }
    @PostMapping("{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable long id, @RequestBody ProdutoRequest request){
     return  ResponseEntity.ok(produtoService.atualizar(id,request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable long id){
        produtoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
     }




}
