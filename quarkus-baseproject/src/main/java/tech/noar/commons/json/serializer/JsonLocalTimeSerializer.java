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
import java.time.LocalTime;

public class JsonLocalTimeSerializer extends JsonSerializer<LocalTime> implements com.google.gson.JsonSerializer<LocalTime> {

    @Override
    public void serialize(LocalTime date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (null == date) {
            gen.writeNull();
        } else {
            gen.writeString(date.format(DateTimeConstants.FORMATTER_TIME));
        }
    }

    @Override
    public JsonElement serialize(LocalTime date, Type typeOfSrc, JsonSerializationContext context) {
        if (date == null) {
            return null;
        }

        return new JsonPrimitive(date.format(DateTimeConstants.FORMATTER_TIME));
    }
}
