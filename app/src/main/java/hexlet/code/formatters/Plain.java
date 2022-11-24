package hexlet.code.formatters;

import hexlet.code.DifferValues;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;

public class Plain implements Format {
    @Override
    public final String format(Map<String, DifferValues> differData) {
        var result = new StringBuilder();
        String upd = "Property '%s' was updated. From %s to %s\n";
        String add = "Property '%s' was added with value: %s\n";
        String del = "Property '%s' was removed\n";
        for (Map.Entry<String, DifferValues> data : differData.entrySet()) {
            String key = data.getKey();
            String value1 = getValByType(data.getValue().getValue1());
            String value2 = getValByType(data.getValue().getValue2());
            switch (data.getValue().getStatus()) {
                case "unchanged" -> result.append("");
                case "changed" -> result.append(String.format(upd, key, value1, value2));
                case "added" -> result.append(String.format(add, key, value1));
                case "deleted" -> result.append(String.format(del, key));
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
