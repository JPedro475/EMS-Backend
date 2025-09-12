package com.rh.ems.service.impl;

import com.rh.ems.dto.FuncionarioDto;
import com.rh.ems.entity.Funcionario;
import com.rh.ems.exception.NotFoundException;
import com.rh.ems.mapper.FuncionarioMapper;
import com.rh.ems.repository.FuncionarioRepository;
import com.rh.ems.service.FuncionarioService;
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

    @Override
    public FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = FuncionarioMapper.mapToFuncionario(funcionarioDto);
        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);
        return FuncionarioMapper.mapToFuncionarioDto(savedFuncionario);
    }

    @Override
    public FuncionarioDto getFuncionarioById(Long funcionarioId) {
       Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(()
                        -> new NotFoundException("Funcionário não foi encontrado com este Id : " + funcionarioId));
        return FuncionarioMapper.mapToFuncionarioDto(funcionario);
    }

    @Override
    public List<FuncionarioDto> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map((funcionario) -> FuncionarioMapper.mapToFuncionarioDto(funcionario))
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioDto updateFuncionario(Long funcionarioId, FuncionarioDto updatedFuncionario) {

      Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(
                () -> new NotFoundException("Funcionário não existe:" + funcionarioId)
        );
      funcionario.setPrimeiroNome(updatedFuncionario.getPrimeiroNome());
      funcionario.setUltimoNome(updatedFuncionario.getUltimoNome());
      funcionario.setEmail(updatedFuncionario.getEmail());

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
