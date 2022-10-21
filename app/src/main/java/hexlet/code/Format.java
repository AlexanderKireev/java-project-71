package hexlet.code;

import java.util.Map;

public interface Format {
    String getString(Map<String, Object> dataFile1,
                     Map<String, Object> dataFile2,
                     Map<String, Object> dataSign) throws Exception;
}
