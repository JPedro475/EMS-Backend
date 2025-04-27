package com.rh.ems.controller;


import com.rh.ems.dto.FuncionarioDto;
import com.rh.ems.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    // Add Funcionario REST API
    @PostMapping
    public ResponseEntity<FuncionarioDto> createFuncionario(@RequestBody FuncionarioDto funcionarioDto){
        FuncionarioDto savedFuncionario = funcionarioService.createFuncionario(funcionarioDto);
        return new ResponseEntity<>(savedFuncionario, HttpStatus.CREATED);
    }

    // Get Funcionario REST API
    @GetMapping("{id}")
    public ResponseEntity<FuncionarioDto> getFuncionarioById(@PathVariable("id") Long funcionarioId){
       FuncionarioDto funcionarioDto = funcionarioService.getFuncionarioById(funcionarioId);
       return ResponseEntity.ok(funcionarioDto);
    }

    // Get All Funcionarios REST API
    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> getAllFuncionarios(){
       List<FuncionarioDto> funcionarios =  funcionarioService.getAllFuncionarios();
       return ResponseEntity.ok(funcionarios);
    }

    // Update Funcionarios REST API
    @PutMapping("{id}")
    public ResponseEntity<FuncionarioDto> updateFuncionario(@PathVariable("id") Long funcionarioId,
                                                            @RequestBody FuncionarioDto updatedFuncionario){
        FuncionarioDto funcionarioDto = funcionarioService.updateFuncionario(funcionarioId, updatedFuncionario);
        return ResponseEntity.ok(funcionarioDto);
    }

    // Delete Funcionarios REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable("id") Long funcionarioId){
        funcionarioService.deleteFuncionario(funcionarioId);
        return ResponseEntity.ok("Funcionário deletado com sucesso!");
    }
}
