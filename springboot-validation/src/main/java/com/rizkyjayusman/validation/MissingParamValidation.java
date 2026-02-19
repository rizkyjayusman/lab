package com.rizkyjayusman.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissingParamValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MissingParamValidation {
    String message() default "Missing required fields";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
