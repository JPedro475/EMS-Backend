package com.rh.ems.shared.config;

import com.rh.ems.shared.audit.domain.EntidadeAuditoria;
import com.rh.ems.shared.audit.domain.EntidadeAuditoriaRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class GetAuditInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(GetAuditInterceptor.class);
    private final EntidadeAuditoriaRepository entidadeAuditoriaRepository;

    public GetAuditInterceptor(EntidadeAuditoriaRepository entidadeAuditoriaRepository) {
        this.entidadeAuditoriaRepository = entidadeAuditoriaRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("GET".equalsIgnoreCase(request.getMethod())) {

            EntidadeAuditoria auditoriaDeAcesso = new EntidadeAuditoria();

            auditoriaDeAcesso.setIp(request.getRemoteAddr());
            auditoriaDeAcesso.setMethod(request.getMethod());
            auditoriaDeAcesso.setTimestamp(System.currentTimeMillis());
            auditoriaDeAcesso.setUsername("system_get_access");
            auditoriaDeAcesso.setRoles("ACCESS_AUDIT");

            entidadeAuditoriaRepository.save(auditoriaDeAcesso);
        }
        return true;
    }
}
