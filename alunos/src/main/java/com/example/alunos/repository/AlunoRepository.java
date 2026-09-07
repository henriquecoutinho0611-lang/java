package com.example.alunos.repository;

import com.example.alunos.entity.Aluno;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository< Aluno, Long > {

}
