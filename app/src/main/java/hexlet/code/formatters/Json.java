package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DifferValues;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Json implements Format {
    @Override
    public final String format(Map<String, DifferValues> differData) throws Exception {
        List<Map<String, Object>> allData = preprocess(differData);
        return new ObjectMapper().writeValueAsString(allData);
    }
    public final List<Map<String, Object>> preprocess(Map<String, DifferValues> differData) {
        List<Map<String, Object>> allData = new ArrayList<>();
        for (Map.Entry<String, DifferValues> data : differData.entrySet()) {
            String status = data.getValue().getStatus();
            Object value1 = data.getValue().getValue1();
            Object value2 = data.getValue().getValue2();
            Map<String, Object> m = new TreeMap<>();
            m.put("operation", status);
            m.put("name", data.getKey());
            switch (status) {
                case "added", "unchanged", "deleted" -> m.put("value", value1);
                case "changed" -> {
                    m.put("value1", value1);
                    m.put("value2", value2);
                }
                default -> throw new RuntimeException("Error value");
            }
            allData.add(m);
        }
        return allData;
    }
}
