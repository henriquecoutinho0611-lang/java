package com.example.caculosTrabalista.service;

import com.example.caculosTrabalista.entity.Empregado;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmpregadoService {

    public BigDecimal salarioLiquido(Empregado empregado) {
        BigDecimal salario = empregado.getSalario();
        boolean conducao = empregado.isConducao();

        if(conducao){
            return salario.multiply(BigDecimal.valueOf(0.94));
        }
        return salario;
    }

}
