package tech.noar.commons.helper;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import org.hibernate.internal.util.collections.CollectionHelper;
import tech.noar.commons.ServiceResponseCode;
import tech.noar.commons.models.PaginationResult;
import tech.noar.commons.models.restweb.FieldErrorMessage;
import tech.noar.commons.models.restweb.FieldErrorResponse;
import tech.noar.commons.models.restweb.PaginationResponse;
import tech.noar.commons.models.restweb.ResponseMessage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResponseMessageHelper {

    private ResponseMessageHelper() {
    }

    public static <T> ResponseMessage<?> construct(String code, String message, T data, List<Object> errors) {
        if (data instanceof PaginationResult<?> paginationData) {
            List<?> newData = paginationData.content;
            final PaginationResponse pagination = PaginationResponse.build(paginationData);
            ResponseMessage.Metadata metadata = new ResponseMessage.Metadata(pagination, null);
            return new ResponseMessage<>(code, message, newData, errors, metadata);
        }

        return new ResponseMessage<>(code, message, data, errors, null);
    }

    public static <T> ResponseMessage<?> construct(ServiceResponseCode responseCode, T data, List<Object> errors) {
        return construct(responseCode.getCode(), responseCode.getMessage(), data, errors);
    }

    public static <T> ResponseMessage<?> construct(ServiceResponseCode responseCode, T data) {
        return construct(responseCode, data, null);
    }

    private static <T> ResponseMessage<?> construct(ServiceResponseCode responseCode) {
        return construct(responseCode, null);
    }

    public static FieldErrorResponse buildFieldError(Set<ConstraintViolation<?>> fieldErrors) {
        if (CollectionHelper.isEmpty(fieldErrors)) {
            return new FieldErrorResponse(Collections.emptyList());
        }

        final List<FieldErrorMessage> list = fieldErrors.stream()
                .map(fieldError -> new FieldErrorMessage(
                        getFieldName(fieldError.getPropertyPath()),
                        fieldError.getInvalidValue(),
                        fieldError.getMessage(),
                        null
                ))
                .toList();

        return new FieldErrorResponse(list);
    }

    private static String getFieldName(Path propertyPath) {
        if (propertyPath == null) {
            return null;
        }

        final Iterator<Path.Node> iterator = propertyPath.iterator();
        Path.Node node = iterator.next();
        while (iterator.hasNext()) {
            node = iterator.next();
        }
        return node.getName();
    }

    public static String buildFieldErrorMessage(List<ConstraintViolation<?>> fieldErrors) {
        if (CollectionHelper.isEmpty(fieldErrors)) {
            return "";
        }

        final List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream()
                .map(fieldError -> new FieldErrorMessage(
                        fieldError.getPropertyPath().toString(),
                        fieldError.getInvalidValue(),
                        fieldError.getMessage(),
                        fieldError.getMessageTemplate()
                ))
                .collect(Collectors.toList());

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"fieldError\"	: ");

        if (CollectionHelper.isNotEmpty(fieldErrorMessages)) {
            json.append(GsonHelper.toJson(fieldErrorMessages));
        } else {
            json.append("[]");
        }

        json.append("}");

        return json.toString();
    }

}
