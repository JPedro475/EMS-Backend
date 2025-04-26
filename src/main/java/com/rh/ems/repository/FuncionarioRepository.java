package com.rh.ems.repository;

import com.rh.ems.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
