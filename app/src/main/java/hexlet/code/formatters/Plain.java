package hexlet.code.formatters;

import hexlet.code.Format;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Map;

public class Plain implements Format {
    @Override
    public final String format(Map<String, List<Object>> differData) {
        var result = new StringBuilder();
        for (Map.Entry<String, List<Object>> data : differData.entrySet()) {
            Object value = ((List<?>) data.getValue()).get(VALUE_POSITION);
            Object changedValue = data.getValue().size() > CHANGED_VALUE_POSITION
                    ? ((List<?>) data.getValue()).get(CHANGED_VALUE_POSITION) : null;
            switch (((List<?>) data.getValue()).get(STATUS_POSITION).toString()) {
                case "unchanged" -> result.append("");
                case "changed" -> result.append("Property '").append(data.getKey())
                        .append("' was updated. From ").append(getValByType(value))
                        .append(" to ").append(getValByType(changedValue)).append("\n");
                case "added" -> result.append("Property '").append(data.getKey())
                        .append("' was added with value: ").append(getValByType(value)).append("\n");
                case "deleted" -> result.append("Property '").append(data.getKey()).append("' was removed\n");
                default -> throw new RuntimeException("Error value");
            }
        }
        return StringUtils.removeEnd(result.toString(), "\n");
    }

    public static String getValByType(Object o) {
        if (o == null) {
            return "null";
        }
        if (ClassUtils.isPrimitiveOrWrapper(o.getClass())) {
            return o.toString();
        }
        if (o instanceof String) {
            return "'" + o + "'";
        }
        return "[complex value]";
    }
}
