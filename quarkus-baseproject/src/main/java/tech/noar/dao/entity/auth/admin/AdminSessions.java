package tech.noar.dao.entity.auth.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseSessions;

import java.io.Serializable;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_ADMIN;

@Entity
@Table(schema = AUTH_ADMIN, name = "auth_sessions")
@Getter
@Setter
public class AdminSessions extends BaseSessions implements Serializable {

    @ManyToMany(targetEntity = AuthAdmin.class)
    protected UUID authId;

}
