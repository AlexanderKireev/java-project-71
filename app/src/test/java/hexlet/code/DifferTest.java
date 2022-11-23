package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private final String pathToJson1 = "src/test/resources/file1.json";
    private final String pathToJson2 = "src/test/resources/file2.json";
    private final String pathToYml1 = "src/test/resources/file1.yml";
    private final String pathToYml2 = "src/test/resources/file2.yml";
    private final String pathToExpectedStylish = "src/test/resources/stylish";
    private final String pathToExpectedPlain = "src/test/resources/plain";
    private final String pathToExpectedJson = "src/test/resources/json";

    @Test
    public void testWithoutFormatter() throws Exception {
        Path fullPath = Paths.get(pathToExpectedStylish).toAbsolutePath().normalize();
        String expectedStylish = "";
        try {
            expectedStylish = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, Differ.generate(pathToJson1, pathToJson2));
    }

    @Test
    public void testJsonToStylish() throws Exception {
        Path fullPath = Paths.get(pathToExpectedStylish).toAbsolutePath().normalize();
        String expectedStylish = "";
        try {
            expectedStylish = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, Differ.generate(pathToJson1, pathToJson2, "stylish"));
    }

    @Test
    public void testYmlToStylish() throws Exception {
        Path fullPath = Paths.get(pathToExpectedStylish).toAbsolutePath().normalize();
        String expectedStylish = "";
        try {
            expectedStylish = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedStylish, Differ.generate(pathToYml1, pathToYml2, "stylish"));
    }

    @Test
    public void testJsonToPlain() throws Exception {
        Path fullPath = Paths.get(pathToExpectedPlain).toAbsolutePath().normalize();
        String expectedPlain = "";
        try {
            expectedPlain = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedPlain, Differ.generate(pathToJson1, pathToJson2, "plain"));
    }

    @Test
    public void testYmlToPlain() throws Exception {
        Path fullPath = Paths.get(pathToExpectedPlain).toAbsolutePath().normalize();
        String expectedPlain = "";
        try {
            expectedPlain = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedPlain, Differ.generate(pathToYml1, pathToYml2, "plain"));
    }

    @Test
    public void testJsonToJson() throws Exception {
        Path fullPath = Paths.get(pathToExpectedJson).toAbsolutePath().normalize();
        String expectedJson = "";
        try {
            expectedJson = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedJson, Differ.generate(pathToJson1, pathToJson2, "json"));
    }

    @Test
    public void testYmlToJson() throws Exception {
        Path fullPath = Paths.get(pathToExpectedJson).toAbsolutePath().normalize();
        String expectedJson = "";
        try {
            expectedJson = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expectedJson, Differ.generate(pathToYml1, pathToYml2, "json"));
    }
}
