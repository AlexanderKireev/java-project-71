package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import static hexlet.code.parsers.ParserFactory.chooseParser;

public class FileUtils {
    public static Map<String, Object> getData(String filePath) throws Exception {
        byte[] mapData = readFile(filePath);
        String fileType = getFileExtension(filePath);
        return chooseParser(fileType).parse(mapData);
    }

    public static byte[] readFile(String filePath) throws Exception {
        Path path = Path.of(filePath).toAbsolutePath().normalize();
        return Files.readAllBytes(path);
    }

    private static String getFileExtension(String filePath) {
        if (filePath.lastIndexOf(".") > 0) {
            return filePath.substring(filePath.lastIndexOf(".") + 1);
        } else {
            throw new RuntimeException("Can’t define file extension");
        }
    }
}
