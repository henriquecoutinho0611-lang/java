package com.example.caculosTrabalista.service;

import com.example.caculosTrabalista.entity.Empregado;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmpregadoService {
    private final Empregado empregado;

    public EmpregadoService(Empregado empregado) {
        this.empregado = empregado;

    }

    public BigDecimal SalarioLIquido(Empregado empregado) {
        BigDecimal salario = empregado.getSalario();
        boolean conducao = empregado.isConducao();
        if(conducao){
            salario = salario.multiply(BigDecimal.valueOf(0.94));

          return salario;
        }
        else {
           return salario = salario;
        }

    }


}
