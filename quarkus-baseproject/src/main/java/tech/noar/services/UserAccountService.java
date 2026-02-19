package tech.noar.services;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.noar.dao.entity.auth.user.UserAccount;
import tech.noar.dao.repository.UserAccountRepository;

public interface UserAccountService {

    Uni<UserAccount> create(UserAccount userAccount);

}
