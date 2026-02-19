package tech.noar.dao.entity.auth.user;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseUserDetails;

import java.io.Serializable;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_USER;

@Entity
@Table(schema = AUTH_USER, name = "user_accounts")
@Getter
@Setter
public class UserAccount extends BaseUserDetails implements Serializable {

    @OneToOne(targetEntity = AuthUser.class)
    private UUID authId;

    private String phoneNumber;

}
