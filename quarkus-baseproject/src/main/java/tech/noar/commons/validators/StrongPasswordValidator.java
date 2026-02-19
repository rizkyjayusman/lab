package tech.noar.commons.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import tech.noar.commons.annotations.ValidStrongPassword;

import java.util.regex.Pattern;

public class StrongPasswordValidator implements ConstraintValidator<ValidStrongPassword, String> {

    private short min;
    private String passwordPattern;

    @Override
    public void initialize(ValidStrongPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.min = constraintAnnotation.min();
        this.passwordPattern = String.format("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{%d,}$", this.min);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        final Pattern pattern = Pattern.compile(passwordPattern);
        return pattern.matcher(value).matches();
    }
}
