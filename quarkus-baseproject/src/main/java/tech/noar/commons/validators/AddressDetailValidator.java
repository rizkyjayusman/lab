package tech.noar.commons.validators;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import tech.noar.commons.annotations.ValidAddressDetail;
import tech.noar.commons.helper.StringHelper;

public class AddressDetailValidator implements ConstraintValidator<ValidAddressDetail, String> {

    private short min;
    private short max;

    @Override
    public void initialize(ValidAddressDetail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return false;
        }
        return StringHelper.isValidLength(value, min, max);
    }
}
