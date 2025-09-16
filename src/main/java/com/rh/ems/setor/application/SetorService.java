package com.rh.ems.setor.application;

import com.rh.ems.setor.infrastructure.dto.SetorDto;

import java.util.List;

public interface SetorService {
    SetorDto createSetor(SetorDto setorDto);
    SetorDto getSetorById(Long setorId);
    List<SetorDto> getAllSetores();
    SetorDto updateSetor(Long setorId, SetorDto setorDto);
    void deleteSetor(Long setorId);
}
