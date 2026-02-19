package tech.noar.services.impl;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.noar.dao.entity.auth.user.UserAccount;
import tech.noar.dao.repository.UserAccountRepository;
import tech.noar.services.UserAccountService;

@ApplicationScoped
public class UserAccountServiceImpl implements UserAccountService {

    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);

    @Inject
    UserAccountRepository userAccountRepository;

    @Transactional
    @WithTransaction
    public Uni<UserAccount> create(UserAccount userAccount) {
        return userAccountRepository.persistAndFlush(userAccount)
                .invoke(() -> logger.info("Saved UserAccount: {}", userAccount.getEmail()));
    }

}
