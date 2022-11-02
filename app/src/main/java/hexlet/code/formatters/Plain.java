package hexlet.code.formatters;

import hexlet.code.Format;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class Plain implements Format {
    public final String getString(Map<String, Object> dataFile1, Map<String, Object> dataFile2,
                            Map<String, Object> dataSign) {
        var result = new StringBuilder();
        for (Map.Entry<String, Object> data: dataSign.entrySet()) {
            Object firstVal = dataFile1.get(data.getKey());
            Object secondVal = dataFile2.get(data.getKey());
            if (data.getValue().equals("changed")) {
                result.append("Property '").append(data.getKey())
                        .append("' was updated. From ").append(getValByType(firstVal))
                        .append(" to ").append(getValByType(secondVal)).append("\n");
            }
            if (data.getValue().equals("added")) {
                result.append("Property '").append(data.getKey())
                        .append("' was added with value: ")
                        .append(getValByType(secondVal)).append("\n");
            }
            if (data.getValue().equals("deleted")) {
                result.append("Property '").append(data.getKey()).append("' was removed\n");
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
