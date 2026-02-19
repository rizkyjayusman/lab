package tech.noar.configurations;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import tech.noar.dao.entity.AuditableEntity;

import java.time.LocalDateTime;

public class AuditListener {

    @PrePersist
    public void onPrePersist(AuditableEntity auditable) {
        auditable.setCreatedAt(LocalDateTime.now());
        auditable.setCreatedBy("SYSTEM");
    }

    @PreUpdate
    public void onPreUpdate(AuditableEntity auditable) {
        auditable.setModifiedAt(LocalDateTime.now());
        auditable.setModifiedBy("SYSTEM");
    }

}
