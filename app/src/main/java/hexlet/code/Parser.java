package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> getData(String content) throws Exception {
        byte[] mapData = Files.readAllBytes(Paths.get(content));
//        return new ObjectMapper().readValue(mapData, new TypeReference<>() {});
//        String json = new ObjectMapper().writeValueAsString(payload);
//        System.out.println(json);
        return new YAMLMapper().readValue(mapData, new TypeReference<>() {
        });
    }
}
