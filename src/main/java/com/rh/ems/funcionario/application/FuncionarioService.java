package com.rh.ems.funcionario.application;

import com.rh.ems.funcionario.infrastucture.dto.FuncionarioDto;

import java.util.List;

public interface FuncionarioService {
    FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto);

    FuncionarioDto getFuncionarioById(Long funcionarioId);

    List<FuncionarioDto> getAllFuncionarios();

    FuncionarioDto updateFuncionario(Long funcionarioId, FuncionarioDto updatedFuncionario);

    void deleteFuncionario(Long funcionarioId);
}
