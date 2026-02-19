package tech.noar.commons.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.noar.commons.validators.AddressDetailValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddressDetailValidator.class)
@Documented
public @interface ValidAddressDetail {
    String message() default "Alamat lengkap harus diisi minimum 5 dan maksimal 200 karakter.";

    short min() default 5;

    short max() default 250;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
