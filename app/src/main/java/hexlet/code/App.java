package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff v.1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Parameters(description = "path to first file.")
    private String filepath1;

    @Parameters(description = "path to second file.")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String formatName = "stylish";

    @Override
    public Integer call() throws Exception {
        try {
            var diff = Differ.generate(filepath1, filepath2, formatName);
            System.out.println(diff);
            return 0;
        } catch (IOException e) {
            System.out.println("Incorrect .json or .yml file format"/* + e.getMessage()*/);
            System.exit(0);
            return null;
        }
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
