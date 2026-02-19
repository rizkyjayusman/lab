package tech.noar.dao.entity.auth.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseAuth;

import java.io.Serializable;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_USER;

@Entity
@Table(schema = AUTH_USER, name = "auth_users")
@Getter
@Setter
public class AuthUser extends BaseAuth implements Serializable {

}
