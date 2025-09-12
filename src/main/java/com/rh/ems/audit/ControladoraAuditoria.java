package com.rh.ems.audit;

import org.hibernate.envers.RevisionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ControladoraAuditoria implements RevisionListener {

    private static final Logger logger = LoggerFactory.getLogger(ControladoraAuditoria.class);

    @Override
    public void newRevision(Object revisionEntity) {
        EntidadeAuditoria entidadeRevisao = (EntidadeAuditoria) revisionEntity;

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
                entidadeRevisao.setUsername(auth.getName());
                entidadeRevisao.setRoles(auth.getAuthorities().toString());
            } else {
                entidadeRevisao.setUsername("sistema");
                entidadeRevisao.setRoles("ROLE_SYSTEM");
            }
        } catch (Exception e) {
            logger.error("Não foi possível obter o usuário da sessão para a auditoria.", e);
            entidadeRevisao.setUsername("sistema_erro");
            entidadeRevisao.setRoles("ROLE_UNKNOWN");
        }

        entidadeRevisao.setIp(Optional.ofNullable(ContextoRequisicaoAuditoria.getIp()).orElse("unknown_ip"));
        entidadeRevisao.setMethod(Optional.ofNullable(ContextoRequisicaoAuditoria.getMethod()).orElse("unknown_method"));

        ContextoRequisicaoAuditoria.clear();
    }
}