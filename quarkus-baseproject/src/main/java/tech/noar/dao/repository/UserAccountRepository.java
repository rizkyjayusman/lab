package tech.noar.dao.repository;

import jakarta.enterprise.context.ApplicationScoped;
import tech.noar.commons.PaginationRepository;
import tech.noar.dao.entity.auth.user.AuthUser;
import tech.noar.dao.entity.auth.user.UserAccount;

import java.util.UUID;

@ApplicationScoped
public class UserAccountRepository implements PaginationRepository<UserAccount, UUID> {
}
