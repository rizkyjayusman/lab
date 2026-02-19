package com.rizkyjayusman.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TransactionIdMaxLengthValidator implements ConstraintValidator<TransactionIdMaxLen, String> {

    private int value;

    @Override
    public void initialize(TransactionIdMaxLen constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String val, ConstraintValidatorContext context) {
        if (val == null) return true;

        if (val.length() > value) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    String.format("transactionId length exceeds maximum: %d", value)
            ).addConstraintViolation();
            return false;
        }

        return true;
    }
}
