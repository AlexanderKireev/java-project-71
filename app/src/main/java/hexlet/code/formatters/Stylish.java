package hexlet.code.formatters;

import hexlet.code.Format;
import java.util.Map;

public class Stylish implements Format {
    public String getString(Map<String, Object> dataFile1, Map<String, Object> dataFile2, Map<String, Object> dataSign) {
        var result = new StringBuilder("{\n");
        for (Map.Entry<String, Object> data : dataSign.entrySet()) {
            if (data.getValue().equals("unchanged")) {
                result.append(makeString(" ", data.getKey(), dataFile1.get(data.getKey())));
            }
            if (data.getValue().equals("changed")) {
                result.append(makeString("-", data.getKey(), dataFile1.get(data.getKey())));
                result.append(makeString("+", data.getKey(), dataFile2.get(data.getKey())));
            }
            if (data.getValue().equals("added")) {
                result.append(makeString("+", data.getKey(), dataFile2.get(data.getKey())));
            }
            if (data.getValue().equals("deleted")) {
                result.append(makeString("-", data.getKey(), dataFile1.get(data.getKey())));
            }
        }
        result.append("}");
        return result.toString();
    }

    public static String makeString(String sign, String key, Object value) {
        return " ".repeat(4) + sign + " " + key + ": " + value + "\n";
    }
}
