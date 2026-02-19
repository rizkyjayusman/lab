package tech.noar.commons;


import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;

public class ServiceException extends RuntimeException {

    @NotNull
    private final Response.Status httpStatus;

    private final String code;

    private final String message;

    private final String messageDetail;

    public ServiceException(Response.Status httpStatus, String code, String message, String messageDetail) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.messageDetail = messageDetail;
    }

    public ServiceException(ServiceResponseCode responseCode) {
        this(responseCode.getHttpStatus(), responseCode.getCode(), responseCode.getMessage(), null);
    }

    public ServiceException(ServiceResponseCode responseCode, String messageDetail) {
        this(responseCode.getHttpStatus(), responseCode.getCode(), responseCode.getMessage(), messageDetail);
    }

    public ServiceException(ServiceResponseCode serviceResponseCode, String message, String messageDetail) {
        this(serviceResponseCode.getHttpStatus(), serviceResponseCode.getCode(), message, messageDetail);
    }

    public @NotNull Response.Status getHttpStatus() {
        return this.httpStatus;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public String getMessageDetail() {
        return this.messageDetail;
    }
}
