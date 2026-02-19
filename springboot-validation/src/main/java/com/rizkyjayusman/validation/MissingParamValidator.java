package com.rizkyjayusman.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MissingParamValidator implements ConstraintValidator<MissingParamValidation, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj == null) return true;

        List<String> missingFields = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                if (!field.isAnnotationPresent(RequiredField.class)) continue;

                field.setAccessible(true);
                Object value = field.get(obj);

                if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
                    missingFields.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing fields", e);
        }

        if (!missingFields.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Missing required fields: " + String.join(", ", missingFields)
            ).addConstraintViolation();
            return false;
        }

        return true;
    }
}
