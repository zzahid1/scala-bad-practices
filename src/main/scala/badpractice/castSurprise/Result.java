package badpractice.castSurprise;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private Map<String, Object> content = new LinkedHashMap<>();

    public void setProperty(String name, Object value) {
        content.put(name, value);
    }

    public <T> T getProperty(String name) {
        T result = null;
        if (content.containsKey(name)) {
            result = (T) content.get(name);
        }
        return result;
    }
}
