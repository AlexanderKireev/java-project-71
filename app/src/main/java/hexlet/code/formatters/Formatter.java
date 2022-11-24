package hexlet.code.formatters;

public class Formatter {
    public static Format chooseFormatter(String formateName) {
        return switch (formateName) {
            case "plain" -> new Plain();
            case "json" -> new Json();
            default -> new Stylish();
        };
    }
}
