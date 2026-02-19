package tech.noar.commons.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import tech.noar.commons.annotations.ValidPhoneNumber;
import tech.noar.commons.helper.StringHelper;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        return StringHelper.isValidMobilePhoneNumber(value);
    }
}
