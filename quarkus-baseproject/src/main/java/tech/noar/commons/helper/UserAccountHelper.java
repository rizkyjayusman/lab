package tech.noar.commons.helper;

import tech.noar.commons.ServiceException;
import tech.noar.commons.enums.responseCode.AuthResponseCode;

public class UserAccountHelper {

    private UserAccountHelper() {
    }

    public static void validatePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new ServiceException(AuthResponseCode.PASSWORD_NOT_MATCH);
        }
    }
}
