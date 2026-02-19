package tech.noar.commons.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.noar.commons.validators.PhoneNumberValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Documented
public @interface ValidPhoneNumber {

    String message() default "Nomor ponsel hanya boleh diawali dengan 62/08 dan angka minimum 10 dan maksimum 13 digit.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
