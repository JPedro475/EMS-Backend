/**package com.rh.ems.audit;

import jakarta.persistence.*;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@RevisionEntity(CustomRevisionListener.class)
@Table(name = "revinfo", schema = "empregados_auditoria")
public class CustomRevisionEntity {

    @Id
    @GeneratedValue
    @RevisionNumber
    private long id;

    @RevisionTimestamp
    private long timestamp;

    @Column(name = "user_ip")
    private String userIp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}**/
