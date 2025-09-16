package com.rh.ems.setor.application.impl;

import com.rh.ems.setor.infrastructure.dto.SetorDto;
import com.rh.ems.setor.application.SetorService;
import com.rh.ems.setor.domain.Setor;
import com.rh.ems.setor.domain.SetorRepository;
import com.rh.ems.setor.mapper.SetorMapper;
import com.rh.ems.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SetorServiceImpl implements SetorService {

    private final SetorRepository setorRepository;

    @Override
    public SetorDto createSetor(SetorDto setorDto) {
        Setor setor = SetorMapper.mapToSetor(setorDto);
        Setor savedSetor = setorRepository.save(setor);
        return SetorMapper.mapToSetorDto(savedSetor);
    }

    @Override
    public SetorDto getSetorById(Long setorId) {
        Setor setor = setorRepository.findById(setorId)
                .orElseThrow(() -> new NotFoundException("Setor não encontrado com o ID: " + setorId));
        return SetorMapper.mapToSetorDto(setor);
    }

    @Override
    public List<SetorDto> getAllSetores() {
        List<Setor> setores = setorRepository.findAll();
        return setores.stream()
                .map(SetorMapper::mapToSetorDto)
                .collect(Collectors.toList());
    }

    @Override
    public SetorDto updateSetor(Long setorId, SetorDto updatedSetorDto) {
        Setor setor = setorRepository.findById(setorId)
                .orElseThrow(() -> new NotFoundException("Setor não encontrado com o ID: " + setorId));

        setor.setNome(updatedSetorDto.getNome());

        Setor updatedSetor = setorRepository.save(setor);
        return SetorMapper.mapToSetorDto(updatedSetor);
    }

    @Override
    public void deleteSetor(Long setorId) {
        setorRepository.findById(setorId)
                .orElseThrow(() -> new NotFoundException("Setor não encontrado com o ID: " + setorId));

        setorRepository.deleteById(setorId);
    }
}
