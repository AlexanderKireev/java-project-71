package hexlet.code.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.Map;

public class YmlParser implements Parser {
    public final Map<String, Object> parse(byte[] mapData) throws IOException {
        YAMLMapper mapper = new YAMLMapper();
        return mapper.readValue(mapData, new TypeReference<>() {
        });
    }
}
