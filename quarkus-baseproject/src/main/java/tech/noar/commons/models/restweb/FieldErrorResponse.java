package tech.noar.commons.models.restweb;

import java.util.List;

public class FieldErrorResponse {
    private List<FieldErrorMessage> fields;

    public FieldErrorResponse(List<FieldErrorMessage> fields) {
        this.fields = fields;
    }

    public List<FieldErrorMessage> getFields() {
        return fields;
    }
}
