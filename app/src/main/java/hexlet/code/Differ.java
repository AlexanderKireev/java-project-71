package hexlet.code;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static hexlet.code.Formatter.chooseFormatter;
import static hexlet.code.Parser.getData;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formateName) throws Exception {
        Map<String, List<Object>> differResultData = addStatus(getData(filePath1), getData(filePath2));
        return chooseFormatter(formateName).format(differResultData);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static Map<String, List<Object>> addStatus(Map<String, Object> dataFile1, Map<String, Object> dataFile2) {
        //result: {chars1=[unchanged, [a, b, c]], chars2=[changed, [d, e, f], false]...}
        return Stream.concat(dataFile1.entrySet().stream(), dataFile2.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, v -> {
                    if (dataFile1.containsKey(v.getKey()) && !dataFile2.containsKey(v.getKey())) {
                        return Arrays.asList("deleted", dataFile1.get(v.getKey()));
                    } else if (!dataFile1.containsKey(v.getKey()) && dataFile2.containsKey(v.getKey())) {
                        return Arrays.asList("added", dataFile2.get(v.getKey()));
                    } else if (Objects.equals(dataFile1.get(v.getKey()), dataFile2.get(v.getKey()))) {
                        return Arrays.asList("unchanged", dataFile1.get(v.getKey()));
                    } else {
                        return Arrays.asList("changed", dataFile1.get(v.getKey()), dataFile2.get(v.getKey()));
                    }
                }, (v1, v2) -> v1, TreeMap::new));
    }
}
