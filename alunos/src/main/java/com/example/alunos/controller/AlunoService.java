package com.example.alunos.controller;

import com.example.alunos.dto.AlunoRequest;
import com.example.alunos.dto.AlunoResponse;
import com.example.alunos.dto.MatriculaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoService {

    private AlunoSevice alunoSevice;

    public AlunoService(AlunoSevice alunoService) {
        this.alunoSevice = alunoService;

    }

    @PostMapping()
    Public ResponseEntity<AlunoResponse> Criar (@RequestBody AlunoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED ).body(alunoSevice.salvar(request));


    }
    @GetMapping()
    public  List<AlunoResponse> listarTodos(){
        return alunoSevice.listaTodos();
    }
    @GetMapping("{id}/matriculas")
    public List<MatriculaDTO> listarMatriculas(@PathVariable Long id){
      return alunoSevice.listarMatriculas(id);

    }
    @PostMapping("{id}")
public ResponseEntity<AlunoResponse> atualizar(@PathVariable Long id, @RequestBody AlunoRequest resquest){
    return ResponseEntity.ok(alunoSevice.atualizar(id, resquest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> Remover(@PathVariable Long id){
        alunoSevice.remover(id);
        return ResponseEntity.noContent().build();
    }
}
