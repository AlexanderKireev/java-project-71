package hexlet.code;

import java.util.List;
import java.util.Map;

public interface Format {
    int STATUS_POSITION = 0;
    int VALUE_POSITION = 1;
    int CHANGED_VALUE_POSITION = 2;
    String format(Map<String, List<Object>> differData) throws Exception;
}
