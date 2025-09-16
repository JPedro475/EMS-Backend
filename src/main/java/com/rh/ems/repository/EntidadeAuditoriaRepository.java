package com.rh.ems.repository;

import com.rh.ems.audit.EntidadeAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadeAuditoriaRepository  extends JpaRepository<EntidadeAuditoria, Integer> {
}
