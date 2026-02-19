package tech.noar.dao.entity.auth.admin;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;
import tech.noar.dao.entity.AuditableEntity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_ADMIN;

@Entity
@Table(schema = AUTH_ADMIN, name = "permissions")
@Getter
@Setter
public class Permission extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String code;

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            schema = AUTH_ADMIN,
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
