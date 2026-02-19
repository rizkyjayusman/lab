package tech.noar.configurations;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import org.hibernate.JDBCException;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.noar.commons.ServiceException;
import tech.noar.commons.enums.responseCode.CommonResponseCode;
import tech.noar.commons.helper.ResponseHelper;
import tech.noar.commons.helper.ResponseMessageHelper;

import java.sql.SQLException;
import java.util.List;

import static tech.noar.commons.helper.ResponseHelper.*;

@RegisterForReflection
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ServerExceptionMapper(ServiceException.class)
    public Uni<Response> handleServiceException(ServiceException ex) {
        logger.error("ServiceException occurred: {}", ex.getMessage(), ex);
        final Uni<Response> response = Uni.createFrom()
                .item(createResponse(ex.getHttpStatus(), ex.getCode(), ex.getMessage()));


        return Uni.createFrom()
                .context(ctx -> {
                    final Object prop4 = ctx.getOrElse("PROP_4", () -> null);
                    logger.info("Prop4: {}", prop4);
                    return response;
                });
    }

    @ServerExceptionMapper(SQLException.class)
    public Uni<Response> sqlServiceException(SQLException ex) {
        logger.error("SQLException occurred: {}", ex.getErrorCode(), ex);
        final Uni<Response> response = Uni.createFrom()
                .item(createResponse(CommonResponseCode.INTERNAL_SERVER_ERROR));

        return Uni.createFrom()
                .context(ctx -> response);
    }

    @ServerExceptionMapper(JDBCException.class)
    public Uni<Response> sqlServiceException(JDBCException ex) {
        logger.error("JDBCException occurred: {}", ex.getErrorCode(), ex);

        final Uni<Response> response = Uni.createFrom()
                .item(createResponse(CommonResponseCode.INTERNAL_SERVER_ERROR));

        return response
                .attachContext()
                .map(responseItemWithContext -> {
                    final Context context = responseItemWithContext.context();
                    logger.info("context: {}", context);
                    return responseItemWithContext.get();
                });
    }

    @ServerExceptionMapper(ConstraintViolationException.class)
    public Uni<Response> sqlServiceException(ConstraintViolationException ex) {
        logger.error("ConstraintViolationException occurred: {}", ex.getMessage(), ex);
        Uni<Response> response = Uni.createFrom()
                .item(createResponse(CommonResponseCode.INVALID_ARGUMENT, null,
                        List.of(ResponseMessageHelper.buildFieldError(ex.getConstraintViolations()))));

        return Uni.createFrom()
                .context(ctx -> response);
    }

}
