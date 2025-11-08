package com.rizkyjayusman;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         Member member1 = new Member();
 *         member1.field = "field-1";
 *         member1.persist();
 *
 *         List<Member> members = Member.listAll();
 *     }
 * }
 */
@Entity
public class Member extends PanacheEntity {
    public String name;
}
