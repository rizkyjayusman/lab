package tech.noar.dao.entity.auth.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseTwoFactorAuth;

import java.io.Serializable;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_ADMIN;

@Entity
@Table(schema = AUTH_ADMIN, name = "two_factor_auth")
@Getter
@Setter
public class AdminTwoFactorAuth extends BaseTwoFactorAuth implements Serializable {

    @ManyToMany(targetEntity = AdminAccount.class)
    private UUID accountId;

}
