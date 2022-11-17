package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class Parser {
    public static Map<String, Object> getData(String filePath) throws Exception {
        byte[] mapData = readFile(filePath);
        String fileType = getFileExtension(filePath);
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
        Path path = Path.of(filePath).normalize().toAbsolutePath();
        return Files.readAllBytes(path);
    }

    private static String getFileExtension(String filePath) {
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (filePath.lastIndexOf(".") != -1 && filePath.lastIndexOf(".") != 0) {
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return filePath.substring(filePath.lastIndexOf(".") + 1);
        // в противном случае - расширение не найдено
        } else {
            return "";
        }
    }
}
