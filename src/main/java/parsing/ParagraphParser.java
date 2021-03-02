package parsing;

import entities.Component;
import entities.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser extends AbstractParser {

    public static final String DELIMITER = "[.|!|?]";
    public ParagraphParser(Parser successor) {
        super(successor);
    }

    public Component parse(String input) {
        List<String> sentences = Arrays.asList(input.split(DELIMITER));
        Parser successor = getSuccessor();
        List<Component> components = sentences.stream().map(successor::parse).collect(Collectors.toList());
        return new Composite(components);
    }
}
