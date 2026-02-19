package tech.noar.services;

import io.smallrye.mutiny.Uni;
import tech.noar.commons.models.restweb.request.auth.RegistrationRequest;
import tech.noar.dao.entity.auth.user.AuthUser;


public interface AuthService {

    Uni<AuthUser> register(RegistrationRequest request);


}
