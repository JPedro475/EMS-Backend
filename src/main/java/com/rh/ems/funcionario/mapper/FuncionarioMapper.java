package com.rh.ems.funcionario.mapper;

import com.rh.ems.funcionario.infrastucture.dto.FuncionarioDto;
import com.rh.ems.funcionario.domain.Funcionario;

public class FuncionarioMapper {
    public static FuncionarioDto mapToFuncionarioDto(Funcionario funcionario){
        FuncionarioDto dto = new FuncionarioDto();

        dto.setId(funcionario.getId());
        dto.setPrimeiroNome(funcionario.getPrimeiroNome());
        dto.setUltimoNome(funcionario.getUltimoNome());
        dto.setEmail(funcionario.getEmail());

        if (funcionario.getCargo() != null) {
            dto.setCargoId(funcionario.getCargo().getId());
            dto.setCargoNome(funcionario.getCargo().getNome());
        }

        return dto;
    }
    public static Funcionario mapToFuncionario(FuncionarioDto funcionarioDto){
        Funcionario funcionario = new Funcionario();

        funcionario.setId(funcionarioDto.getId());
        funcionario.setPrimeiroNome(funcionarioDto.getPrimeiroNome());
        funcionario.setUltimoNome(funcionarioDto.getUltimoNome());
        funcionario.setEmail(funcionarioDto.getEmail());

        return funcionario;
    }
}
