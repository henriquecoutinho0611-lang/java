package com.example.caculosTrabalista.contoller;

import com.example.caculosTrabalista.entity.Empregado;
import com.example.caculosTrabalista.service.EmpregadoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculos")
public class Controller {

    private EmpregadoService empregadoService;

    public Controller(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }

    @PostMapping()
    public BigDecimal calcular(@RequestBody Empregado empregado){
        return empregadoService.salarioLiquido(empregado);
    }

}
