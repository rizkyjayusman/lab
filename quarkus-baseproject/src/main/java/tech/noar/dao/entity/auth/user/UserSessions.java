package tech.noar.dao.entity.auth.user;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseSessions;

import java.io.Serializable;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_USER;

@Entity
@Table(schema = AUTH_USER, name = "auth_session")
@Getter
@Setter
public class UserSessions extends BaseSessions implements Serializable {

    @ManyToMany(targetEntity = AuthUser.class)
    private UUID authId;

}
