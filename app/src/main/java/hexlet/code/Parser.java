package hexlet.code;

import java.io.IOException;
import java.util.Map;

public interface Parser {
    Map<String, Object> parse(byte[] mapData) throws IOException;
}
