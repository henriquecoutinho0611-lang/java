package com.example.alunos.mapper;

import com.example.alunos.dto.AlunoRequest;
import com.example.alunos.dto.AlunoResponse;
import com.example.alunos.dto.MatriculaDTO;
import com.example.alunos.entity.Aluno;
import com.example.alunos.entity.Matricula;
import com.sun.tools.javac.util.List;
import org.springframework.stereotype.Component;


@Component
public class Alunomapper {

    public Aluno toEntity(AlunoRequest request, Matricula matricula) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setDataNascimento(request.dataNascimento());
        aluno.setTelefone(request.telefone());

        List<Matricula> matriculas = request.matriculas().stream().map(m -> {
            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(m.getCodigoMatricula());
            matricula.setDataInicio(m.getDataInicio());
            matricula.setNomeCurso(m.getNomeCurso());

            return matricula;
        }).toList();
        aluno.setMatriculas(matriculas);
        return aluno;
    }


    public AlunoResponse toResponse(Aluno aluno) {
        List<MatriculaDTO> matriculaDTOS = aluno.getMatriculas().stream().map(m ->
           new  MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(),m.getDataInicio())).toList();

        return new AlunoResponse(aluno.getId(), aluno.getNome(),  aluno.getTelefone(), aluno.getDataNascimento(),matriculaDTOS);

    }
}
