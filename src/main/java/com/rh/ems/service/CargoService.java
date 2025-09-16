package com.rh.ems.service;

import com.rh.ems.dto.CargoDto;
import java.util.List;

public interface CargoService {
    CargoDto createCargo(CargoDto cargoDto);

    CargoDto getCargoById(Long cargoId);

    List<CargoDto> getAllCargos();

    CargoDto updateCargo(Long cargoId, CargoDto cargoDto);

    void deleteCargo(Long cargoId);
}
