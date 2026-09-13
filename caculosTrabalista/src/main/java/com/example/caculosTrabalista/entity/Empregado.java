package com.example.caculosTrabalista.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Empregado {

    private BigDecimal salario;
    private boolean conducao;
    private int diasTrabalhados;
    private int mesesTrabalhados;
    private int anoTrabalhados;
}
