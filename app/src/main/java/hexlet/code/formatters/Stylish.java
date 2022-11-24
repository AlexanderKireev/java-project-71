package hexlet.code.formatters;

import hexlet.code.DifferValues;
import java.util.Map;

public class Stylish implements Format {
    @Override
    public final String format(Map<String, DifferValues> differData) {
        var result = new StringBuilder("{\n");
        String str = "  %s %s: %s";
        String none = " ";
        String add = "+";
        String del = "-";
        for (Map.Entry<String, DifferValues> data : differData.entrySet()) {
            String key = data.getKey();
            Object value1 = data.getValue().getValue1();
            Object value2 = data.getValue().getValue2();
            switch (data.getValue().getStatus()) {
                case "unchanged" -> result.append(String.format(str, none, key, value1));
                case "changed" -> result.append(String.format(str, del, key, value1))
                        .append("\n").append(String.format(str, add, key, value2));
                case "added" -> result.append(String.format(str, add, key, value2));
                case "deleted" -> result.append(String.format(str, del, key, value1));
                default -> throw new RuntimeException("Error value");
            }
            result.append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
