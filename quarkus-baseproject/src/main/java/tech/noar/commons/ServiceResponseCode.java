package tech.noar.commons;

import jakarta.ws.rs.core.Response.Status;

public interface ServiceResponseCode {

    abstract Status getHttpStatus();

    abstract String getCode();

    abstract String getMessage();
}
