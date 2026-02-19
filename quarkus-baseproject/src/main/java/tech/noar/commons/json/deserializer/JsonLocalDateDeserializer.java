package tech.noar.commons.json.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.netty.util.internal.StringUtil;
import org.jboss.logging.Logger;
import tech.noar.commons.constants.DateTimeConstants;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class JsonLocalDateDeserializer extends JsonDeserializer<LocalDate> implements com.google.gson.JsonDeserializer<LocalDate> {

    private static final Logger log = Logger.getLogger(JsonTimestampDeserializer.class);

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JacksonException {
        if (StringUtil.isNullOrEmpty(parser.getText())) {
            return null;
        }
        return parseLocalToDate(parser.getText());
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        if (json == null) {
            return null;
        }
        return parseLocalToDate(json.getAsJsonPrimitive().getAsString());
    }

    private LocalDate parseLocalToDate(String strDate) {
        try {
            return LocalDate.parse(strDate, DateTimeConstants.FORMATTER_DATE);
        } catch (Exception e) {
            log.errorf("Failed parse String to Date (%s with format %s)", strDate, DateTimeConstants.DATE_FORMAT);
            return null;
        }
    }
}
