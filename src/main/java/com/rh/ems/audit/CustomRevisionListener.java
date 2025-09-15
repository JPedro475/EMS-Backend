package com.rh.ems.audit;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.envers.RevisionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        EntidadeAuditoria entidadeAuditoria = (EntidadeAuditoria) revisionEntity;

        HttpServletRequest request = getCurrentRequest();

        String ipAddress = "desconhecido";

        if (request != null) {
            String forwardedFor = request.getHeader("X-Forwarded-For");
            if (forwardedFor != null && !forwardedFor.isEmpty()) {
                ipAddress = forwardedFor.split(",")[0].trim();
            } else {
                ipAddress = request.getRemoteAddr();
            }
        }

       entidadeAuditoria.setUserIp(ipAddress);
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
