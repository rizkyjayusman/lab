package com.rizkyjayusman.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = TransactionIdLengthMinValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionIdMinLen {
    String message() default "Param {0} is too short, minimum is {1} string ( {2} )";
    int value() default 0;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
