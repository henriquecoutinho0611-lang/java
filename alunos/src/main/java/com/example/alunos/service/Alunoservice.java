package com.example.alunos.service;

import com.example.alunos.dto.AlunoRequest;
import com.example.alunos.dto.AlunoResponse;
import com.example.alunos.dto.MatriculaDTO;
import com.example.alunos.entity.Aluno;
import com.example.alunos.entity.Matricula;
import com.example.alunos.mapper.Alunomapper;
import com.example.alunos.repository.AlunoRepository;
import com.sun.tools.javac.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Alunoservice {
   private final AlunoRepository alunoRepository;
   private final Alunomapper alunomapper;

   public Alunoservice(AlunoRepository alunoRepository, Alunomapper alunomapper) {
       this.alunoRepository = alunoRepository;
       this.alunomapper = alunomapper;

   }
   public Alunoservice salvar(AlunoRequest resquest) {
       Aluno aluno = alunomapper.toEntity(resquest);
       alunoRepository.save(aluno);
       return alunomapper.toResponse(aluno);

   }
   public List<AlunoResponse> ListaTodos(){
       return alunoRepository.findAll().stream().map(alunomapper::toResponse).toList();
   }
   public List<MatriculaDTO> listamatricola(Long id){
       Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("aluno nao encontado"));
       return aluno.getMatriculas().stream().map(m -> new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(),m.getDataInicio())).toList();

   }
   public void remover(Long id){
       if(!alunoRepository.findById(id)){
           throw new EntityNotFoundException("aluno nao encontrado");
       }
       alunoRepository.deleteById(id);
   }
 public  AlunoResponse atualizar(long id,AlunoRequest resquest){
     Aluno a = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("aluno nao encontado"));
     a.setNome(resquest.nome());
     a.setTelefone(resquest.telefone());
     a.setDataNascimento(resquest.dataNascimento());

     for( MatriculaDTO m : resquest.matriculas()){
         Matricula matricula = new Matricula();
         matricula.setCodigoMatricula(m.codigoMatricula());
         matricula.setNomeCurso(m.nomeCurso());
         matricula.setDataInicio(m.DataInicio());
         a.getMatriculas().add(matricula);
     }

     return alunomapper.toResponse(alunoRepository.save(a));



 }
}
