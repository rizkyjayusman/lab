package tech.noar.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import tech.noar.commons.enums.Gender;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseUserDetails extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(columnDefinition = "uuid")
    private UUID id;

    protected UUID authId;

    private String firstName;

    private String lastName;

    private transient String fullName;

    private String email;

    private String avatarUrl;

    private Gender gender;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

}
