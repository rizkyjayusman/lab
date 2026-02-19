package tech.noar.commons.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.noar.commons.validators.AddressDetailValidator;
import tech.noar.commons.validators.EmailValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {

    String message() default "Invalid email address.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
