package hexlet.code.formatters;

import hexlet.code.Format;
import java.util.Map;
import static hexlet.code.Differ.getSign;

public class Stylish implements Format {
    public final String getString(Map<String, Object> dataFile1, Map<String, Object> dataFile2) {
        Map<String, String> dataSign = getSign(dataFile1, dataFile2);
        var result = new StringBuilder("{\n");
        for (Map.Entry<String, String> data : dataSign.entrySet()) {
            switch (data.getValue()) {
                case "unchanged":
                    result.append(makeString(" ", data.getKey(), dataFile1.get(data.getKey())));
                    break;
                case "changed":
                    result.append(makeString("-", data.getKey(), dataFile1.get(data.getKey())))
                            .append(makeString("+", data.getKey(), dataFile2.get(data.getKey())));
                    break;
                case "added":
                    result.append(makeString("+", data.getKey(), dataFile2.get(data.getKey())));
                    break;
                case "deleted":
                    result.append(makeString("-", data.getKey(), dataFile1.get(data.getKey())));
                    break;
                default:
                    System.out.print("Error value");
            }
        }
        result.append("}");
        return result.toString();
    }

    public static String makeString(String sign, String key, Object value) {
        return "  "/*.repeat(2)*/ + sign + " " + key + ": " + value + "\n";
    }
}
