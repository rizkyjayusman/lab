package tech.noar.dao.repository;

import jakarta.enterprise.context.ApplicationScoped;
import tech.noar.commons.PaginationRepository;
import tech.noar.dao.entity.auth.user.AuthUser;

import java.util.UUID;

@ApplicationScoped
public class AuthUserRepository implements PaginationRepository<AuthUser, UUID> {

}
