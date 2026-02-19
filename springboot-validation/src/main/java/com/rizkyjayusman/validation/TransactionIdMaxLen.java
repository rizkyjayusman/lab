package com.rizkyjayusman.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TransactionIdMaxLengthValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionIdMaxLen {
    String message() default "Param {0} is too long, maximum is {1} string ( {2} )";
    int value() default 0;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
