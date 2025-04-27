package com.rh.ems.mapper;

import com.rh.ems.dto.FuncionarioDto;
import com.rh.ems.entity.Funcionario;

public class FuncionarioMapper {
    public static FuncionarioDto mapToFuncionarioDto(Funcionario funcionario){
        return new FuncionarioDto(
                funcionario.getId(),
                funcionario.getPrimeiroNome(),
                funcionario.getUltimoNome(),
                funcionario.getEmail()
        );
    }
    public static Funcionario mapToFuncionario(FuncionarioDto funcionarioDto){
        return new Funcionario(
                funcionarioDto.getId(),
                funcionarioDto.getPrimeiroNome(),
                funcionarioDto.getUltimoNome(),
                funcionarioDto.getEmail()
        );
    }
}
