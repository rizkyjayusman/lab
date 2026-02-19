package tech.noar.commons.enums.responseCode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response.Status;
import tech.noar.commons.ServiceResponseCode;

public enum CommonResponseCode implements ServiceResponseCode {

    SUCCESS(Status.OK, "SUCCESS", "SUCCESS"),

    JSON_PARSING_EXCEPTION(Status.INTERNAL_SERVER_ERROR, "JSON_PARSING_EXCEPTION", "Json parsing encountered a problem."),
    PARSING_EXCEPTION(Status.INTERNAL_SERVER_ERROR, "PARSING_EXCEPTION", "Parsing encountered a problem."),

    INVALID_ARGUMENT(Status.BAD_REQUEST, "INVALID_ARGUMENT", "Invalid Arguments. see errors for more detail."),
    ARGUMENTS_NULL_EMPTY(Status.BAD_REQUEST, "ARGUMENTS_NULL_EMPTY", "Arguments cannot be null or empty."),
    PARAMETER_EMPTY(Status.BAD_REQUEST, "PARAMETER_EMPTY", "Parameter cannot be null or empty."),

    UNAUTHORIZED(Status.UNAUTHORIZED, "UNAUTHORIZED", "Sorry, you don't have access to this endpoint"),
    FORBIDDEN(Status.FORBIDDEN, "FORBIDDEN", "The request requires higher privileges than provided by the access token."),
    INTERNAL_SERVER_ERROR(Status.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "Something went wrong!"),

    CONFIRM_PASSWORD_NOT_MATCH(Status.BAD_REQUEST, "CONFIRM_PASSWORD_NOT_MATH", "Password and Confirm Password Not Match"),

    DATA_NOT_FOUND(Status.NOT_FOUND, "DATA_NOT_FOUND", "Not data found with given criteria"),
    BAD_CREDENTIALS(Status.BAD_REQUEST, "BAD_CREDENTIALS", "Bad credentials"),

    PARAM_PAGE_INVALID(Status.BAD_REQUEST, "PARAM_PAGE_INVALID", "Page number must be greater than 0."),
    PARAM_SIZE_INVALID(Status.BAD_REQUEST, "PARAM_SIZE_INVALID", "Page Size must be greater than 0."),

    DUPLICATE_DATA(Status.BAD_REQUEST, "DUPLICATE_DATA", "Data with given criteria already exists."),
    DATA_ALREADY_EXIST(Status.BAD_REQUEST, "DATA_ALREADY_EXIST", "Data with given criteria already exists."),
    GENERATE_EXCEL_FAILED(Status.INTERNAL_SERVER_ERROR, "GENERATE_EXCEL_FAILED" , "Generate Excel failed." );

    @NotNull
    private final Status httpStatus;

    @NotBlank
    private final String code;

    @NotBlank
    private final String message;

    CommonResponseCode(Status httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public Status getHttpStatus() {
        return httpStatus;
    }

    @Override
    public @NotBlank String getCode() {
        return code;
    }

    @Override
    public @NotBlank String getMessage() {
        return message;
    }
}