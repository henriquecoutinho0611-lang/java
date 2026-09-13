package com.example.caculosTrabalista;

import com.example.caculosTrabalista.entity.Empregado;
import com.example.caculosTrabalista.service.EmpregadoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/caculos")
public class Contoller {

    private EmpregadoService empregadoService;

    public Contoller(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;

    }
    @PostMapping()
    public BigDecimal cacular(Empregado empregado){
        return empregadoService.SalarioLIquido(empregado);
    }

}
