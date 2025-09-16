package com.rh.ems.cargo.application.impl;

import com.rh.ems.cargo.domain.Cargo;
import com.rh.ems.cargo.infrastructure.web.dto.CargoDto;
import com.rh.ems.cargo.domain.CargoRepository;
import com.rh.ems.cargo.application.CargoService;
import com.rh.ems.shared.exception.NotFoundException;
import com.rh.ems.cargo.mapper.CargoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    @Override
    public CargoDto createCargo(CargoDto cargoDto){
        Cargo cargo = CargoMapper.mapToCargo(cargoDto);
        Cargo savedCargo = cargoRepository.save(cargo);
        return CargoMapper.mapToCargoDto(savedCargo);
    }

    @Override
    public CargoDto getCargoById(Long cargoId) {
        Cargo cargo = cargoRepository.findById(cargoId)
                .orElseThrow(()-> new NotFoundException("Cargo não encontrado com o ID: " + cargoId));
        return CargoMapper.mapToCargoDto(cargo);
    }

    @Override
    public List<CargoDto> getAllCargos(){
        List<Cargo> cargos = cargoRepository.findAll();
        return cargos.stream()
                .map(CargoMapper::mapToCargoDto)
                .collect(Collectors.toList());
    }

    @Override
    public CargoDto updateCargo(Long cargoId, CargoDto updatedCargoDto) {
        Cargo cargo = cargoRepository.findById(cargoId)
                .orElseThrow(() -> new NotFoundException("Cargo não encontrado com o ID: " + cargoId));

        cargo.setNome(updatedCargoDto.getNome());

        Cargo updatedcargo = cargoRepository.save(cargo);
        return CargoMapper.mapToCargoDto(updatedcargo);
    }

    @Override
    public void deleteCargo(Long cargoId) {
        cargoRepository.findById(cargoId)
                .orElseThrow(() -> new NotFoundException("Cargo não encontrado com o ID: " + cargoId));

        cargoRepository.deleteById(cargoId);
    }
}
