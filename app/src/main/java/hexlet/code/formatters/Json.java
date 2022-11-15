package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Json implements Format {
    @Override
    public final String format(Map<String, List<Object>> differData) throws Exception {
        List<Object> allData = new ArrayList<>();
        for (Map.Entry<String, List<Object>> data : differData.entrySet()) {
            Map<String, Object> m = new TreeMap<>();
            Object value = ((List<?>) data.getValue()).get(VALUE_POSITION);
            String status = ((List<?>) data.getValue()).get(STATUS_POSITION).toString();
            m.put("operation", status);
            m.put("name", data.getKey());
            switch (status) {
                case "added", "unchanged", "deleted" -> m.put("value", value);
                case "changed" -> {
                    m.put("value1", value);
                    m.put("value2", ((List<?>) data.getValue()).get(CHANGED_VALUE_POSITION));
                }
                default -> throw new RuntimeException("Error value");
            }
            allData.add(m);
        }
        return new ObjectMapper().writeValueAsString(allData);
    }
}
