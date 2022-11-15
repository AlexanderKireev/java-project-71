package hexlet.code.formatters;

import hexlet.code.Format;
import java.util.List;
import java.util.Map;

public class Stylish implements Format {
    @Override
    public final String format(Map<String, List<Object>> differData) {
        var result = new StringBuilder("{\n");
        for (Map.Entry<String, List<Object>> data : differData.entrySet()) {
            Object value = ((List<?>) data.getValue()).get(VALUE_POSITION);
            switch (((List<?>) data.getValue()).get(STATUS_POSITION).toString()) {
                case "unchanged" -> result.append("    ").append(data.getKey()).append(": ").append(value);
                case "changed" -> result.append("  - ").append(data.getKey()).append(": ")
                        .append(value).append("\n").append("  + ").append(data.getKey()).append(": ")
                        .append(((List<?>) data.getValue()).get(CHANGED_VALUE_POSITION));
                case "added" -> result.append("  + ").append(data.getKey()).append(": ").append(value);
                case "deleted" -> result.append("  - ").append(data.getKey()).append(": ").append(value);
                default -> throw new RuntimeException("Error value");
            }
            result.append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
