package tech.noar.commons.models.restweb.request.auth;

import tech.noar.commons.annotations.ValidEmail;
import tech.noar.commons.annotations.ValidPhoneNumber;
import tech.noar.commons.annotations.ValidStrongPassword;

import java.io.Serializable;

public class RegistrationRequest implements Serializable {

    @ValidEmail
    public String email;

    @ValidPhoneNumber
    public String phoneNumber;

    @ValidStrongPassword(min = 6)
    public String password;

    @ValidStrongPassword(min = 6)
    public String confirmPassword;

}
