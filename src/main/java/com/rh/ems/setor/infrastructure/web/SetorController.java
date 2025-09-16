package com.rh.ems.setor.infrastructure.web;

import com.rh.ems.setor.infrastructure.dto.SetorDto;
import com.rh.ems.setor.application.SetorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/setores")
public class SetorController {

    private final SetorService setorService;

    @PostMapping
    public ResponseEntity<SetorDto> createSetor(@RequestBody SetorDto setorDto) {
        SetorDto savedSetor = setorService.createSetor(setorDto);
        return new ResponseEntity<>(savedSetor, HttpStatus.CREATED);
    }

    // Endpoint para BUSCAR um Setor pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<SetorDto> getSetorById(@PathVariable("id") Long setorId) {
        return ResponseEntity.ok(setorService.getSetorById(setorId));
    }

    // Endpoint para BUSCAR TODOS os Setores
    @GetMapping
    public ResponseEntity<List<SetorDto>> getAllSetores() {
        return ResponseEntity.ok(setorService.getAllSetores());
    }

    // Endpoint para ATUALIZAR um Setor
    @PutMapping("/{id}")
    public ResponseEntity<SetorDto> updateSetor(@PathVariable("id") Long setorId, @RequestBody SetorDto updatedSetorDto) {
        return ResponseEntity.ok(setorService.updateSetor(setorId, updatedSetorDto));
    }

    // Endpoint para DELETAR um Setor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSetor(@PathVariable("id") Long setorId) {
        setorService.deleteSetor(setorId);
        return ResponseEntity.ok("Setor deletado com sucesso!");
    }
}
