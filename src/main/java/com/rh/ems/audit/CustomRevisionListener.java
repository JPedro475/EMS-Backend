package com.rh.ems.audit;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.envers.RevisionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        EntidadeAuditoria auditoria = (EntidadeAuditoria) revisionEntity;

        HttpServletRequest request = getCurrentRequest();

        String ipAddress = "desconhecido";
        String httpMethod = "N/A";

        if (request != null) {
            httpMethod = request.getMethod();

            String forwardedFor = request.getHeader("X-Forwarded-For");
            if (forwardedFor != null && !forwardedFor.isEmpty()) {
                ipAddress = forwardedFor.split(",")[0].trim();
            } else {
                ipAddress = request.getRemoteAddr();
            }
        }

        auditoria.setIp(ipAddress);
        auditoria.setMethod(httpMethod);

        auditoria.setUsername("system");
        auditoria.setRoles("N/A");
    }

    private HttpServletRequest getCurrentRequest() {
        try {
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            if (attrs != null) {
                return attrs.getRequest();
            }
        } catch (IllegalStateException e) {
            return null;
        }
        return null;
    }
}