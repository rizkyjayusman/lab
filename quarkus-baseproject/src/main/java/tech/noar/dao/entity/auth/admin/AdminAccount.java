package tech.noar.dao.entity.auth.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseUserDetails;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user_accounts", schema = "auth_admin")
@Getter
@Setter
public class AdminAccount extends BaseUserDetails implements Serializable {

    @OneToOne(targetEntity = AuthAdmin.class)
    private UUID authId;

}
