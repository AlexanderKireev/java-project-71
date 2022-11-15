package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class Parser {
    public static Map<String, Object> getData(String filePath) throws Exception {
        byte[] mapData = readFile(filePath);
        String fileType = getFileExtension(new File(filePath));

        ObjectMapper mapper;
        if (Objects.equals(fileType, "json")) {
            mapper = new ObjectMapper();
        } else if (Objects.equals(fileType, "yml")) {
            mapper = new YAMLMapper();
        } else {
            throw new RuntimeException("Wrong file type");
        }
        return mapper.readValue(mapData, new TypeReference<>() {
        });
    }

    public static byte[] readFile(String filePath) throws Exception {
        return Files.readAllBytes(Paths.get(filePath));
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
