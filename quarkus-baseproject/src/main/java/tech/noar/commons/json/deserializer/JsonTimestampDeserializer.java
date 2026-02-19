package tech.noar.commons.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.jboss.logging.Logger;
import tech.noar.commons.constants.DateTimeConstants;
import tech.noar.commons.helper.DateTimeHelper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

public class JsonTimestampDeserializer extends JsonDeserializer<Date> implements com.google.gson.JsonDeserializer<Date> {

    private static final Logger log = Logger.getLogger(JsonTimestampDeserializer.class);

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        return parseToDate(parser.getText());
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        if (json == null) {
            return null;
        }
        return parseToDate(json.getAsJsonPrimitive().getAsString());
    }

    private Date parseToDate(String strDate) {
        return DateTimeHelper.parseToDate(strDate, DateTimeConstants.DATE_TIME_FORMAT);
    }
}
