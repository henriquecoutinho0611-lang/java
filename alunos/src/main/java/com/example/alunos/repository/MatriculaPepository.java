package com.example.alunos.repository;

import com.example.alunos.entity.Matricula;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaPepository extends JpaRepository< Matricula, Long> {
}
