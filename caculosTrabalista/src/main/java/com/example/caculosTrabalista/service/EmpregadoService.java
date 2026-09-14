package com.example.caculosTrabalista.service;

import com.example.caculosTrabalista.entity.Empregado;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmpregadoService {

    public BigDecimal salarioLiquido(Empregado empregado) {
        BigDecimal salario = empregado.getSalario();
        boolean conducao = empregado.isConducao();
        BigDecimal limite = new BigDecimal("1621.00");
        if(salario.compareTo(limite) <= 0 && conducao){
         BigDecimal  salarioInss = salario.multiply(BigDecimal.valueOf(0.925));
         BigDecimal  salariocon = salario.multiply(BigDecimal.valueOf(0.06));
         return salarioInss.subtract(salariocon).setScale(2, BigDecimal.ROUND_HALF_UP);
        }else if (salario.compareTo(limite) <= 0){
            return salario.multiply(BigDecimal.valueOf(0.925)).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }
    public BigDecimal decinoTeceiro(Empregado empregado) {
        BigDecimal salario = empregado.getSalario();
        int mesesTrabalhados = empregado.getMesesTrabalhados();
        try {
        if(mesesTrabalhados <= 12){
           BigDecimal posetagem = salario.divide(BigDecimal.valueOf(12));
           BigDecimal decinoTeceiro =  new BigDecimal(String.valueOf(posetagem.multiply(BigDecimal.valueOf(mesesTrabalhados))));
           return decinoTeceiro.multiply(BigDecimal.valueOf(0.925));
        }} catch (Exception e) {
            throw new RuntimeException("numero invalido");
        }

        return null;
    }



}


