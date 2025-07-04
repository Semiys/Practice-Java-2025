package json;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonSerializer {

    public static String serialize(Object obj) throws IllegalAccessException {
        Map<String, Object> jsonMap = new HashMap<>();
        Class<?> clazz = obj.getClass();


        for (Field field : clazz.getDeclaredFields()) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);


                JsonField jsonField = field.getAnnotation(JsonField.class);
                String jsonName = jsonField.name();


                Object value = field.get(obj);


                jsonMap.put(jsonName, value);
            }
        }


        String jsonBody = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(", "));

        return "{" + jsonBody + "}";
    }
}
