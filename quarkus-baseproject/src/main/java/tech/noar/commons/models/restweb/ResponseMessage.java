package tech.noar.commons.models.restweb;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ResponseMessage<T> implements Serializable {

    private String code;

    private String message;

    private T data;

    private LocalDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Object> errors;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Metadata metadata;

    public ResponseMessage(String code, String message, T data) {
        this(code, message, data, List.of(), null);
    }

    public ResponseMessage(String code, String message, T data, List<Object> errors,
            Metadata metadata) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
        this.errors = errors;
        this.metadata = metadata;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public record Metadata(
            @JsonInclude(JsonInclude.Include.NON_NULL)
            PaginationResponse pagination,

            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            Map<String, Object> request
    ) implements Serializable {
    }

}
