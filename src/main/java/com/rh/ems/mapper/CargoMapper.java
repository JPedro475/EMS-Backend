package com.rh.ems.mapper;

import com.rh.ems.dto.CargoDto;
import com.rh.ems.entity.Cargo;

public class CargoMapper {

    public static CargoDto mapToCargoDto(Cargo cargo) {
        CargoDto dto = new CargoDto();
        dto.setId(cargo.getId());
        dto.setNome(cargo.getNome());
        return dto;
    }

    public static Cargo mapToCargo(CargoDto cargoDto) {
        Cargo cargo = new Cargo();
        cargo.setId(cargoDto.getId());
        cargo.setNome(cargoDto.getNome());
        return cargo;
    }
}
