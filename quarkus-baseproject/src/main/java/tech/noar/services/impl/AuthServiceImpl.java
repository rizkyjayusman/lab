package tech.noar.services.impl;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.noar.commons.helper.UserAccountHelper;
import tech.noar.commons.models.restweb.request.auth.RegistrationRequest;
import tech.noar.dao.entity.auth.user.AuthUser;
import tech.noar.dao.entity.auth.user.UserAccount;
import tech.noar.dao.repository.AuthUserRepository;
import tech.noar.dao.repository.UserAccountRepository;
import tech.noar.services.AuthService;
import tech.noar.services.UserAccountService;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    private static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Inject
    AuthUserRepository authUserRepository;

    @Inject
    UserAccountService userAccountService;
    @Inject
    UserAccountRepository userAccountRepository;

    @Transactional
    public Uni<AuthUser> register(RegistrationRequest request) {
        UserAccountHelper.validatePassword(request.password, request.confirmPassword);

        AuthUser newUser = new AuthUser();
        newUser.setEmail(request.email);
        newUser.setPhoneNumber(request.phoneNumber);
        newUser.setPassword(BcryptUtil.bcryptHash(request.password));

//        return Uni.createFrom().item(newUser);

//        return Uni.createFrom()
//                .context(context -> {
//                    System.out.println(context);
//                    return authUserRepository.persist(newUser)
//                            .attachContext()
//                            .flatMap(authUserItemWithContext -> {
//                                logContext(authUserItemWithContext.context());
//                                return userAccountService.create(constructUserAccount(authUserItemWithContext.get()))
//                                        .map(userAccount -> authUserItemWithContext.get());
//                            });
//                });


        return authUserRepository.persist(newUser)
                .attachContext()
                .flatMap(authUserItemWithContext -> {
                    logContext(authUserItemWithContext.context());
                    return userAccountService.create(constructUserAccount(authUserItemWithContext.get()))
                            .map(userAccount -> authUserItemWithContext.get());
                });


/*

        return authUserRepository.persist(newUser)
                .runSubscriptionOn(Infrastructure.getDefaultExecutor())
                .attachContext()
                .flatMap(authUserItemWithContext -> {
                    final Context context = authUserItemWithContext.context();
                    logContext(context);
                    final AuthUser authUser = authUserItemWithContext.get();
                    return userAccountService.create(constructUserAccount(authUser))
                            .map(userAccount -> authUser);
                });
*/


    }

    private void logContext(Context ctx) {
        String prop1 = ctx.getOrElse("PROP_1", () -> "prop 1 - null");
        String prop2 = ctx.getOrElse("PROP_2", () -> "prop 2 - null");

        String prop1rc = ctx.getOrElse("PROP_1_RC", () -> "prop 1 rc - null");
        String prop2rc = ctx.getOrElse("PROP_2_RC", () -> "prop 2 rc - null");
        logger.info("PROP_1: {} | PROP_2: {}", prop1, prop2);
        logger.info("PROP_1_RC: {} | PROP_1_RC: {}", prop1rc, prop2rc);
    }

    private UserAccount constructUserAccount(AuthUser authUser) {
        UserAccount newAccount = new UserAccount();
        newAccount.setAuthId(authUser.getId());
        newAccount.setEmail(authUser.getEmail());
        newAccount.setPhoneNumber(authUser.getPhoneNumber());

        return newAccount;
    }
}
