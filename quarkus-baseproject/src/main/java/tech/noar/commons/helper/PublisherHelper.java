package tech.noar.commons.helper;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import org.slf4j.Logger;
import tech.noar.commons.ServiceException;
import tech.noar.commons.ServiceResponseCode;

import java.util.function.Function;

public class PublisherHelper {

    private PublisherHelper(){}

    public static <T> Function<Context, Uni<? extends T>> publishError(final Logger logger, final String message,
            final ServiceResponseCode responseCode) {
        return ctx -> {

            if (!ctx.isEmpty()) {
                logger.info("Detected Context: {}", ctx.keys());
            }

            return Uni.createFrom().failure(new ServiceException(responseCode));
        };
    }


}
