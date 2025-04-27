package com.rh.ems.service;

import com.rh.ems.dto.FuncionarioDto;

import java.util.List;

public interface FuncionarioService {
    FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto);

    FuncionarioDto getFuncionarioById(Long funcionarioId);

    List<FuncionarioDto> getAllFuncionarios();

    FuncionarioDto updateFuncionario(Long funcionarioId, FuncionarioDto updatedFuncionario);
}
