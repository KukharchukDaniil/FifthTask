package parsing;

import entities.Component;
import entities.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser extends AbstractParser {
    private final static String SPLITTER = "[\\t\\r]";

    public TextParser(Parser successor) {
        super(successor);
    }

        public Component parse(String input) {
            List<String> paragraphs = Arrays.asList(input.split(SPLITTER));
            Parser successor = getSuccessor();
            List<Component> components = paragraphs.stream().map(successor::parse).collect(Collectors.toList());
            return new Composite(components);
        }
}
