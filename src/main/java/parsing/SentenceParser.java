package parsing;

import entities.Component;
import entities.Composite;
import entities.Leaf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParser{
    private static final String DELIMITER = "[\\s|,]";
    public SentenceParser(Parser successor) {
        super(successor);
    }

    public SentenceParser() {
        super();
    }

    @Override
    public Component parse(String input) {
        List<String> words = Arrays.asList(input.split(DELIMITER));
        List<Component> components = words.stream().map(Leaf::new).collect(Collectors.toList());
        return new Composite(components);
    }
}
