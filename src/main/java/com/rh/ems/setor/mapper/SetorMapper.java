package com.rh.ems.setor.mapper;

import com.rh.ems.setor.infrastructure.dto.SetorDto;
import com.rh.ems.setor.domain.Setor;

public class SetorMapper {
    public static SetorDto mapToSetorDto(Setor setor) {
        SetorDto dto = new SetorDto();
        dto.setId(setor.getId());
        dto.setNome(setor.getNome());
        return dto;
    }

    public static Setor mapToSetor(SetorDto setorDto) {
        Setor setor = new Setor();
        setor.setId(setorDto.getId());
        setor.setNome(setorDto.getNome());
        return setor;
    }
}
