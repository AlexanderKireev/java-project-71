package hexlet.code.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class JsonParser implements Parser {
    public final Map<String, Object> parse(byte[] mapData) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mapData, new TypeReference<>() {
        });
    }
}
