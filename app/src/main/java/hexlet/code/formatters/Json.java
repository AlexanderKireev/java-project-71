package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.Differ.getSign;
//import java.io.File;
//import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
//import com.fasterxml.jackson.databind.ObjectWriter;

public class Json implements Format {
    public final String getString(Map<String, Object> dataFile1, Map<String, Object> dataFile2/*,
                            Map<String, Object> dataSign*/) throws Exception {
        Map<String, Object> dataSign = getSign(dataFile1, dataFile2);
        List<Object> allData = new ArrayList<>();
        for (Map.Entry<String, Object> data : dataSign.entrySet()) {
            Map<String, Object> m = new TreeMap<>();
            m.put("operation", data.getValue());
            m.put("name", data.getKey());
            if (data.getValue().equals("added")
                    || data.getValue().equals("unchanged")) {
                m.put("value", dataFile2.get(data.getKey()));
            }
            if (data.getValue().equals("deleted")) {
                m.put("value", dataFile1.get(data.getKey()));
            }
            if (data.getValue().equals("changed")) {
                m.put("value1", dataFile1.get(data.getKey()));
                m.put("value2", dataFile2.get(data.getKey()));
            }
            allData.add(m);
        }
//        запись результата в json-файл
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//        writer.writeValue(new File("D:/resultFile.json"), allData);
        return new ObjectMapper().writeValueAsString(allData);
    }
}
