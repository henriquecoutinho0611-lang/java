package com.example.alunos.dto;

import java.util.List;
import java.time.LocalDate;

public record AlunoResponse(Long id, String nome, String telefone, LocalDate dataNascimento, List<MatriculaDTO> matriculas ) {
}
