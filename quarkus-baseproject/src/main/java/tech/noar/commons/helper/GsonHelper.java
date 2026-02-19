package tech.noar.commons.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tech.noar.commons.json.deserializer.JsonLocalDateDeserializer;
import tech.noar.commons.json.deserializer.JsonTimestampDeserializer;
import tech.noar.commons.json.serializer.JsonLocalDateSerializer;
import tech.noar.commons.json.serializer.JsonTimestampSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;

public class GsonHelper {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new JsonLocalDateSerializer())
            .registerTypeAdapter(LocalDate.class, new JsonLocalDateDeserializer())
            .registerTypeAdapter(Date.class, new JsonTimestampSerializer())
            .registerTypeAdapter(Date.class, new JsonTimestampDeserializer())
            .create();


    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    private GsonHelper() {
    }

}
