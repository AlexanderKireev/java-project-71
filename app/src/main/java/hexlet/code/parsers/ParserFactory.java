package hexlet.code.parsers;

public class ParserFactory {
    public static Parser chooseParser(String fileExtension) {
        switch (fileExtension) {
            case "json" -> {
//                System.out.println("JsonParser()");
                return new JsonParser();
            }
            case "yml" -> {
//                System.out.println("YmlParser()");
                return new YmlParser();
            }
            default -> throw new RuntimeException("Unsupported file extension");
        }
    }
}
