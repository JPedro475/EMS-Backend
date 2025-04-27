package com.rh.ems.controller;


import com.rh.ems.dto.FuncionarioDto;
import com.rh.ems.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    //Funcionario REST API
    @PostMapping
    public ResponseEntity<FuncionarioDto> createFuncionario(@RequestBody FuncionarioDto funcionarioDto){
        FuncionarioDto savedFuncionario = funcionarioService.createFuncionario(funcionarioDto);
        return new ResponseEntity<>(savedFuncionario, HttpStatus.CREATED);
    }
}
