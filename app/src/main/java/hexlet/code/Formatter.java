package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

public class Formatter {
    public static Format chooseFormatter(String formateName) {
        return switch (formateName) {
            case "plain" -> new Plain();
            case "json" -> new Json();
            default -> new Stylish();
        };
    }
}
