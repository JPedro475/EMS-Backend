package com.rh.ems.funcionario.application.impl;

import com.rh.ems.funcionario.infrastucture.dto.FuncionarioDto;
import com.rh.ems.cargo.domain.Cargo;
import com.rh.ems.funcionario.domain.Funcionario;
import com.rh.ems.funcionario.application.FuncionarioService;
import com.rh.ems.shared.exception.NotFoundException;
import com.rh.ems.funcionario.mapper.FuncionarioMapper;
import com.rh.ems.cargo.domain.CargoRepository;
import com.rh.ems.funcionario.domain.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private CargoRepository cargoRepository;

    @Override
    public FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = FuncionarioMapper.mapToFuncionario(funcionarioDto);

        if (funcionarioDto.getCargoId() != null) {
            Cargo cargo = cargoRepository.findById(funcionarioDto.getCargoId())
                    .orElseThrow(() -> new NotFoundException("Cargo não encontrado com o ID: " + funcionarioDto.getCargoId()));

            funcionario.setCargo(cargo);
        }

        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);
        return FuncionarioMapper.mapToFuncionarioDto(savedFuncionario);
    }

    @Override
    public FuncionarioDto getFuncionarioById(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new NotFoundException("Funcionário não foi encontrado com este Id : " + funcionarioId));
        return FuncionarioMapper.mapToFuncionarioDto(funcionario);
    }

    @Override
    public List<FuncionarioDto> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map((funcionario) -> FuncionarioMapper.mapToFuncionarioDto(funcionario))
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioDto updateFuncionario(Long funcionarioId, FuncionarioDto updatedFuncionarioDto) {

        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(
                () -> new NotFoundException("Funcionário não existe:" + funcionarioId)
        );

        funcionario.setPrimeiroNome(updatedFuncionarioDto.getPrimeiroNome());
        funcionario.setUltimoNome(updatedFuncionarioDto.getUltimoNome());
        funcionario.setEmail(updatedFuncionarioDto.getEmail());

        if (updatedFuncionarioDto.getCargoId() != null) {
            Cargo cargo = cargoRepository.findById(updatedFuncionarioDto.getCargoId())
                    .orElseThrow(() -> new NotFoundException("Cargo não encontrado com o ID: " + updatedFuncionarioDto.getCargoId()));
            funcionario.setCargo(cargo);
        } else {
            funcionario.setCargo(null);
        }

        Funcionario updatedFuncionarioObj = funcionarioRepository.save(funcionario);
        return FuncionarioMapper.mapToFuncionarioDto(updatedFuncionarioObj);
    }

    @Override
    public void deleteFuncionario(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(
                () -> new NotFoundException("Funcionário não existe:" + funcionarioId)
        );

        funcionarioRepository.deleteById(funcionarioId);
    }
}
