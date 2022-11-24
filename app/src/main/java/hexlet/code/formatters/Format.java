package hexlet.code.formatters;

import hexlet.code.DifferValues;
import java.util.Map;

public interface Format {
    String format(Map<String, DifferValues> differData) throws Exception;
}
