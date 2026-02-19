package tech.noar.commons.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import tech.noar.commons.constants.DateTimeConstants;
import tech.noar.commons.helper.DateTimeHelper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class JsonTimestampSerializer extends JsonSerializer<Date> implements com.google.gson.JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {
        if (null == date) {
            jsonGenerator.writeNull();
        } else {

            jsonGenerator.writeString(DateTimeHelper.format(date, DateTimeConstants.DATE_TIME_FORMAT));
        }
    }

    @Override
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        if (date == null) {
            return null;
        }

        return new JsonPrimitive(DateTimeHelper.format(date, DateTimeConstants.DATE_TIME_FORMAT));
    }
}
