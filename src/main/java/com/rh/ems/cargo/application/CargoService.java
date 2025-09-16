package com.rh.ems.cargo.application;

import com.rh.ems.cargo.infrastructure.web.dto.CargoDto;

import java.util.List;

public interface CargoService {
    CargoDto createCargo(CargoDto cargoDto);

    CargoDto getCargoById(Long cargoId);

    List<CargoDto> getAllCargos();

    CargoDto updateCargo(Long cargoId, CargoDto cargoDto);

    void deleteCargo(Long cargoId);
}
