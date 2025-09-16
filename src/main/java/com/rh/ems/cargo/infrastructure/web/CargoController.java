package com.rh.ems.cargo.infrastructure.web;

import com.rh.ems.cargo.application.CargoService;
import com.rh.ems.cargo.infrastructure.web.dto.CargoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cargos")
public class CargoController {

    private final CargoService cargoService;

    @PostMapping
    public ResponseEntity<CargoDto> createCargo(@RequestBody CargoDto cargoDto) {
        CargoDto savedCargo = cargoService.createCargo(cargoDto);
        return new ResponseEntity<>(savedCargo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDto> getCargoById(@PathVariable("id") Long cargoId) {
        CargoDto cargoDto = cargoService.getCargoById(cargoId);
        return ResponseEntity.ok(cargoDto);
    }

    @GetMapping
    public ResponseEntity<List<CargoDto>> getAllCargos() {
        List<CargoDto> cargos = cargoService.getAllCargos();
        return ResponseEntity.ok(cargos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDto> updateCargo(@PathVariable("id") Long cargoId, @RequestBody CargoDto updatedCargoDto) {
        CargoDto cargoDto = cargoService.updateCargo(cargoId, updatedCargoDto);
        return ResponseEntity.ok(cargoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCargo(@PathVariable("id") Long cargoId) {
        cargoService.deleteCargo(cargoId);
        return ResponseEntity.ok("Cargo deletado com sucesso");
    }
}
