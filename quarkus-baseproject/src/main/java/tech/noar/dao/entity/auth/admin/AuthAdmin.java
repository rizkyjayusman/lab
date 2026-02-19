package tech.noar.dao.entity.auth.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.noar.dao.entity.BaseAuth;

import java.io.Serializable;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_ADMIN;

@Entity
@Table(schema = AUTH_ADMIN, name = "auth_users")
@Getter
@Setter
public class AuthAdmin extends BaseAuth implements Serializable {


}
