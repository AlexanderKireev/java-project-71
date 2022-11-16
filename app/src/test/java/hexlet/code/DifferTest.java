package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private final String pathToJson1 = "src/test/resources/file1.json";
    private final String pathToJson2 = "src/test/resources/file2.json";
    private final String pathToYml1 = "src/test/resources/file1.yml";
    private final String pathToYml2 = "src/test/resources/file2.yml";

    private final String expectedStylish = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

    private final String expectedPlain = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

    private final String expectedJson = "[{\"name\":\"chars1\",\"operation\":\"unchanged\",\"value\":[\""
            + "a\",\"b\",\"c\"]},{\"name\":\"chars2\",\"operation\":\"changed\",\"value1\":[\"d\",\"e\",\"f\""
            + "],\"value2\":false},{\"name\":\"checked\",\"operation\":\"changed\",\"value1\":false,\"value2\":"
            + "true},{\"name\":\"default\",\"operation\":\"changed\",\"value1\":null,\"value2\":[\"value1\",\""
            + "value2\"]},{\"name\":\"id\",\"operation\":\"changed\",\"value1\":45,\"value2\":null},{\"name\":\""
            + "key1\",\"operation\":\"deleted\",\"value\":\"value1\"},{\"name\":\"key2\",\"operation\":\""
            + "added\",\"value\":\"value2\"},{\"name\":\"numbers1\",\"operation\":\"unchanged\",\"value\":"
            + "[1,2,3,4]},{\"name\":\"numbers2\",\"operation\":\"changed\",\"value1\":[2,3,4,5],\"value2\":"
            + "[22,33,44,55]},{\"name\":\"numbers3\",\"operation\":\"deleted\",\"value\":[3,4,5]},{\"name\":\""
            + "numbers4\",\"operation\":\"added\",\"value\":[4,5,6]},{\"name\":\"obj1\",\"operation\":\"added\",\""
            + "value\":{\"nestedKey\":\"value\",\"isNested\":true}},{\"name\":\"setting1\",\"operation\":\""
            + "changed\",\"value1\":\"Some value\",\"value2\":\"Another value\"},{\"name\":\"setting2\",\""
            + "operation\":\"changed\",\"value1\":200,\"value2\":300},{\"name\":\"setting3\",\"operation\":\""
            + "changed\",\"value1\":true,\"value2\":\"none\"}]";

    @Test
    public void testWithoutFormatter() throws Exception {
        assertEquals(expectedStylish, Differ.generate(pathToJson1, pathToJson2));
    }

    @Test
    public void testJsonToStylish() throws Exception {
        assertEquals(expectedStylish, Differ.generate(pathToJson1, pathToJson2, "stylish"));
    }

    @Test
    public void testYmlToStylish() throws Exception {
        assertEquals(expectedStylish, Differ.generate(pathToYml1, pathToYml2, "stylish"));
    }

    @Test
    public void testJsonToPlain() throws Exception {
        assertEquals(expectedPlain, Differ.generate(pathToJson1, pathToJson2, "plain"));
    }

    @Test
    public void testYmlToPlain() throws Exception {
        assertEquals(expectedPlain, Differ.generate(pathToYml1, pathToYml2, "plain"));
    }

    @Test
    public void testJsonToJson() throws Exception {
        assertEquals(expectedJson, Differ.generate(pathToJson1, pathToJson2, "json"));
    }

    @Test
    public void testYmlToJson() throws Exception {
        assertEquals(expectedJson, Differ.generate(pathToYml1, pathToYml2, "json"));
    }
}
