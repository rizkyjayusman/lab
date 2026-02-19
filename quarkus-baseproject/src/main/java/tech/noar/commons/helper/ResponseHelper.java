package tech.noar.commons.helper;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
import tech.noar.commons.ServiceResponseCode;
import tech.noar.commons.models.restweb.ResponseMessage;

import java.util.List;

import static tech.noar.commons.helper.ResponseMessageHelper.construct;

public class ResponseHelper {

    private ResponseHelper() {
    }

    public static <T> Response createResponse(Status httpStatus, HttpHeaders headers,
            ResponseMessage<T> responseMessage) {

        ResponseBuilder resp = Response.status(httpStatus);

        if (headers != null) {
            headers.getRequestHeaders()
                    .forEach(resp::header);
        }

        return resp.entity(responseMessage)
                .build();
    }

    public static <T> Response createResponse(HttpHeaders headers,
            ServiceResponseCode responseCode, T data, List<Object> errors) {
        return createResponse(responseCode.getHttpStatus(), headers, construct(responseCode, data, errors));
    }

    public static Response createResponse(Status httpStatus, HttpHeaders headers, String message) {
        return createResponse(httpStatus, headers, construct(httpStatus.name(), message, null, null));
    }

    public static Response createResponse(Status httpStatus, String code, String message) {
        return createResponse(httpStatus, null, construct(code, message, null, null));
    }

    public static <T> Response createResponse(ServiceResponseCode code, T data) {
        return createResponse(code.getHttpStatus(), null, construct(code, data, null));
    }

    public static <T> Response createResponse(ServiceResponseCode code, T data, List<Object> errors) {
        return createResponse(code.getHttpStatus(), null, construct(code, data, errors));
    }

    public static <T> Response createResponse(ServiceResponseCode code) {
        return createResponse(code.getHttpStatus(), null, construct(code, null, null));
    }

    public static <T> Response createResponse(Status httpStatus, HttpHeaders headers,
            String message, List<Object> errors) {
        return createResponse(httpStatus, headers, construct(httpStatus.name(), message, null, errors));
    }

}
