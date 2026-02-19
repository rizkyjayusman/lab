package tech.noar.commons.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import tech.noar.commons.constants.DateTimeConstants;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class JsonLocalDateSerializer extends JsonSerializer<LocalDate> implements com.google.gson.JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (null == date) {
            gen.writeNull();
        } else {
            gen.writeString(date.format(DateTimeConstants.FORMATTER_DATE));
        }
    }

    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        if (date == null) {
            return null;
        }

        return new JsonPrimitive(date.format(DateTimeConstants.FORMATTER_DATE));
    }
}
