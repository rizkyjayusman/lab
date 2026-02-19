package tech.noar.dao.entity.auth.user;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseTwoFactorAuth;

import java.io.Serializable;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_USER;

@Entity
@Table(schema = AUTH_USER, name = "two_factor_auth")
@Getter
@Setter
public class UserTwoFactorAuth extends BaseTwoFactorAuth implements Serializable {

    @ManyToMany(targetEntity = UserAccount.class)
    private UUID accountId;

}
