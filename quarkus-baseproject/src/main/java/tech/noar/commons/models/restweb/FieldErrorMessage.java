package tech.noar.commons.models.restweb;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public record FieldErrorMessage(
        String fieldName,
        Object rejectedValue,
        String message,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        String messageCode
) implements Serializable {
}
