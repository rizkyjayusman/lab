package tech.noar.dao.entity.auth.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import tech.noar.dao.entity.AuditableEntity;

import java.io.Serializable;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_USER;

@Entity
@Table(schema = AUTH_USER, name = "user_social_accounts")
@Getter
@Setter
public class UserSocialAccounts extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(columnDefinition = "uuid")
    private UUID id;

    private UUID authId;

    private String provider;

    private String providerId;

}
