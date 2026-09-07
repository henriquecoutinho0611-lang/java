package com.example.alunos.dto;

import com.sun.tools.javac.util.List;

import java.time.LocalDate;

public record AlunoRequest(String nome, String telefone, LocalDate dataNascimento, List<MatriculaDTO> matriculas)  {
}
