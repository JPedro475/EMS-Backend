package com.rh.ems.audit;

import jakarta.persistence.*;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity(ControladoraAuditoria.class)
@Table(name = "entidade_auditoria", schema = "empregados_auditoria")
public class EntidadeAuditoria extends DefaultRevisionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auditoria_seq")
    @SequenceGenerator(name = "auditoria_seq", sequenceName = "entidade_auditoria_seq", allocationSize = 1)
    private Integer id;
    private String username;
    private String ip;
    private String method;
    private String roles;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
