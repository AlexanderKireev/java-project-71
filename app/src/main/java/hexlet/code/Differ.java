package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static hexlet.code.Formatter.changeFormat;
import static hexlet.code.Parser.getData;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formateName) throws Exception {
//        if (getData(filePath1) == null || getData(filePath2) == null) {
//            throw new NullPointerException("Exception is null!");
//        }
        Map<String, Object> dataFile1 = new TreeMap<>(getData(filePath1));
        Map<String, Object> dataFile2 = new TreeMap<>(getData(filePath2));

        Map<String, Object> dataSign = Stream.concat(dataFile1.entrySet().stream(), dataFile2.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, v -> {
                    if (dataFile1.containsKey(v.getKey()) && !dataFile2.containsKey(v.getKey())) {
                        return "deleted";
                    } else if (!dataFile1.containsKey(v.getKey()) && dataFile2.containsKey(v.getKey())) {
                        return "added";
                    } else if (Objects.equals(dataFile1.get(v.getKey()), dataFile2.get(v.getKey()))) {
                        return "unchanged";
                    } else {
                        return "changed";
                    }
                }, (v1, v2) -> v1, TreeMap::new));
        return changeFormat(formateName).getString(dataFile1, dataFile2, dataSign);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
