package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;


public class PlaintextToHtmlConverter {
    private final List<Response> matchers;
    private final newLine newLineMatcher;

    public PlaintextToHtmlConverter() {
        this.matchers = new ArrayList<>(Arrays.asList( new Ampercent(),
                new GreaterThen(),
                new LessThen(),
              //new notMatchedPattern()));
        this.newLineMatcher = new newLine());
    }

    public PlaintextToHtmlConverter(List<Response> matchers, newLine newLineMatcher) {
        this.matchers = matchers;
        this.newLineMatcher = newLineMatcher;
    }

    public String toHtml() throws Exception {
        String text = read();
        return basicHtmlEncode(text);
    }

    protected String read() throws IOException {
        Path filePath = Paths.get("src/test/sample.txt");
        byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();

        for (char characterToConvert: source.toCharArray()) {
            for (Response matcher: matchers) {
                if (matcher.match(characterToConvert)) {
                    matcher.addToList(convertedLine);
                    break;
                }
            }
            if (newLineMatcher.match(characterToConvert)){
                addANewLine(result, convertedLine);
            }
        }

        addANewLine(result, convertedLine);
        return String.join("<br />", result);
    }

    private void addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine.clear();
    }
}