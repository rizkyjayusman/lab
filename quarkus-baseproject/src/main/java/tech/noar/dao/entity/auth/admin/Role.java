package tech.noar.dao.entity.auth.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import tech.noar.dao.entity.AuditableEntity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static tech.noar.commons.constants.DbSchemaConstants.AUTH_ADMIN;

@Entity
@Table(schema = AUTH_ADMIN, name = "roles")
@Getter
@Setter
public class Role extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            schema = AUTH_ADMIN,
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permission> permissions;

}
